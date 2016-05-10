package me.iBesty.Comandos;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.iBesty.Listener.Array;

public class Reset implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if ((label.equalsIgnoreCase("reset")) && (p.hasPermission("kit.reset"))) {
			Array.hitkill.remove(p.getName());
			Array.reload.remove(p.getName());
			Array.used.remove(p.getName());
			Array.jellyfish.remove(p.getName());
			Array.pvp.remove(p.getName());
			Array.kangaroo.remove(p.getName());
			Array.rider.remove(p.getName());
			Array.grandpa.remove(p.getName());
			Array.anchor.remove(p.getName());
			Array.snail.remove(p.getName());
			Array.viper.remove(p.getName());
			Array.fisherman.remove(p.getName());
			Array.specialist.remove(p.getName());
			Array.phantom.remove(p.getName());
			Array.thor.remove(p.getName());
			Array.viking.remove(p.getName());
			Array.stomper.remove(p.getName());
			Array.hulk.remove(p.getName());
			Array.archer.remove(p.getName());
			Array.gladiator.remove(p.getName());
			Array.pinguim.remove(p.getName());
			Array.instakill.remove(p.getName());
			Array.ninja.remove(p.getName());
			Array.backpacker.remove(p.getName());
			Array.gorila.remove(p.getName());
			Array.endermage.remove(p.getName());
			Array.fujao.remove(p.getName());
			Array.puurga.remove(p.getName());
			Array.critical.remove(p.getName());
			Array.granadier.remove(p.getName());
			Array.darkmage.remove(p.getName());
			p.getInventory().clear();
			p.sendMessage(ChatColor.GOLD + "Utilizando >> " + ChatColor.GRAY + "None");

			ItemStack a = new ItemStack(Material.BLAZE_POWDER);
			ItemMeta aa = a.getItemMeta();
			aa.setDisplayName("-");
			a.setItemMeta(aa);

			ItemStack kits = new ItemStack(Material.ENDER_CHEST);
			ItemMeta kitsm = kits.getItemMeta();
			kitsm.setDisplayName("§4§lKits");

			ArrayList<String> archerlore = new ArrayList<String>();
			archerlore.add("§b-> Clique para abrir o menu de kits! <-");
			kitsm.setLore(archerlore);
			kits.setItemMeta(kitsm);

			p.getInventory().setItem(3, a);
			p.getInventory().setItem(4, kits);
			p.getInventory().setItem(5, a);
		}
		return false;
	}
}
