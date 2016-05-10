package me.iBesty.Kits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.iBesty.Listener.Array;

public class PvP implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		ItemStack dima = new ItemStack(Material.STONE_SWORD);
		dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		if (label.equalsIgnoreCase("pvp")) {
			if (Array.used.contains(p.getName())) {
				p.sendMessage("§cSomente 1 Kit por vida!");
			} else {
				p.getInventory().clear();

				Array.used.add(p.getName());
				Array.pvp.add(p.getName());

				p.sendMessage(ChatColor.GOLD + "Utilizando >> " + ChatColor.GRAY + "PvP");
				p.getInventory().addItem(new ItemStack[] { dima });
				for (int i = 0; i < 37; i++) {
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
				}
			}
		}
		return false;
	}
}
