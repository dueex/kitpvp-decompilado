package me.iBesty.Kits;

import me.iBesty.Listener.Array;
import me.iBesty.Main;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class Archer implements Listener, CommandExecutor {
	public static Main plugin;

	public Archer(Main main) {
		plugin = main;
	}

	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		if (((event.getDamager() instanceof Arrow))
				&& ((((Arrow) event.getDamager()).getShooter() instanceof Player))) {
			Arrow arrow = (Arrow) event.getDamager();
			Player p = (Player) arrow.getShooter();
			p.getLocation().distance(event.getEntity().getLocation());
			if (((event.getEntity() instanceof Player)) && (Array.archer.contains(p.getName()))) {
				p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1.0F, 1.0F);
				event.setDamage(3.0D);
			}
		}
	}

	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		Player p = (Player) sender;
		ItemStack dima = new ItemStack(Material.STONE_SWORD);
		ItemStack arco = new ItemStack(Material.BOW);
		arco.addEnchantment(Enchantment.ARROW_INFINITE, 1);
		arco.addEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
		dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		ItemStack flecha = new ItemStack(Material.ARROW);
		ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		if (cmd.equalsIgnoreCase("archer")) {
			if (Array.used.contains(p.getName())) {
				p.sendMessage("§cSomente 1 Kit por vida!");
				return true;
			}
			if (!p.hasPermission("kit.archer")) {
				p.sendMessage("§c§oVoce nao tem permissao para este kit!");
				return true;
			}
			Array.used.add(p.getName());
			p.sendMessage(ChatColor.GOLD + "Utilizando >> " + ChatColor.GRAY + "Archer");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents(null);
			p.getInventory().clear();
			Array.archer.add(p.getName());
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { arco });
			p.getInventory().addItem(new ItemStack[] { flecha });
			for (int i = 0; i <= 34; i++) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
