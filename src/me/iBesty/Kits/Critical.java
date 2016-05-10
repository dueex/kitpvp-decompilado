package me.iBesty.Kits;

import java.util.Random;
import me.iBesty.Listener.Array;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
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

public class Critical implements Listener, CommandExecutor {
	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		Player p = (Player) sender;
		ItemStack dima = new ItemStack(Material.STONE_SWORD);
		ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		if (cmd.equalsIgnoreCase("critical")) {
			if (Array.used.contains(p.getName())) {
				p.sendMessage("§cSomente 1 Kit por vida!");
				return true;
			}
			if (!p.hasPermission("kit.critical")) {
				p.sendMessage("§c§oVoce nao tem permissao para este kit!");
				return true;
			}
			Array.used.add(p.getName());
			p.setGameMode(GameMode.SURVIVAL);
			p.sendMessage(ChatColor.GOLD + "Utilizando >> " + ChatColor.GRAY + "Critical");
			p.getInventory().setArmorContents(null);
			p.getInventory().clear();
			Array.critical.add(p.getName());
			p.getInventory().addItem(new ItemStack[] { dima });
			for (int i = 0; i <= 34; i++) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}

	@EventHandler
	public void dano(EntityDamageByEntityEvent e) {
		if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))) {
			Player p = (Player) e.getEntity();
			Player d = (Player) e.getDamager();
			if (Array.critical.contains(d.getName())) {
				Random r = new Random();
				int c = r.nextInt(100);
				if (c <= 30) {
					e.setDamage(e.getDamage() + 1.5D);
					p.getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK, 10);
					p.sendMessage(
							ChatColor.RED + "Voce recebeu um golpe critico de " + ChatColor.DARK_RED + d.getName());
					d.sendMessage(
							ChatColor.RED + "Voce aplicou um golpe critico em " + ChatColor.DARK_RED + p.getName());
				}
			}
		}
	}
}
