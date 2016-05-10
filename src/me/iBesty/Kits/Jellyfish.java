package me.iBesty.Kits;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.iBesty.Main;
import me.iBesty.Listener.Array;

public class Jellyfish implements Listener, CommandExecutor {
	public Main plugin;

	public Jellyfish(Main plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		ItemStack dima = new ItemStack(Material.STONE_SWORD);
		dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		if (label.equalsIgnoreCase("jellyfish")) {
			if (Array.used.contains(p.getName())) {
				p.sendMessage("§cSomente 1 Kit por vida!");
			}
			if (!p.hasPermission("kit.jellyfish")) {
				p.sendMessage("§c§oVoce nao tem permissao para este kit!");
				return true;
			}
			p.getInventory().clear();

			Array.used.add(p.getName());
			Array.jellyfish.add(p.getName());

			p.sendMessage(ChatColor.GOLD + "Utilizando >> " + ChatColor.GRAY + "Jellyfish");
			p.getInventory().addItem(new ItemStack[] { dima });
			for (int i = 0; i < 37; i++) {
				p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
			}
		}
		return false;
	}

	ArrayList<Block> naoescorrer = new ArrayList<Block>();

	@EventHandler
	public void colocaragua(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		if ((Array.jellyfish.contains(p.getName())) && (p.getItemInHand().getType() == Material.AIR)
				&& (event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
			Block b = event.getClickedBlock();

			BlockFace lado = event.getBlockFace();
			int x = b.getLocation().getBlockX();
			int y = b.getLocation().getBlockY();
			int z = b.getLocation().getBlockZ();
			if (lado == BlockFace.DOWN) {
				final Block b2 = b.getWorld().getBlockAt(x, y - 1, z);
				if (b2.getType() == Material.AIR) {
					b2.setType(Material.STATIONARY_WATER);
					this.naoescorrer.add(b2);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
						public void run() {
							b2.setType(Material.AIR);
							Jellyfish.this.naoescorrer.remove(b2);
						}
					}, 60L);
				} else {
					p.sendMessage("§cVoce nao pode colocar agua aqui!");
				}
			} else if (lado == BlockFace.UP) {
				final Block b2 = b.getWorld().getBlockAt(x, y + 1, z);
				if (b2.getType() == Material.AIR) {
					b2.setType(Material.STATIONARY_WATER);
					this.naoescorrer.add(b2);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
						public void run() {
							b2.setType(Material.AIR);
							Jellyfish.this.naoescorrer.remove(b2);
						}
					}, 60L);
				} else {
					p.sendMessage("§cVoce nao pode colocar agua aqui!");
				}
			} else if (lado == BlockFace.NORTH) {
				final Block b2 = b.getWorld().getBlockAt(x, y, z - 1);
				if (b2.getType() == Material.AIR) {
					b2.setType(Material.STATIONARY_WATER);
					this.naoescorrer.add(b2);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
						public void run() {
							b2.setType(Material.AIR);
							Jellyfish.this.naoescorrer.remove(b2);
						}
					}, 60L);
				} else {
					p.sendMessage("§cVoce nao pode colocar agua aqui!");
				}
			} else if (lado == BlockFace.SOUTH) {
				final Block b2 = b.getWorld().getBlockAt(x, y, z + 1);
				if (b2.getType() == Material.AIR) {
					b2.setType(Material.STATIONARY_WATER);
					this.naoescorrer.add(b2);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
						public void run() {
							b2.setType(Material.AIR);
							Jellyfish.this.naoescorrer.remove(b2);
						}
					}, 60L);
				} else {
					p.sendMessage("§cVoce nao pode colocar agua aqui!");
				}
			} else if (lado == BlockFace.WEST) {
				final Block b2 = b.getWorld().getBlockAt(x - 1, y, z);
				if (b2.getType() == Material.AIR) {
					b2.setType(Material.STATIONARY_WATER);
					this.naoescorrer.add(b2);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
						public void run() {
							b2.setType(Material.AIR);
							Jellyfish.this.naoescorrer.remove(b2);
						}
					}, 60L);
				} else {
					p.sendMessage("§cVoce nao pode colocar agua aqui!");
				}
			} else if (lado == BlockFace.EAST) {
				final Block b2 = b.getWorld().getBlockAt(x + 1, y, z);
				if (b2.getType() == Material.AIR) {
					b2.setType(Material.STATIONARY_WATER);
					this.naoescorrer.add(b2);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
						public void run() {
							b2.setType(Material.AIR);
							Jellyfish.this.naoescorrer.remove(b2);
						}
					}, 60L);
				} else {
					p.sendMessage("§cVoce nao pode colocar agua aqui!");
				}
			}
		}
	}

	@EventHandler
	public void naoescorrer(BlockPhysicsEvent event) {
		Block b = event.getBlock();
		if ((b.getType() == Material.STATIONARY_WATER) && (this.naoescorrer.contains(b))) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void veneno(PlayerMoveEvent event) {
		Player p = event.getPlayer();
		Block b = p.getLocation().getBlock();
		if (Array.jellyfish.contains(p.getName())) {
			p.removePotionEffect(PotionEffectType.POISON);
		} else if ((b.getType() == Material.STATIONARY_WATER) && (!p.getInventory().contains(Material.CLAY_BALL))
				&& (this.naoescorrer.contains(b))) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 50, 0));
		}
	}
}
