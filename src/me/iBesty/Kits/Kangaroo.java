package me.iBesty.Kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import me.iBesty.Main;
import me.iBesty.Listener.Array;

public class Kangaroo implements Listener {
	public static Main plugin;

	public Kangaroo(Main main) {
		plugin = main;
	}

	ArrayList<Player> kanga = new ArrayList<Player>();
	static List<Player> kangacd = new ArrayList<Player>();

	@EventHandler
	public void onClick(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		if ((p.getItemInHand().getType() == Material.FIREWORK) && (Array.kangaroo.contains(p.getName()))) {
			if ((event.getAction() == Action.LEFT_CLICK_AIR) || (event.getAction() == Action.LEFT_CLICK_BLOCK)
					|| (event.getAction() == Action.RIGHT_CLICK_BLOCK)
					|| (event.getAction() == Action.RIGHT_CLICK_AIR)) {
				event.setCancelled(true);
			}
			if (!this.kanga.contains(p)) {
				if (!p.isSneaking()) {
					p.setFallDistance(-3.0F);
					Vector vector = p.getEyeLocation().getDirection();
					vector.multiply(0.4F);
					vector.setY(1.0F);
					p.setVelocity(vector);
				} else {
					p.setFallDistance(-3.0F);
					Vector vector = p.getEyeLocation().getDirection();
					vector.multiply(1.15F);
					vector.setY(0.55D);
					p.setVelocity(vector);
				}
				this.kanga.add(p);
			}
		}
	}

	@EventHandler
	public void onMover(PlayerMoveEvent event) {
		Player p = event.getPlayer();
		if (this.kanga.contains(p)) {
			Block b = p.getLocation().getBlock();
			if ((b.getType() != Material.AIR) || (b.getRelative(BlockFace.DOWN).getType() != Material.AIR)) {
				this.kanga.remove(p);
			}
		}
	}

	@EventHandler
	public void onDropar(PlayerDropItemEvent event) {
		if (event.getItemDrop().getItemStack().getType() == Material.FIREWORK) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onTomarDano(EntityDamageEvent event) {
		Entity e = event.getEntity();
		if ((e instanceof Player)) {
			Player player = (Player) e;
			if (((event.getEntity() instanceof Player)) && (event.getCause() == EntityDamageEvent.DamageCause.FALL)
					&& (player.getInventory().contains(Material.FIREWORK)) && (event.getDamage() >= 12.0D)) {
				event.setDamage(12.0D);
			}
		}
	}
}
