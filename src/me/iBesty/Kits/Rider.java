package me.iBesty.Kits;

import java.util.HashMap;
import java.util.Iterator;
import me.iBesty.Listener.Array;
import me.iBesty.Main;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Rider implements Listener, CommandExecutor {
	public static Main plugin;
	public static ItemStack[] armorContents;
	public static ItemStack[] inventoryContents;

	public Rider(Main main) {
		plugin = main;
	}

	public int horseHealth = 40;
	public String horseName = "%s";
	public double jumpStrength = 1.0D;
	public boolean modifyHorseStats = true;
	public boolean nameHorse = true;
	public boolean preventOthersFromUsing = true;
	public long cooldownLenght = 0L;
	private HashMap<Player, Horse> horses = new HashMap<Player, Horse>();
	public double runSpeed = 1.0D;

	@EventHandler
	public void onClick888(InventoryClickEvent event) {
		if ((event.getCurrentItem() != null) && (event.getCurrentItem().getType() == Material.SADDLE)
				&& (event.getWhoClicked().getVehicle() != null)
				&& (this.horses.containsValue(event.getWhoClicked().getVehicle()))) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onEntityDeath(EntityDeathEvent event) {
		if (this.horses.containsValue(event.getEntity())) {
			event.setDroppedExp(0);
			Iterator<Player> itel = this.horses.keySet().iterator();
			while (itel.hasNext()) {
				if (this.horses.get(itel.next()) == event.getEntity()) {
					itel.remove();
				}
			}
		}
	}

	@EventHandler
	public void onInteract4(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		if ((event.getAction() == Action.RIGHT_CLICK_AIR) && (p.getItemInHand().getType() == Material.SADDLE)) {
			if (this.horses.containsKey(p)) {
				Horse horse = (Horse) this.horses.remove(p);
				if (!horse.isDead()) {
					horse.eject();
					horse.leaveVehicle();
					horse.remove();
				}
			} else {
				Horse horse = (Horse) p.getWorld().spawnEntity(p.getLocation(), EntityType.HORSE);
				this.horses.put(p, horse);
				if (this.nameHorse) {
					horse.setCustomName(
							String.format(this.horseName, new Object[] { "§4Cavalo de §a" + p.getName() }));
					horse.setCustomNameVisible(true);
				}
				horse.setBreed(false);
				horse.setTamed(true);
				horse.setDomestication(horse.getMaxDomestication());
				horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));

				horse.setOwner(p);
				if (this.modifyHorseStats) {
					horse.setJumpStrength(this.jumpStrength);
					horse.setMaxHealth(this.horseHealth);
					horse.setHealth(this.horseHealth);
					horse.setColor(Horse.Color.WHITE);
				}
			}
		}
	}

	@EventHandler
	public void onRightClick1(PlayerInteractEntityEvent event) {
		if ((this.preventOthersFromUsing) && (this.horses.containsValue(event.getRightClicked()))) {
			for (Player p : this.horses.keySet()) {
				if ((this.horses.get(p) == event.getRightClicked()) && (event.getPlayer() != p)) {
					event.setCancelled(true);
					break;
				}
			}
		}
	}

	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		Player p = (Player) sender;
		ItemStack dima = new ItemStack(Material.STONE_SWORD);
		ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		ItemStack rider = new ItemStack(Material.SADDLE);
		dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		if (cmd.equalsIgnoreCase("rider")) {
			if (Array.used.contains(p.getName())) {
				p.sendMessage("§cSomente 1 Kit por vida!");
				return true;
			}
			if (!p.hasPermission("kit.rider")) {
				return true;
			}
			Array.used.add(p.getName());
			p.sendMessage(ChatColor.GOLD + "Utilizando >> " + ChatColor.GRAY + "Rider");
			p.getInventory().setArmorContents(null);
			p.getInventory().clear();
			p.setGameMode(GameMode.SURVIVAL);
			Array.rider.add(p.getName());
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { rider });
			for (int i = 0; i <= 34; i++) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
