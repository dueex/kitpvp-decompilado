package me.iBesty.Kits;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.FireworkEffect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerLeashEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import me.iBesty.Main;
import me.iBesty.Listener.Array;

public class Grappler1 implements CommandExecutor, Listener {
	public static Main plugin;

	public Grappler1(Main main) {
		plugin = main;
	}

	Map<Player, CordaGrappler> hooks = new HashMap<Player, CordaGrappler>();

	@EventHandler
	public void onSlot(PlayerItemHeldEvent e) {
		if (this.hooks.containsKey(e.getPlayer())) {
			((CordaGrappler) this.hooks.get(e.getPlayer())).remove();
			this.hooks.remove(e.getPlayer());
		}
	}

	@EventHandler
	public void grapplerDamageNoLeash(EntityDamageEvent event) {
		if (!(event.getEntity() instanceof Player)) {
			return;
		}
		Player player = (Player) event.getEntity();
		if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
			return;
		}
		if ((this.hooks.containsKey(player)) && (((CordaGrappler) this.hooks.get(player)).isHooked())
				&& (event.getDamage() > 3.0D)) {
			event.setDamage(3.0D);
		}
	}

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		if ((this.hooks.containsKey(e.getPlayer()))
				&& (!e.getPlayer().getItemInHand().getType().equals(Material.LEASH))) {
			((CordaGrappler) this.hooks.get(e.getPlayer())).remove();
			this.hooks.remove(e.getPlayer());
		}
	}

	@EventHandler
	public void onLeash(PlayerLeashEntityEvent e) {
		Player p = e.getPlayer();
		if (e.getPlayer().getItemInHand().getType().equals(Material.LEASH)) {
			e.setCancelled(true);
			e.getPlayer().updateInventory();
			e.setCancelled(true);
			if (!this.hooks.containsKey(p)) {
				return;
			}
			if (!((CordaGrappler) this.hooks.get(p)).isHooked()) {
				return;
			}
			double d = ((CordaGrappler) this.hooks.get(p)).getBukkitEntity().getLocation().distance(p.getLocation());
			double t = d;
			double v_x = (1.0D + 0.07000000000000001D * t)
					* (((CordaGrappler) this.hooks.get(p)).getBukkitEntity().getLocation().getX()
							- p.getLocation().getX())
					/ t;
			double v_y = (1.0D + 0.03D * t)
					* (((CordaGrappler) this.hooks.get(p)).getBukkitEntity().getLocation().getY()
							- p.getLocation().getY())
					/ t;
			double v_z = (1.0D + 0.07000000000000001D * t)
					* (((CordaGrappler) this.hooks.get(p)).getBukkitEntity().getLocation().getZ()
							- p.getLocation().getZ())
					/ t;

			Vector v = p.getVelocity();
			v.setX(v_x);
			v.setY(v_y);
			v.setZ(v_z);
			p.setVelocity(v);

			p.getWorld().playSound(p.getLocation(), Sound.STEP_GRAVEL, 1.0F, 1.0F);
		}
	}

	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (e.getPlayer().getItemInHand().getType().equals(Material.LEASH)) {
			e.setCancelled(true);
			if ((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK)) {
				if (this.hooks.containsKey(p)) {
					((CordaGrappler) this.hooks.get(p)).remove();
				}
				CordaGrappler nmsHook = new CordaGrappler(p.getWorld(), ((CraftPlayer) p).getHandle());
				nmsHook.spawn(p.getEyeLocation().add(p.getLocation().getDirection().getX(),
						p.getLocation().getDirection().getY(), p.getLocation().getDirection().getZ()));
				nmsHook.move(p.getLocation().getDirection().getX() * 5.0D, p.getLocation().getDirection().getY() * 5.0D,
						p.getLocation().getDirection().getZ() * 5.0D);
				this.hooks.put(p, nmsHook);
			} else {
				if (!this.hooks.containsKey(p)) {
					return;
				}
				if (!((CordaGrappler) this.hooks.get(p)).isHooked()) {
					return;
				}
				double d = ((CordaGrappler) this.hooks.get(p)).getBukkitEntity().getLocation()
						.distance(p.getLocation());
				double t = d;
				double v_x = (1.0D + 0.2D * t)
						* (((CordaGrappler) this.hooks.get(p)).getBukkitEntity().getLocation().getX()
								- p.getLocation().getX())
						/ t;
				double v_y = (1.0D + 0.03D * t)
						* (((CordaGrappler) this.hooks.get(p)).getBukkitEntity().getLocation().getY()
								- p.getLocation().getY())
						/ t;
				double v_z = (1.0D + 0.2D * t)
						* (((CordaGrappler) this.hooks.get(p)).getBukkitEntity().getLocation().getZ()
								- p.getLocation().getZ())
						/ t;

				Vector v = p.getVelocity();
				v.setX(v_x);
				v.setY(v_y);
				v.setZ(v_z);
				p.setVelocity(v);

				p.getWorld().playSound(p.getLocation(), Sound.STEP_GRAVEL, 1.0F, 1.0F);
			}
		}
	}

	private Method world_getHandle = null;
	private Method nms_world_broadcastEntityEffect = null;
	private Method firework_getHandle = null;

	public void playFirework(World paramWorld, Location paramLocation, FireworkEffect paramFireworkEffect)
			throws Exception {
		throw new Error("Nao decompile gay!");
	}

	@SuppressWarnings("unused")
	private static Method getMethod(Class<?> cl, String method) {
		for (Method m : cl.getMethods()) {
			if (m.getName().equals(method)) {
				return m;
			}
		}
		return null;
	}

	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		Player p = (Player) sender;
		ItemStack dima = new ItemStack(Material.STONE_SWORD);
		ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		ItemStack grappler = new ItemStack(Material.LEASH);
		if (cmd.equalsIgnoreCase("grappler")) {
			if (Array.used.contains(p.getName())) {
				p.sendMessage("§cSomente 1 Kit por vida!");
				return true;
			}
			if (!p.hasPermission("kit.grappler")) {
				p.sendMessage("§c§oVoce nao tem permissao para este kit!");
				return true;
			}
			Array.used.add(p.getName());
			Array.grappler.add(p.getName());
			p.sendMessage(ChatColor.GOLD + "Utilizando >> " + ChatColor.GRAY + "Grappler");
			p.getInventory().setArmorContents(null);
			p.getInventory().clear();
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { grappler });
			for (int i = 0; i <= 34; i++) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}

	public Method getNms_world_broadcastEntityEffect() {
		return nms_world_broadcastEntityEffect;
	}

	public void setNms_world_broadcastEntityEffect(Method nms_world_broadcastEntityEffect) {
		this.nms_world_broadcastEntityEffect = nms_world_broadcastEntityEffect;
	}

	public Method getWorld_getHandle() {
		return world_getHandle;
	}

	public void setWorld_getHandle(Method world_getHandle) {
		this.world_getHandle = world_getHandle;
	}

	public Method getFirework_getHandle() {
		return firework_getHandle;
	}

	public void setFirework_getHandle(Method firework_getHandle) {
		this.firework_getHandle = firework_getHandle;
	}
}
