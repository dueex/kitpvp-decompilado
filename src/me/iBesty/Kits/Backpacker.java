package me.iBesty.Kits;

import java.util.ArrayList;
import java.util.List;

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
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.iBesty.Main;
import me.iBesty.Listener.Array;

public class Backpacker implements Listener, CommandExecutor {
	public static Main plugin;

	public Backpacker(Main main) {
		plugin = main;
	}

	static List<Player> cooldownbk = new ArrayList<Player>();

	@EventHandler
	public void backpackerKit(PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		ItemMeta sopas = sopa.getItemMeta();
		sopas.setDisplayName("§6§oSopa");
		sopa.setItemMeta(sopas);
		if ((p.getItemInHand().getType() == Material.LEATHER) && (Array.backpacker.contains(p.getName()))) {
			if ((event.getAction() == Action.RIGHT_CLICK_BLOCK) || (event.getAction() == Action.RIGHT_CLICK_AIR)) {
				event.setCancelled(true);
			}
			if (cooldownbk.contains(p)) {
				p.sendMessage("ComDown");
			} else {
				Inventory v = Bukkit.createInventory(null, 27, "§e§oBackpack");
				for (int i = 0; i < 27; i++) {
					v.addItem(new ItemStack[] { new ItemStack(sopa) });
				}
				event.getPlayer().openInventory(v);
				cooldownbk.add(p);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
						Backpacker.cooldownbk.remove(p);
						p.sendMessage("§1Voce pode usar novamente!");
					}
				}, 750L);
			}
		}
	}

	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		Player p = (Player) sender;
		ItemStack dima = new ItemStack(Material.STONE_SWORD);
		ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		ItemStack backpacker = new ItemStack(Material.LEATHER);
		dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		if (cmd.equalsIgnoreCase("refiller")) {
			if (Array.used.contains(p.getName())) {
				p.sendMessage("§cSomente 1 Kit por vida!");
				return true;
			}
			if (!p.hasPermission("kit.refiller")) {
				p.sendMessage("§c§oVoce nao tem permissao para este kit!");
				return true;
			}
			Array.used.add(p.getName());
			Array.backpacker.add(p.getName());
			p.sendMessage(ChatColor.GOLD + "Utilizando >> " + ChatColor.GRAY + "Refiller");
			p.getInventory().setArmorContents(null);
			p.getInventory().clear();
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { backpacker });
			for (int i = 0; i <= 34; i++) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
