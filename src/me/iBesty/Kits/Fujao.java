package me.iBesty.Kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.iBesty.Main;
import me.iBesty.Listener.Array;

public class Fujao implements Listener, CommandExecutor {
	public static Main plugin;

	public Fujao(Main main) {
		plugin = main;
	}

	static List<Player> cooldownm = new ArrayList<Player>();

	@SuppressWarnings("deprecation")
	@EventHandler
	public void stomperApple(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		if ((event.getPlayer().getItemInHand().getType() == Material.SLIME_BALL)
				&& (Array.fujao.contains(event.getPlayer().getName()))) {
			if ((event.getAction() == Action.LEFT_CLICK_AIR) || (event.getAction() == Action.LEFT_CLICK_BLOCK)
					|| (event.getAction() == Action.RIGHT_CLICK_BLOCK)
					|| (event.getAction() == Action.RIGHT_CLICK_AIR)) {
				event.setCancelled(true);
			}
			if (cooldownm.contains(p)) {
				p.sendMessage("§cAguarde o cooldown acabar!");
				return;
			}
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 35, 10));
			p.getWorld().playSound(p.getLocation(), Sound.ARROW_HIT, 5.0F, -5.0F);
			cooldownm.add(p);
			Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, Fujao1.FujaoFuncao(this, p),

					500L);
		}
	}

	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		Player p = (Player) sender;
		ItemStack dima = new ItemStack(Material.STONE_SWORD);
		ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		ItemStack archer = new ItemStack(Material.SLIME_BALL);
		dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		if (cmd.equalsIgnoreCase("fujao")) {
			if (Array.used.contains(p.getName())) {
				p.sendMessage("§cSomente 1 Kit por vida!");
				return true;
			}
			if (!p.hasPermission("kit.fujao")) {
				p.sendMessage("§c§oVoce nao tem permissao para este kit!");
				return true;
			}
			Array.used.add(p.getName());
			p.setGameMode(GameMode.SURVIVAL);
			p.sendMessage(ChatColor.GOLD + "Utilizando >> " + ChatColor.GRAY + "Fujao");
			p.getInventory().setArmorContents(null);
			p.getInventory().clear();
			Array.fujao.add(p.getName());
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { archer });
			for (int i = 0; i <= 34; i++) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
