package me.iBesty.Listener;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

public class QuandoEntrar implements Listener {
	ArrayList<String> a1 = new ArrayList<String>();
	ArrayList<String> a2 = new ArrayList<String>();

	@EventHandler
	public void WarpsSelector(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((p.getItemInHand().getType() == Material.PAPER)
				&& ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)
						|| (e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK))) {
			p.playSound(p.getLocation(), Sound.NOTE_BASS, 5.0F, 5.0F);
			Bukkit.dispatchCommand(p, "warps");
		}
	}

	@EventHandler
	public void KitSelector(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((p.getItemInHand().getType() == Material.ENDER_CHEST)
				&& ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)
						|| (e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK))) {
			p.playSound(p.getLocation(), Sound.NOTE_BASS, 5.0F, 5.0F);
			Bukkit.dispatchCommand(p, "kit");
		}
	}

	@EventHandler
	public void noPlace(BlockPlaceEvent e) {
		if (e.getBlock().getType() == Material.ENDER_CHEST) {
			e.setCancelled(true);
		}
		if (e.getBlock().getType() == Material.COMPASS) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void noPlace(PlayerDropItemEvent e) {
		if (e.getItemDrop().getItemStack().getType() == Material.ENDER_CHEST) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.PAPER) {
			e.setCancelled(true);
			return;
		}
		if (e.getItemDrop().getItemStack().getType() == Material.BLAZE_POWDER) {
			e.setCancelled(true);
			return;
		}
	}

	public void tp(Player a, Location loc) {
		this.a1.add(a.getName());
		Player p = a;
		Location loc1 = loc;
		this.a1.remove(p.getName());
		p.sendMessage(ChatColor.GREEN + "Teleportado com sucesso!");
		p.teleport(loc1);
	}

	@EventHandler
	public void quandoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		Array.hitkill.remove(p.getName());
		Array.reload.remove(p.getName());
		Array.used.remove(p.getName());
		Array.jellyfish.remove(p.getName());
		Array.pvp.remove(p.getName());
		Array.kangaroo.remove(p.getName());
		Array.rider.remove(p.getName());
		Array.grandpa.remove(p.getName());
		Array.anchor.remove(p.getName());
		Array.snail.remove(p.getName());
		Array.puurga.remove(p.getName());
		Array.viper.remove(p.getName());
		Array.fisherman.remove(p.getName());
		Array.specialist.remove(p.getName());
		Array.phantom.remove(p.getName());
		Array.thor.remove(p.getName());
		Array.viking.remove(p.getName());
		Array.stomper.remove(p.getName());
		Array.hulk.remove(p.getName());
		Array.archer.remove(p.getName());
		Array.gladiator.remove(p.getName());
		Array.pinguim.remove(p.getName());
		Array.instakill.remove(p.getName());
		Array.ninja.remove(p.getName());
		Array.backpacker.remove(p.getName());
		Array.gorila.remove(p.getName());
		Array.endermage.remove(p.getName());
		Array.fujao.remove(p.getName());
		Array.critical.remove(p.getName());
		Array.granadier.remove(p.getName());
		Array.darkmage.remove(p.getName());

		p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
		p.removePotionEffect(PotionEffectType.SPEED);
		p.removePotionEffect(PotionEffectType.JUMP);
		p.removePotionEffect(PotionEffectType.INVISIBILITY);

		p.getInventory().clear();
		p.setFoodLevel(20);

		World world = p.getWorld();
		Location loc = new Location(world, -674.0D, 92.0D, -1143.0D);

		tp(p, loc);

		ItemStack a = new ItemStack(Material.BLAZE_POWDER);
		ItemMeta aa = a.getItemMeta();
		aa.setDisplayName("§6§lBem-Vindo!");
		a.setItemMeta(aa);

		ItemStack kits = new ItemStack(Material.ENDER_CHEST);
		ItemMeta kitsm = kits.getItemMeta();
		kitsm.setDisplayName("§4§lKits");
		ArrayList<String> archerlore = new ArrayList<String>();
		archerlore.add("§b-> MenuDeKits!");
		kitsm.setLore(archerlore);
		kits.setItemMeta(kitsm);

		ItemStack warps = new ItemStack(Material.PAPER);
		ItemMeta warpsm = warps.getItemMeta();
		warpsm.setDisplayName("§9§lWarps");
		ArrayList<String> warpslore = new ArrayList<String>();
		warpslore.add("§b-> MenuDeWarps!");
		warpsm.setLore(warpslore);
		warps.setItemMeta(warpsm);

		p.getInventory().setItem(2, a);
		p.getInventory().setItem(3, kits);
		p.getInventory().setItem(4, a);
		p.getInventory().setItem(5, warps);
		p.getInventory().setItem(6, a);
	}

	@EventHandler
	public void quandoRespawn(PlayerRespawnEvent e) {
		Player p = e.getPlayer();

		p.setMaxHealth(20.0D);
		p.setHealth(20.0D);
		ItemStack a = new ItemStack(Material.BLAZE_POWDER);
		ItemMeta aa = a.getItemMeta();
		aa.setDisplayName("§6§lBem-Vindo!");
		a.setItemMeta(aa);

		ItemStack kits = new ItemStack(Material.ENDER_CHEST);
		ItemMeta kitsm = kits.getItemMeta();
		kitsm.setDisplayName("§4§lKits");
		ArrayList<String> archerlore = new ArrayList<String>();
		archerlore.add("§b-> MenuDeKits!");
		kitsm.setLore(archerlore);
		kits.setItemMeta(kitsm);

		ItemStack warps = new ItemStack(Material.PAPER);
		ItemMeta warpsm = warps.getItemMeta();
		warpsm.setDisplayName("§9§lWarps");
		ArrayList<String> warpslore = new ArrayList<String>();
		warpslore.add("§b-> MenuDeWarps!");
		warpsm.setLore(warpslore);
		warps.setItemMeta(warpsm);

		p.getInventory().setItem(2, a);
		p.getInventory().setItem(3, kits);
		p.getInventory().setItem(4, a);
		p.getInventory().setItem(5, warps);
		p.getInventory().setItem(6, a);
	}

	@EventHandler
	public void onHit(EntityDamageByEntityEvent event) {
		if (((event.getEntity() instanceof Player)) && ((event.getDamager() instanceof Player))) {
			Player p = (Player) event.getDamager();
			ItemStack[] armor = p.getInventory().getArmorContents();
			p.getItemInHand().setDurability((short) -p.getItemInHand().getType().getMaxDurability());
			if (armor.length > 0) {
				for (int i = 0; i < armor.length; i++) {
					armor[i].setDurability((short) -armor[i].getType().getMaxDurability());
				}
			}
		}
	}
}
