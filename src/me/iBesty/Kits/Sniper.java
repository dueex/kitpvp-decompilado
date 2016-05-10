package me.iBesty.Kits;

import me.iBesty.Listener.Array;
import me.iBesty.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class Sniper implements Listener, CommandExecutor {
	private Main plugin;

	public Sniper(Main instance) {
		this.plugin = instance;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		ItemStack dima = new ItemStack(Material.STONE_SWORD);
		dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		if (label.equalsIgnoreCase("sniper")) {
			if (Array.used.contains(p.getName())) {
				p.sendMessage("§cSomente 1 Kit por vida!");
			}
			if (!p.hasPermission("kit.sniper")) {
				p.sendMessage("§c§oVoce nao tem permissao para este kit!");
				return true;
			}
			p.getInventory().clear();

			Array.used.add(p.getName());
			Array.sniper.add(p.getName());

			p.sendMessage(ChatColor.GOLD + "Utilizando >> " + ChatColor.GRAY + "Sniper");
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.BOW) });
			for (int i = 0; i < 37; i++) {
				p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
			}
		}
		return false;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerInteract(PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (Array.sniper.contains(p.getName())) {
			if (e.getAction() != Action.RIGHT_CLICK_AIR) {
				return;
			}
			if (e.getItem().getType() != Material.BOW) {
				return;
			}
			Vector velo1 = p.getLocation().getDirection().normalize().multiply(2);
			velo1.add(new Vector(Math.random() * 0.0D - 0.0D, -0.0D, 0.0D));
			if (Array.reload.contains(p.getName())) {
				p.sendMessage(ChatColor.RED + "Recarregando!");
			} else {
				p.playSound(p.getLocation(), Sound.ARROW_HIT, 50.0F, 1.0F);
				((Arrow) p.launchProjectile(Arrow.class)).setVelocity(velo1);
				p.sendMessage(ChatColor.RED + "VocÃª sÃ³ poderar usar Novamente depois Alguns Segundos!");
				Array.reload.add(p.getName());
				p.setExp(0.0F);
				p.setLevel(0);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
					public void run() {
						if (Array.sniper.contains(p.getName())) {
							p.giveExp(2);
							p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
						}
					}
				}, 20L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
					public void run() {
						if (Array.sniper.contains(p.getName())) {
							p.giveExp(2);
							p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
						}
					}
				}, 40L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
					public void run() {
						if (Array.sniper.contains(p.getName())) {
							p.giveExp(2);
							p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
						}
					}
				}, 60L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
					public void run() {
						if (Array.sniper.contains(p.getName())) {
							p.giveExp(2);
							p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
						}
					}
				}, 80L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
					public void run() {
						if (Array.sniper.contains(p.getName())) {
							p.giveExp(2);
							p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
						}
					}
				}, 100L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
					public void run() {
						if (Array.sniper.contains(p.getName())) {
							p.giveExp(2);
							p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
						}
					}
				}, 120L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
					public void run() {
						if (Array.sniper.contains(p.getName())) {
							p.giveExp(2);
							p.playSound(p.getLocation(), Sound.CLICK, 1.0F, 1.0F);
						}
					}
				}, 140L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
					public void run() {
						if (Array.sniper.contains(p.getName())) {
							p.setExp(1.0F);
							p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1.0F, 1.0F);
							Array.reload.remove(p.getName());
							p.sendMessage(ChatColor.GOLD + "Recarregado!");
						}
					}
				}, 160L);
			}
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onEntityDamage(EntityDamageByEntityEvent e) {
		if ((e.getDamager() instanceof Arrow)) {
			Arrow s = (Arrow) e.getDamager();
			Player damaged = (Player) e.getEntity();
			if ((s.getShooter() instanceof Player)) {
				Player shooter = (Player) s.getShooter();
				if (shooter.getItemInHand().getType() == Material.BOW) {
					e.setDamage(6.0D);
					damaged.getLocation().getWorld().playEffect(damaged.getLocation(), Effect.STEP_SOUND,
							Material.REDSTONE_WIRE);
				}
			}
		}
	}
}
