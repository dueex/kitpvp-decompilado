package me.iBesty.Kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import me.iBesty.Listener.Array;
import me.iBesty.Main;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class Gladiator implements Listener, CommandExecutor {
	public static Main plugin;

	public Gladiator(Main main) {
		plugin = main;
	}

	public ArrayList<String> inPvP = new ArrayList<String>();
	public Map<String, Location> local = new HashMap<String, Location>();

	@EventHandler
	public void removeOnTp(PlayerTeleportEvent e) {
		Player player = e.getPlayer();
		if (this.inPvP.contains(player.getName())) {
			this.inPvP.remove(player.getName());
		}
	}

	public void limpar(Location loc) {
		int x = 0;
		int y = 0;
		int z = 0;
		for (x = -7; x < 7; x++) {
			for (z = -7; z < 7; z++) {
				for (y = 0; y < 7; y++) {
					Block b = loc.clone().add(x, 0.0D, z).getBlock();
					Block b2 = loc.clone().add(x, 7.0D, z).getBlock();
					Block b3 = loc.clone().add(-7.0D, y, z).getBlock();
					Block b4 = loc.clone().add(x, y, -7.0D).getBlock();
					Block b5 = loc.clone().add(x, y, 7.0D).getBlock();
					Block b6 = loc.clone().add(7.0D, y, z).getBlock();

					b.setType(Material.AIR);
					b2.setType(Material.AIR);
					b3.setType(Material.AIR);
					b4.setType(Material.AIR);
					b5.setType(Material.AIR);
					b6.setType(Material.AIR);
				}
			}
		}
	}

	public void generateArena(Location loc, Player gladiator, Player target) {
		int x = 0;
		int y = 0;
		int z = 0;
		for (x = -7; x < 7; x++) {
			for (z = -7; z < 7; z++) {
				for (y = 0; y < 7; y++) {
					Block b = loc.clone().add(x, 0.0D, z).getBlock();
					Block b2 = loc.clone().add(x, 7.0D, z).getBlock();
					Block b3 = loc.clone().add(-7.0D, y, z).getBlock();
					Block b4 = loc.clone().add(x, y, -7.0D).getBlock();
					Block b5 = loc.clone().add(x, y, 7.0D).getBlock();
					Block b6 = loc.clone().add(7.0D, y, z).getBlock();
					b.setType(Material.GLASS);
					b2.setType(Material.GLASS);
					b3.setType(Material.GLASS);
					b4.setType(Material.GLASS);
					b5.setType(Material.GLASS);
					b6.setType(Material.GLASS);
				}
			}
		}
		gladiator.teleport(loc.clone().add(x - 1, y - 2, -4.0D));
		gladiator.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 120, 6));
		target.sendMessage("Boa Sorte");
		target.teleport(loc.clone().add(-4.0D, y - 4, z - 1));
		target.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 120, 6));
		gladiator.sendMessage("Boa Sorte !");
	}

	@EventHandler
	public void place(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if ((p.getItemInHand().getType() == Material.IRON_FENCE) && (Array.gladiator.contains(p.getName()))) {
			e.setCancelled(true);
			p.updateInventory();
		}
	}

	@EventHandler
	public void place(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (this.inPvP.contains(p.getName())) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void PlayerInteractEntityEvent(PlayerInteractEntityEvent event) {
		final Player player = event.getPlayer();
		if ((player.getItemInHand().getType() == Material.IRON_FENCE) && (Array.gladiator.contains(player.getName()))) {
			final Player player2 = (Player) event.getRightClicked();
			Location pLoc = player.getLocation();
			if ((!this.inPvP.contains(player.getName())) && (!this.inPvP.contains(player2.getName()))) {
				this.local.put(player.getName(), pLoc);
				this.local.put(player2.getName(), player2.getLocation());

				Location GladLoc = player.getLocation();
				final Location GladiatorA = new Location(player.getWorld(), GladLoc.getBlockX(),
						GladLoc.getWorld().getHighestBlockYAt(GladLoc) + 120, GladLoc.getBlockZ());

				generateArena(GladiatorA, player2, player);
				new BukkitRunnable() {
					int tempo = 120;

					public void run() {
						this.tempo -= 1;
						if (!Gladiator.this.inPvP.contains(player.getName())) {
							Gladiator.this.inPvP.add(player.getName());
						}
						if (!Gladiator.this.inPvP.contains(player2.getName())) {
							Gladiator.this.inPvP.add(player2.getName());
						}
						if ((player.isDead()) || (player2.isDead()) || (!player.isOnline()) || (!player2.isOnline()) ||

								(!Gladiator.this.inPvP.contains(player.getName())) ||

								(!Gladiator.this.inPvP.contains(player2.getName()))) {
							Gladiator.this.inPvP.remove(player.getName());
							Gladiator.this.inPvP.remove(player2.getName());

							Gladiator.this.limpar(GladiatorA);

							cancel();
							if (player.isOnline()) {
								player.teleport((Location) Gladiator.this.local.get(player.getName()));
								Gladiator.this.local.remove(player.getName());
								if (player.hasPotionEffect(PotionEffectType.WITHER)) {
									player.removePotionEffect(PotionEffectType.WITHER);
								}
							}
							if (player2.isOnline()) {
								player2.teleport((Location) Gladiator.this.local.get(player2.getName()));
								Gladiator.this.local.remove(player2.getName());
								if (player2.hasPotionEffect(PotionEffectType.WITHER)) {
									player2.removePotionEffect(PotionEffectType.WITHER);
								}
							}
						} else {
							if (this.tempo == 60) {
								if ((!player.isDead()) && (player.isOnline())
										&& (Gladiator.this.inPvP.contains(player.getName()))) {
									player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 999999, 5));
								}
								if ((!player2.isDead()) && (player2.isOnline())
										&& (Gladiator.this.inPvP.contains(player2.getName()))) {
									player2.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 999999, 5));
								}
							}
							if (this.tempo == 0) {
								Gladiator.this.inPvP.remove(player.getName());
								Gladiator.this.inPvP.remove(player2.getName());

								Gladiator.this.limpar(GladiatorA);

								cancel();
								if ((!player.isDead()) && (player.isOnline())) {
									player.teleport((Location) Gladiator.this.local.get(player.getName()));
									if (player.hasPotionEffect(PotionEffectType.WITHER)) {
										player.removePotionEffect(PotionEffectType.WITHER);
									}
									Gladiator.this.local.remove(player2);
								}
								if ((!player2.isDead()) && (player2.isOnline())) {
									player2.teleport((Location) Gladiator.this.local.get(player2.getName()));
									if (player2.hasPotionEffect(PotionEffectType.WITHER)) {
										player2.removePotionEffect(PotionEffectType.WITHER);
									}
									Gladiator.this.local.remove(player2);
								}
							}
						}
					}
				}.runTaskTimer(plugin, 0L, 20L);
			}
		}
	}

	@EventHandler
	public void death(PlayerDeathEvent e) {
		if ((e.getEntity() instanceof Player)) {
			Player p = e.getEntity();
			if ((p.getKiller() instanceof Player)) {
				Player killer = p.getKiller();
				if (this.inPvP.contains(p.getName())) {
					p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 120, 6));
					killer.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 120, 6));
					this.inPvP.remove(p.getName());
					if (this.inPvP.contains(killer.getName())) {
						this.inPvP.remove(killer.getName());
					}
				}
			}
		}
	}

	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		Player p = (Player) sender;
		ItemStack dima = new ItemStack(Material.STONE_SWORD);
		ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		ItemStack gladiator = new ItemStack(Material.IRON_FENCE);
		dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		if (cmd.equalsIgnoreCase("gladiator")) {
			if (Array.used.contains(p.getName())) {
				p.sendMessage("§cSomente 1 Kit por vida!");
				return true;
			}
			if (!p.hasPermission("kit.gladiator")) {
				p.sendMessage("§c§oVoce nao tem permissao para este kit!");
				return true;
			}
			Array.used.add(p.getName());
			Array.gladiator.add(p.getName());
			p.sendMessage(ChatColor.GOLD + "Utilizando >> " + ChatColor.GRAY + "Gladiator");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents(null);
			p.getInventory().clear();
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { gladiator });
			for (int i = 0; i <= 34; i++) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
