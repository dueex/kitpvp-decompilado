package me.iBesty.Kits;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.iBesty.Listener.Array;

public class Pinguim implements Listener, CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		ItemStack dima = new ItemStack(Material.STONE_SWORD);
		dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		if (label.equalsIgnoreCase("pinguim")) {
			if (Array.used.contains(p.getName())) {
				p.sendMessage("§cSomente 1 Kit por vida!");
			}
			if (!p.hasPermission("kit.pinguim")) {
				p.sendMessage("§c§oVoce nao tem permissao para este kit!");
				return true;
			}
			p.getInventory().clear();

			Array.used.add(p.getName());
			Array.pinguim.add(p.getName());

			p.sendMessage(ChatColor.GOLD + "Utilizando >> " + ChatColor.GRAY + "Pinguim");
			p.getInventory().addItem(new ItemStack[] { dima });
			for (int i = 0; i < 37; i++) {
				p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
			}
		}
		return false;
	}

	@EventHandler
	public void berserkerEvent(PlayerDeathEvent event) {
		if (!(event.getEntity().getKiller() instanceof Player)) {
			return;
		}
		if (event.getEntity().getKiller() == null) {
			return;
		}
		Player player = event.getEntity().getKiller();
		if (Array.pinguim.contains(player.getName())) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 300, 2));
			player.sendMessage("§2Corra pequeno pinguim branco!");
		}
	}
}
