package me.iBesty.Listener;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.potion.PotionEffectType;

import me.iBesty.Main;

public class Nerfs implements Listener {
	private Main plugin;

	public Nerfs(Main plugin) {
		this.setPlugin(plugin);
	}

	@EventHandler
	public void Hunger(FoodLevelChangeEvent event) {
		if ((event.getEntity() instanceof Player)) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onDamageByEntity(EntityDamageByEntityEvent event) {
		if ((event.getDamager() instanceof Player)) {
			Player player = (Player) event.getDamager();
			if (event.getDamage() > 1.0D) {
				event.setDamage(event.getDamage() - 1.0D);
			}
			if ((event.getDamager() instanceof Player)) {
				if ((player.getFallDistance() > 0.0F) && (!((CraftPlayer)player).isOnGround())
						&& (!player.hasPotionEffect(PotionEffectType.BLINDNESS))) {
					int NewDamage = (int) (event.getDamage() * 2.5D) - (int) event.getDamage();
					if (event.getDamage() > 1.0D) {
						event.setDamage(event.getDamage() - NewDamage);
					}
				}
				if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
					event.setDamage(4.5D);
				}
				if (player.getItemInHand().getType() == Material.STONE_SWORD) {
					event.setDamage(4.5D);
				}
				if (player.getItemInHand().getType() == Material.IRON_SWORD) {
					event.setDamage(4.5D);
				}
				if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
					event.setDamage(4.5D);
				}
				if (player.getItemInHand().getType() == Material.STONE_AXE) {
					event.setDamage(4.5D);
				}
				if (player.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL)) {
					event.setDamage(event.getDamage() + 0.0D);
				}
				if ((player.getFallDistance() > 0.0F) && (!((CraftPlayer)player).isOnGround())
						&& (!player.hasPotionEffect(PotionEffectType.BLINDNESS))) {
					if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
						event.setDamage(event.getDamage() + 0.0D);
					}
					if (player.getItemInHand().getType() == Material.STONE_SWORD) {
						event.setDamage(event.getDamage() + 0.0D);
					}
					if (player.getItemInHand().getType() == Material.IRON_SWORD) {
						event.setDamage(event.getDamage() + 0.0D);
					}
					if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
						event.setDamage(event.getDamage() + 0.0D);
					}
				}
			}
		}
	}

	public Main getPlugin() {
		return plugin;
	}

	public void setPlugin(Main plugin) {
		this.plugin = plugin;
	}
}
