package me.iBesty.Listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.inventory.ItemStack;

import me.iBesty.Main;

public class KillsStreak implements Listener {
	Main plugin;

	public KillsStreak(Main plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onKillLevel(PlayerDeathEvent event) {
		if (!(event.getEntity().getKiller() instanceof Player)) {
			return;
		}
		if (event.getEntity().getKiller() == null) {
			return;
		}
		Player p = event.getEntity();
		Player k = p.getKiller();

		k.setLevel(k.getLevel() + 1);
		p.setLevel(0);
	}

	@EventHandler
	public void onLevel(PlayerLevelChangeEvent e) {
		Player p = e.getPlayer();
		if (e.getNewLevel() == 5) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " ß7conseguiu um Killstreak de ßc5ß7!");
			p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
			p.sendMessage("ßbVoce ganhou uma bota por ter feito um killstreak de 5!");
		}
		if (e.getNewLevel() == 10) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " ß7conseguiu um Killstreak de ßc10ß7!");
		}
		if (e.getNewLevel() == 15) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " ß7conseguiu um Killstreak de ßc15ß6!");
			p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
			p.sendMessage("ßbVoce ganhou um capacete por ter feito um killstreak de 15!");
		}
		if (e.getNewLevel() == 20) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " ß7conseguiu um Killstreak de ßc20ß7!");
		}
		if (e.getNewLevel() == 30) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " ß7conseguiu um Killstreak de ßc30ß7!");
			p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
			p.sendMessage("ßbVoce ganhou uma cal√ßa por ter feito um killstreak de 30!");
		}
		if (e.getNewLevel() == 40) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " ß7conseguiu um Killstreak de ßc40ß7!");
		}
		if (e.getNewLevel() == 50) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " ß7conseguiu um Killstreak de ßc50ß7!");
		}
		if (e.getNewLevel() == 60) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " ß7conseguiu um Killstreak de ßc60ß7!");
			p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
			p.sendMessage("ßbVoce ganhou um peitoral por ter feito um killstreak de 60!");
		}
		if (e.getNewLevel() == 70) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " ß7conseguiu um Killstreak de ßc70ß7!");
		}
		if (e.getNewLevel() == 80) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " ß7conseguiu um Killstreak de ßc80ß7!");
		}
		if (e.getNewLevel() == 90) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " ß7conseguiu um Killstreak de ßc90ß7!");
		}
		if (e.getNewLevel() == 100) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " ß7conseguiu um Killstreak de ßc100ß7!");
		}
		if (e.getNewLevel() == 150) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " ß7conseguiu um Killstreak de ßc150ß7!");
		}
		if (e.getNewLevel() == 200) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " ß7conseguiu um Killstreak de ßc200ß7!");
		}
		if (e.getNewLevel() == 250) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " ß7conseguiu um Killstreak de ßc250ß7!");
		}
		if (e.getNewLevel() == 300) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " ß7conseguiu um Killstreak de ßc300ß7!");
		}
		if (e.getNewLevel() == 350) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " ß7conseguiu um Killstreak de ßc350ß7!");
		}
		if (e.getNewLevel() == 400) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " ß7conseguiu um Killstreak de ßc400ß7!");
		}
		if (e.getNewLevel() == 450) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " ß7conseguiu um Killstreak de ßc450ß7!");
		}
		if (e.getNewLevel() == 500) {
			Bukkit.getServer()
					.broadcastMessage(ChatColor.RED + p.getDisplayName() + " ß7conseguiu um Killstreak de ßc500ß7!");
			p.getInventory().setHelmet(new ItemStack(Material.LEATHER_HELMET));
			p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
			p.getInventory().setLeggings(new ItemStack(Material.LEATHER_LEGGINGS));
			p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
			p.sendMessage("ßbVoce ganhou um FULL COURO por ter feito um killstreak de 500!");
		}
		if (e.getNewLevel() == 1000) {
			Bukkit.getServer().broadcastMessage(
					ChatColor.RED + p.getDisplayName() + " ß7conseguiu um Killstreak de ßc1000ß7!");
		}
		if (e.getNewLevel() == 1500) {
			Bukkit.getServer().broadcastMessage(
					ChatColor.RED + p.getDisplayName() + " ß7conseguiu um Killstreak de ßc1500ß7!");
		}
		if (e.getNewLevel() == 2000) {
			Bukkit.getServer().broadcastMessage(
					ChatColor.RED + p.getDisplayName() + " ß7conseguiu um Killstreak de ßc2000ß7!");
		}
	}
}
