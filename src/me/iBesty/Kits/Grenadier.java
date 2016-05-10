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
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

public class Grenadier implements Listener, CommandExecutor {
	public static Main plugin;

	public Grenadier(Main main) {
		plugin = main;
	}

	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		Player p = (Player) sender;
		ItemStack dima = new ItemStack(Material.STONE_SWORD);
		ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		ItemStack granada = new ItemStack(Material.SNOW_BALL, 16);
		dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		if (cmd.equalsIgnoreCase("granadier")) {
			if (Array.used.contains(p.getName())) {
				p.sendMessage("§cSomente 1 Kit por vida!");
				return true;
			}
			if (!p.hasPermission("kit.granadier")) {
				p.sendMessage("§c§oVoce nao tem permissao para este kit!");
				return true;
			}
			Array.used.add(p.getName());
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents(null);
			p.getInventory().clear();
			p.sendMessage(ChatColor.GOLD + "Utilizando >> " + ChatColor.GRAY + "Granadier");
			Array.granadier.add(p.getName());
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { granada });
			for (int i = 0; i <= 34; i++) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}

	@EventHandler
	public void lancar(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
				&& (Array.granadier.contains(p.getName())) && (p.getItemInHand().getType() == Material.SNOW_BALL)) {
			e.setCancelled(true);
			p.updateInventory();
			p.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.SNOW_BALL, 1) });
			Snowball granada = (Snowball) p.launchProjectile(Snowball.class);
			granada.setMetadata("granadier", new FixedMetadataValue(plugin, Boolean.valueOf(true)));
			p.playSound(p.getLocation(), Sound.FUSE, 1.0F, 1.0F);
			p.sendMessage(ChatColor.GOLD + "Granada jogada!");
			return;
		}
	}

	@EventHandler
	public void explosao(ProjectileHitEvent e) {
		if ((e.getEntity() instanceof Snowball)) {
			Snowball b = (Snowball) e.getEntity();
			if (b.hasMetadata("granadier")) {
				b.getWorld().createExplosion(b.getLocation(), 0.0F);
			}
			return;
		}
	}

	@EventHandler
	public void dano(EntityDamageEvent e) {
		if ((e.getEntity() instanceof Player)) {
			Player p = (Player) e.getEntity();
			if ((e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)
					&& (Array.granadier.contains(p.getName()))) {
				e.setCancelled(true);
			}
		}
	}
}
