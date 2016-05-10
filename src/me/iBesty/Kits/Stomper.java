package me.iBesty.Kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import me.iBesty.Main;
import me.iBesty.Listener.Array;
import net.minecraft.server.v1_8_R3.EntityPlayer;

public class Stomper implements Listener, CommandExecutor {
	public static Main plugin;

	public Stomper(Main main) {
		plugin = main;
	}

	static List<Player> cooldownm = new ArrayList<Player>();

	@EventHandler
	public void stomperEvent(EntityDamageEvent event) {
		if (!(event.getEntity() instanceof Player)) {
			return;
		}
		Player player = (Player) event.getEntity();
		if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
			event.getDamage();
			return;
		}
		if (!Array.stomper.contains(player.getName())) {
			return;
		}
		if (event.getDamage() > 8.0D) {
			event.setDamage(8.0D);
		}
		for (Entity stomped : player.getNearbyEntities(5.0D, 5.0D, 5.0D)) {
			if (!(stomped instanceof Player)) {
				return;
			}
			if (!((Player) stomped).isSneaking()) {
				((Player) stomped).damage(player.getFallDistance(), player);
				Player st = (Player) stomped;
				EntityPlayer p = ((CraftPlayer) st).getHandle();
				if (p.getHealth() - player.getFallDistance() < 1.0F) {
					Location loc = player.getLocation();
					player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0F, -5.0F);
					player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0F, -3.0F);
					player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0F, -1.0F);
					player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0F, 1.0F);
					player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0F, 3.0F);
					player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0F, 5.0F);
				}
			} else {
				((Player) stomped).damage(player.getFallDistance() / 3.0F, player);
				Player st = (Player) stomped;
				EntityPlayer p = ((CraftPlayer) st).getHandle();
				if (p.getHealth() - player.getFallDistance() / 4.0F < 1.0F) {
					Location loc = player.getLocation();
					player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0F, -5.0F);
					player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0F, -3.0F);
					player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0F, -1.0F);
					player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0F, 1.0F);
					player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0F, 3.0F);
					player.getWorld().playSound(loc, Sound.DIG_STONE, 5.0F, 5.0F);
				}
			}
		}
	}

	@EventHandler
	public void stomperApple(PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if ((event.getPlayer().getItemInHand().getType() == Material.GOLDEN_APPLE)
				&& (Array.stomper.contains(event.getPlayer().getName()))) {
			if ((event.getAction() == Action.LEFT_CLICK_AIR) || (event.getAction() == Action.LEFT_CLICK_BLOCK)
					|| (event.getAction() == Action.RIGHT_CLICK_BLOCK)
					|| (event.getAction() == Action.RIGHT_CLICK_AIR)) {
				event.setCancelled(true);
			}
			if (cooldownm.contains(p)) {
				p.sendMessage("§cAguarde o cooldown acabar!");
				return;
			}
			Vector vector = p.getEyeLocation().getDirection();
			vector.multiply(0.0F);
			vector.setY(6.0F);
			p.setVelocity(vector);
			Location loc = p.getLocation();
			p.getWorld().playSound(loc, Sound.ENDERMAN_TELEPORT, 5.0F, -5.0F);
			cooldownm.add(p);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					Stomper.cooldownm.remove(p);
					p.sendMessage("§1Voce pode usar novamente!");
				}
			}, 1000L);
		}
	}

	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		Player p = (Player) sender;
		ItemStack dima = new ItemStack(Material.STONE_SWORD);
		ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		ItemStack archer = new ItemStack(Material.GOLDEN_APPLE);
		dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		if (cmd.equalsIgnoreCase("stomper")) {
			if (Array.used.contains(p.getName())) {
				p.sendMessage("§cSomente 1 Kit por vida!");
				return true;
			}
			if (!p.hasPermission("kit.stomper")) {
				p.sendMessage("§c§oVoce nao tem permissao para este kit!");
				return true;
			}
			Array.used.add(p.getName());
			p.setGameMode(GameMode.SURVIVAL);
			p.sendMessage(ChatColor.GOLD + "Utilizando >> " + ChatColor.GRAY + "Stomper");
			p.getInventory().setArmorContents(null);
			p.getInventory().clear();
			Array.stomper.add(p.getName());
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { archer });
			for (int i = 0; i <= 34; i++) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
