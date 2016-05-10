package me.iBesty.Kits;

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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.iBesty.Main;
import me.iBesty.Listener.Array;

public class Snail implements Listener, CommandExecutor {
	public static Main plugin;

	public Snail(Main main) {
		plugin = main;
	}

	@EventHandler
	public void snailEvent(EntityDamageByEntityEvent event) {
		if ((!(event.getEntity() instanceof Player)) || (!(event.getDamager() instanceof Player))) {
			return;
		}
		Player player = (Player) event.getDamager();
		Player player1 = (Player) event.getEntity();
		if (!Array.snail.contains(player.getName())) {
			return;
		}
		if ((Math.random() > 0.4D) && (Math.random() < 0.1D)) {
			player1.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 1));
		}
	}

	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		Player p = (Player) sender;
		ItemStack dima = new ItemStack(Material.STONE_SWORD);
		ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		if (cmd.equalsIgnoreCase("snail")) {
			if (Array.used.contains(p.getName())) {
				p.sendMessage("§cSomente 1 Kit por vida!");
				return true;
			}
			if (!p.hasPermission("kit.snail")) {
				p.sendMessage("§c§oVoce nao tem permissao para este kit!");
				return true;
			}
			Array.used.add(p.getName());
			p.sendMessage(ChatColor.GOLD + "Utilizando >> " + ChatColor.GRAY + "Snail");
			p.setGameMode(GameMode.SURVIVAL);
			Array.snail.add(p.getName());
			p.getInventory().setArmorContents(null);
			p.getInventory().clear();
			p.getInventory().addItem(new ItemStack[] { dima });
			for (int i = 0; i <= 34; i++) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
