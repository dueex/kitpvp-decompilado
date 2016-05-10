package me.iBesty.Kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import me.iBesty.Main;
import me.iBesty.Listener.Array;

public class Hulk implements Listener {
	public static Main plugin;

	public Hulk(Main main) {
		plugin = main;
	}

	static List<Player> cooldown = new ArrayList<Player>();

	@EventHandler
	public void hulk(PlayerInteractEntityEvent event) {
		if (!(event.getRightClicked() instanceof Player)) {
			return;
		}
		ItemStack hulk = new ItemStack(Material.BONE);
		ItemMeta name323 = hulk.getItemMeta();
		name323.setDisplayName("§2§oHulk's Bone");
		hulk.setItemMeta(name323);
		final Player player = event.getPlayer();
		Player clicked = (Player) event.getRightClicked();
		if (!Array.hulk.contains(player.getName())) {
			return;
		}
		if (player.getItemInHand().getType() != Material.BONE) {
			return;
		}
		if (cooldown.contains(player)) {
			player.sendMessage("§cCooldown Aguarde!");
		} else {
			if ((player.getPassenger() == null) && (clicked.getPassenger() == null)) {
				player.setPassenger(clicked);
			}
			cooldown.add(player);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					Hulk.cooldown.remove(player);
					player.sendMessage("§1Voce pode usar novamente!");
				}
			}, 500L);
		}
	}

	@EventHandler
	public void hulkSmash(EntityDamageByEntityEvent event) {
		if (!(event.getDamager() instanceof Player)) {
			return;
		}
		if (!(event.getEntity() instanceof Player)) {
			return;
		}
		final Player player = (Player) event.getEntity();
		Player damager = (Player) event.getDamager();
		if (damager.getPassenger() != null) {
			if (!Array.hulk.contains(damager.getName())) {
				return;
			}
			event.setCancelled(true);
			player.setSneaking(true);
			Vector vec = player.getLocation().getDirection().multiply(2.0F);
			vec.setY(2.0D);
			player.setVelocity(vec);
			plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
				public void run() {
					player.setSneaking(false);
				}
			}, 1000L);
		}
	}
}
