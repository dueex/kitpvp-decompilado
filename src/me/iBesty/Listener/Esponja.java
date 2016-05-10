package me.iBesty.Listener;

import java.util.ArrayList;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import me.iBesty.Main;

public class Esponja implements Listener {
	Main main;

	public Esponja(Main plugin) {
		plugin = this.main;
	}

	public static ArrayList<String> jump = new ArrayList<String>();

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerJump(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.PISTON_BASE) {
			jump.remove(p.getName());
			Vector sponge = p.getLocation().getDirection().multiply(0).setY(4);
			p.setVelocity(sponge);
			p.getWorld().playEffect(p.getLocation(), Effect.POTION_BREAK, 1);
			p.getWorld().playEffect(p.getLocation(), Effect.POTION_BREAK, 1);
			p.getWorld().playSound(p.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
			jump.add(p.getName());
			jump.remove(p.getName());
			jump.add(p.getName());
			return;
		}
	}

	@EventHandler
	public void onPlayerDamageSponge(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		Player p = (Player) e.getEntity();
		if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
			return;
		}
		if (jump.contains(p.getName())) {
			jump.remove(p.getName());
			return;
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onEntityDamageSponge(EntityDamageEvent event) {
		if ((event.getEntity() instanceof Player)) {
			Player player = (Player) event.getEntity();
			Location loc = player.getLocation();
			Location below = loc.subtract(0.0D, 1.0D, 0.0D);
			Block blockBelow = below.getBlock();
			if (event.getCause() == EntityDamageEvent.DamageCause.FALL) {
				if (blockBelow.getType() == Material.PISTON_BASE) {
					jump.add(player.getName());
					event.setDamage(0.0D);
					return;
				}
				return;
			}
			return;
		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerSpongeDamage(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		Player p = (Player) e.getEntity();
		if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
			if (jump.contains(p.getName())) {
				jump.remove(p.getName());
				e.setDamage(0.0D);
				return;
			}
			return;
		}
	}

	ArrayList<String> nofalldamage = new ArrayList<String>();
	ArrayList<String> nofalldamagewait = new ArrayList<String>();

	@EventHandler
	public void onPlayerFrente(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.DIAMOND_BLOCK) {
			Vector sponge = p.getLocation().getDirection().multiply(2.5D).setY(0.25D);
			p.setVelocity(sponge);
			if (!this.nofalldamage.contains(p.getName())) {
				this.nofalldamage.add(p.getName());
			}
			return;
		}
	}

	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
		if ((event.getEntity() instanceof Player)) {
			Player player = (Player) event.getEntity();
			if ((this.nofalldamage.contains(player.getName()))
					&& (event.getCause().equals(EntityDamageEvent.DamageCause.FALL))) {
				event.setCancelled(true);
				this.nofalldamage.remove(player.getName());
			}
		}
	}
}
