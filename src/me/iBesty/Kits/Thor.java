package me.iBesty.Kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.iBesty.Main;
import me.iBesty.Listener.Array;

public class Thor implements Listener, CommandExecutor {
	public static Main plugin;

	public Thor(Main main) {
		plugin = main;
	}

	static List<Player> cooldown = new ArrayList<Player>();

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerInteract(PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((Array.thor.contains(p.getName()))
				&& ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))) {
			ItemStack hand = p.getItemInHand();
			if (hand.getType() == Material.GOLD_AXE) {
				if (cooldown.contains(p)) {
					p.sendMessage(ChatColor.RED + "Cooldown");
				} else {
					Location loc = p.getEyeLocation();
					p.getWorld().strikeLightning(loc);
					cooldown.add(p);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
						public void run() {
							Thor.cooldown.remove(p);
							p.sendMessage("§cVoce pode usar novamente!");
						}
					}, 80L);
				}
			}
		}
	}

	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		Player p = (Player) sender;
		ItemStack dima = new ItemStack(Material.STONE_SWORD);
		ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		ItemStack thor = new ItemStack(Material.GOLD_AXE);
		dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		if (cmd.equalsIgnoreCase("thor")) {
			if (Array.used.contains(p.getName())) {
				p.sendMessage("§cSomente 1 Kit por vida!");
				return true;
			}
			if (!p.hasPermission("kit.thor")) {
				p.sendMessage("§c§oVoce nao tem permissao para este kit!");
				return true;
			}
			Array.used.add(p.getName());
			Array.thor.add(p.getName());
			p.sendMessage(ChatColor.GOLD + "Utilizando >> " + ChatColor.GRAY + "Thor");

			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents(null);
			p.getInventory().clear();
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { thor });
			for (int i = 0; i <= 34; i++) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
