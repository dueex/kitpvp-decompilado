package me.iBesty.Kits;

import java.util.Random;
import me.iBesty.Listener.Array;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Puurga implements Listener, CommandExecutor {
	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent e) {
		if (((e.getDamager() instanceof Player)) && ((e.getEntity() instanceof LivingEntity))) {
			LivingEntity entity = (LivingEntity) e.getEntity();
			Player p = (Player) e.getDamager();
			if (Array.puurga.contains(p.getName())) {
				Random rand = new Random();
				int percent = rand.nextInt(100);
				if (percent <= 33) {
					entity.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 220, 0));
					return;
				}
				return;
			}
			return;
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		ItemStack dima = new ItemStack(Material.STONE_SWORD);
		dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		if (label.equalsIgnoreCase("puurga")) {
			if (Array.used.contains(p.getName())) {
				p.sendMessage("§cSomente 1 Kit por vida!");
			}
			if (!p.hasPermission("kit.puurga")) {
				p.sendMessage("§c§oVoce nao tem permissao para este kit!");
				return true;
			}
			p.getInventory().clear();

			Array.used.add(p.getName());
			Array.puurga.add(p.getName());

			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 120000000, 3));

			p.sendMessage(ChatColor.GOLD + "Utilizando >> " + ChatColor.GRAY + "Puurga");
			p.getInventory().addItem(new ItemStack[] { dima });
			for (int i = 0; i < 37; i++) {
				p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
			}
		}
		return false;
	}
}
