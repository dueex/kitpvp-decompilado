package me.iBesty.Eventos;

import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.iBesty.Main;

public class Sopa implements Listener {
	public Sopa(Main plugin) {
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onSoupDrink(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (p.getItemInHand().getType() != Material.MUSHROOM_SOUP) {
			return;
		}
		Damageable d = p;
		if (d.getHealth() == d.getMaxHealth()) {
			return;
		}
		if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
			if (d.getHealth() > d.getMaxHealth() - 7.0D) {
				d.setHealth(d.getMaxHealth());
			} else {
				d.setHealth(d.getHealth() + 7.0D);
			}
			p.getItemInHand().setAmount(1);
			p.getItemInHand().setType(Material.BOWL);
		}
	}
}
