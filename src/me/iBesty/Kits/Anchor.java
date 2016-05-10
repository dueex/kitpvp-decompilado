package me.iBesty.Kits;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import me.iBesty.Main;
import me.iBesty.Listener.Array;

public class Anchor implements Listener, CommandExecutor {
	public static Main plugin;

	public Anchor(Main main) {
		plugin = main;
	}

	@EventHandler
	public void damage(EntityDamageByEntityEvent e) {
		if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))) {
			final Player p = (Player) e.getEntity();
			Player d = (Player) e.getDamager();
			if (Array.anchor.contains(d.getName())) {
				p.setVelocity(new Vector());
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
						p.setVelocity(new Vector());
					}
				}, 1L);
			}
		}
	}

	@EventHandler
	public void AnchorKiller(EntityDamageByEntityEvent e) {
		if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))) {
			final Player p = (Player) e.getEntity();
			if (Array.anchor.contains(p.getName())) {
				p.setVelocity(new Vector());
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
						p.setVelocity(new Vector());
					}
				}, 1L);
			}
		}
	}

	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		Player p = (Player) sender;
		ItemStack dima = new ItemStack(Material.STONE_SWORD);
		dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		if (cmd.equalsIgnoreCase("anchor")) {
			if (Array.used.contains(p.getName())) {
				p.sendMessage("§cSomente 1 Kit por vida!");
				return true;
			}
			if (!p.hasPermission("kit.anchor")) {
				p.sendMessage("§c§oVoce nao tem permissao para este kit!");
				return true;
			}
			Array.used.add(p.getName());
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents(null);
			p.getInventory().clear();
			p.sendMessage(ChatColor.GOLD + "Utilizando >> " + ChatColor.GRAY + "Anchor");
			Array.anchor.add(p.getName());
			p.getInventory().addItem(new ItemStack[] { dima });
			for (int i = 0; i <= 34; i++) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
