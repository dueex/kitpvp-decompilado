package me.iBesty.Kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import me.iBesty.Main;
import me.iBesty.Listener.Array;

public class Phantom implements Listener, CommandExecutor {
	public static Main plugin;

	public Phantom(Main main) {
		plugin = main;
	}

	static List<String> cooldown = new ArrayList<String>();

	@EventHandler
	public void onInteractPhantom(PlayerInteractEvent event) {
		ItemStack chest = new ItemStack(Material.LEATHER_HELMET, 1);
		LeatherArmorMeta chestp = (LeatherArmorMeta) chest.getItemMeta();
		chestp.setColor(Color.WHITE);
		chest.setItemMeta(chestp);
		ItemStack chest1 = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
		LeatherArmorMeta chestp1 = (LeatherArmorMeta) chest1.getItemMeta();
		chestp1.setColor(Color.WHITE);
		chest1.setItemMeta(chestp1);
		ItemStack calca = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		LeatherArmorMeta chestp11 = (LeatherArmorMeta) calca.getItemMeta();
		chestp11.setColor(Color.WHITE);
		calca.setItemMeta(chestp11);
		ItemStack chest11 = new ItemStack(Material.LEATHER_BOOTS, 1);
		LeatherArmorMeta chestp111 = (LeatherArmorMeta) chest11.getItemMeta();
		chestp111.setColor(Color.WHITE);
		chest11.setItemMeta(chestp111);
		if ((event.getPlayer().hasPermission("kit.phantom")) && (event.getAction().name().contains("RIGHT"))
				&& (event.getPlayer().getItemInHand().getType() == Material.FEATHER)
				&& (Array.phantom.contains(event.getPlayer().getName()))) {
			final Player p = event.getPlayer();
			if (cooldown.contains(p.getName())) {
				return;
			}
			cooldown.add(p.getName());
			p.setAllowFlight(true);
			p.setFlying(true);
			p.getInventory().setHelmet(new ItemStack(chest));
			p.getInventory().setChestplate(new ItemStack(chest1));
			p.getInventory().setLeggings(new ItemStack(calca));
			p.getInventory().setBoots(new ItemStack(chest11));
			p.updateInventory();
			p.sendMessage("§6§oVoce pode voar!");

			int i = 5;
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
				}
			}, i);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
				}
			}, i + 20);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					p.sendMessage(ChatColor.GREEN + "Voce tem 3 segundos de voo pouse logo!");
				}
			}, i + 40);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					p.sendMessage(ChatColor.GREEN + "Voce tem 2 segundos de voo vai murre!");
				}
			}, i + 60);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					p.sendMessage(ChatColor.GREEN + "Voce tem 1 segundos de voo ;-; i murreu!");
				}
			}, i + 80);

			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					p.setAllowFlight(false);
					p.sendMessage("§4§lVoce nao pode voar mais");
					p.getInventory().setHelmet(null);
					p.getInventory().setChestplate(null);
					p.getInventory().setLeggings(null);
					p.getInventory().setBoots(null);
					p.updateInventory();
				}
			}, 100L);

			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					Phantom.cooldown.remove(p.getName());
					p.sendMessage("§a§oVoce pode usar agora!");
				}
			}, 800L);
		}
	}

	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		Player p = (Player) sender;
		ItemStack dima = new ItemStack(Material.STONE_SWORD);
		ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		ItemStack phantom = new ItemStack(Material.FEATHER);
		dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		if (cmd.equalsIgnoreCase("phantom")) {
			if (Array.used.contains(p.getName())) {
				p.sendMessage("§cSomente 1 Kit por vida!");
				return true;
			}
			if (!p.hasPermission("kit.phantom")) {
				p.sendMessage("§c§oVoce nao tem permissao para este kit!");
				return true;
			}
			Array.used.add(p.getName());
			Array.phantom.add(p.getName());
			p.sendMessage(ChatColor.GOLD + "Utilizando >> " + ChatColor.GRAY + "Phantom");

			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents(null);
			p.getInventory().clear();
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { phantom });
			for (int i = 0; i <= 34; i++) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
