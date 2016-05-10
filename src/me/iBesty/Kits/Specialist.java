package me.iBesty.Kits;

import me.iBesty.Listener.Array;
import me.iBesty.Main;
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
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Specialist implements Listener, CommandExecutor {
	public static Main plugin;

	public Specialist(Main main) {
		plugin = main;
	}

	@EventHandler
	public void specialistDeath(PlayerDeathEvent event) {
		if (event.getEntity().getKiller() == null) {
			return;
		}
		if (!(event.getEntity() instanceof Player)) {
			return;
		}
		if (!(event.getEntity().getKiller() instanceof Player)) {
			return;
		}
		Player k = event.getEntity().getKiller();
		if (Array.specialist.contains(k.getName())) {
			k.getInventory().addItem(new ItemStack[] { new ItemStack(Material.EXP_BOTTLE, 1) });
		}
	}

	@EventHandler
	public void enchant(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		if ((Array.specialist.contains(p.getName())) && (p.getItemInHand().getType() == Material.BOOK)) {
			p.openEnchanting(p.getLocation(), true);
		}
	}

	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		Player p = (Player) sender;
		ItemStack dima = new ItemStack(Material.STONE_SWORD);
		ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		ItemStack specialist = new ItemStack(Material.BOOK);
		dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		if (cmd.equalsIgnoreCase("specialist")) {
			if (Array.used.contains(p.getName())) {
				p.sendMessage("§cSomente 1 Kit por vida!");
				return true;
			}
			if (!p.hasPermission("kit.specialist")) {
				p.sendMessage("§c§oVoce nao tem permissao para este kit!");
				return true;
			}
			Array.used.add(p.getName());
			p.sendMessage(ChatColor.GOLD + "Utilizando >> " + ChatColor.GRAY + "Specialist");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents(null);
			p.getInventory().clear();
			Array.specialist.add(p.getName());
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { specialist });
			for (int i = 0; i <= 34; i++) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
