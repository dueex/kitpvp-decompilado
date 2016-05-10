package me.iBesty.Kits;

import me.iBesty.Listener.Array;
import me.iBesty.Main;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

public class Fisherman implements Listener, CommandExecutor {
	public static Main plugin;

	public Fisherman(Main main) {
		plugin = main;
	}

	@EventHandler
	public void onPlayerFish(PlayerFishEvent event) {
		Entity caught = event.getCaught();
		Block block = event.getHook().getLocation().getBlock();
		if ((caught != null) && (caught != block) && (Array.fisherman.contains(event.getPlayer().getName()))) {
			caught.teleport(event.getPlayer().getLocation());
		}
	}

	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		Player p = (Player) sender;
		ItemStack dima = new ItemStack(Material.STONE_SWORD);
		ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		ItemStack fisherman = new ItemStack(Material.FISHING_ROD);
		if (cmd.equalsIgnoreCase("fisherman")) {
			if (Array.used.contains(p.getName())) {
				p.sendMessage("§cSomente 1 Kit por vida!");
				return true;
			}
			if (!p.hasPermission("kit.fisherman")) {
				p.sendMessage("§c§oVoce nao tem permissao para este kit!");
				return true;
			}
			Array.used.add(p.getName());
			Array.fisherman.add(p.getName());
			p.sendMessage(ChatColor.GOLD + "Utilizando >> " + ChatColor.GRAY + "Fisherman");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents(null);
			p.getInventory().clear();
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { fisherman });
			for (int i = 0; i <= 34; i++) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
