package me.iBesty.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.iBesty.Main;

public class KitVip implements CommandExecutor, Listener {
	public KitVip(Main plugin) {
	}

	@EventHandler
	public void onClickKit(InventoryClickEvent e) {
		if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {
			Inventory inv = e.getInventory();
			Player p = (Player) e.getWhoClicked();
			if (inv.getTitle().equals("§4§lKits Vip")) {
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 5.0F, 5.0F);
				e.setCancelled(true);
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4HitKill")) {
					Bukkit.dispatchCommand(p, "hitkill");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4JellyFish")) {
					Bukkit.dispatchCommand(p, "jellyfish");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Rider")) {
					Bukkit.dispatchCommand(p, "rider");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Grandpa")) {
					Bukkit.dispatchCommand(p, "grandpa");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Anchor")) {
					Bukkit.dispatchCommand(p, "anchor");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6§l§oVirar")) {
					Bukkit.dispatchCommand(p, "kit");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Snail")) {
					Bukkit.dispatchCommand(p, "snail");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Viper")) {
					Bukkit.dispatchCommand(p, "viper");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Specialist")) {
					Bukkit.dispatchCommand(p, "specialist");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Phantom")) {
					Bukkit.dispatchCommand(p, "phantom");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Thor")) {
					Bukkit.dispatchCommand(p, "thor");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Viking")) {
					Bukkit.dispatchCommand(p, "viking");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Stomper")) {
					Bukkit.dispatchCommand(p, "stomper");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Hulk")) {
					Bukkit.dispatchCommand(p, "hulk");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Gladiator")) {
					Bukkit.dispatchCommand(p, "gladiator");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Pinguim")) {
					Bukkit.dispatchCommand(p, "pinguim");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Ninja")) {
					Bukkit.dispatchCommand(p, "ninja");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Endermage")) {
					Bukkit.dispatchCommand(p, "endermage");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Refiller")) {
					Bukkit.dispatchCommand(p, "refiller");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Grappler")) {
					Bukkit.dispatchCommand(p, "grappler");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Puurga - Kit Dedicado")) {
					Bukkit.dispatchCommand(p, "puurga");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Critical")) {
					Bukkit.dispatchCommand(p, "critical");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Granadier")) {
					Bukkit.dispatchCommand(p, "granadier");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4DarkMage")) {
					Bukkit.dispatchCommand(p, "darkmage");
					p.closeInventory();
				}
			}
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (label.equalsIgnoreCase("kitvip")) {
			Inventory kits = Bukkit.getServer().createInventory(p, 54, "§4§lKits Vip");

			ItemStack vinha = new ItemStack(Material.THIN_GLASS);
			ItemMeta vm = vinha.getItemMeta();
			vm.setDisplayName("§2§o§lKits");
			vinha.setItemMeta(vm);

			ItemStack carpete = new ItemStack(Material.CARPET);
			ItemMeta carpetem = carpete.getItemMeta();
			carpetem.setDisplayName("§6§l§oVirar");
			carpete.setItemMeta(carpetem);

			ItemStack polvora = new ItemStack(Material.SULPHUR);
			ItemMeta polvoram = polvora.getItemMeta();
			polvoram.setDisplayName("§4§l§oKits");
			polvora.setItemMeta(polvoram);

			ItemStack jelly = new ItemStack(Material.CLAY_BALL);
			ItemMeta jellym = jelly.getItemMeta();
			jellym.setDisplayName("§4JellyFish");
			jelly.setItemMeta(jellym);

			ItemStack hit = new ItemStack(Material.EYE_OF_ENDER);
			ItemMeta hitm = hit.getItemMeta();
			hitm.setDisplayName("§4HitKill");
			hit.setItemMeta(hitm);

			ItemStack pvp = new ItemStack(Material.STONE_SWORD);
			ItemMeta pvpm = pvp.getItemMeta();
			pvpm.setDisplayName("§4PvP");
			pvp.setItemMeta(pvpm);

			ItemStack kanga = new ItemStack(Material.FIREWORK);
			ItemMeta kangam = kanga.getItemMeta();
			kangam.setDisplayName("§4Kangaroo");
			kanga.setItemMeta(kangam);

			ItemStack rider = new ItemStack(Material.SADDLE);
			ItemMeta riderm = rider.getItemMeta();
			riderm.setDisplayName("§4Rider");
			rider.setItemMeta(riderm);

			ItemStack grand = new ItemStack(Material.STICK);
			ItemMeta grandm = grand.getItemMeta();
			grandm.setDisplayName("§4Grandpa");
			grand.setItemMeta(grandm);

			ItemStack anchor = new ItemStack(Material.ANVIL);
			ItemMeta anchorm = anchor.getItemMeta();
			anchorm.setDisplayName("§4Anchor");
			anchor.setItemMeta(anchorm);

			ItemStack snail = new ItemStack(Material.STRING);
			ItemMeta snailm = snail.getItemMeta();
			snailm.setDisplayName("§4Snail");
			snail.setItemMeta(snailm);

			ItemStack viper = new ItemStack(Material.SPIDER_EYE);
			ItemMeta viperm = viper.getItemMeta();
			viperm.setDisplayName("§4Viper");
			viper.setItemMeta(viperm);

			ItemStack fish = new ItemStack(Material.FISHING_ROD);
			ItemMeta fishm = fish.getItemMeta();
			fishm.setDisplayName("§4Fisherman");
			fish.setItemMeta(fishm);

			ItemStack special = new ItemStack(Material.EXP_BOTTLE);
			ItemMeta specialm = special.getItemMeta();
			specialm.setDisplayName("§4Specialist");
			special.setItemMeta(specialm);

			ItemStack phan = new ItemStack(Material.FEATHER);
			ItemMeta phanm = phan.getItemMeta();
			phanm.setDisplayName("§4Phantom");
			phan.setItemMeta(phanm);

			ItemStack thor = new ItemStack(Material.GOLD_AXE);
			ItemMeta thorm = thor.getItemMeta();
			thorm.setDisplayName("§4Thor");
			thor.setItemMeta(thorm);

			ItemStack viking = new ItemStack(Material.IRON_AXE);
			ItemMeta vikingm = viking.getItemMeta();
			vikingm.setDisplayName("§4Viking");
			viking.setItemMeta(vikingm);

			ItemStack stomper = new ItemStack(Material.IRON_BOOTS);
			ItemMeta stomperm = stomper.getItemMeta();
			stomperm.setDisplayName("§4Stomper");
			stomper.setItemMeta(stomperm);

			ItemStack hulk = new ItemStack(Material.BONE);
			ItemMeta hulkm = hulk.getItemMeta();
			hulkm.setDisplayName("§4Hulk");
			hulk.setItemMeta(hulkm);

			ItemStack arco = new ItemStack(Material.BOW);
			ItemMeta arcom = arco.getItemMeta();
			arcom.setDisplayName("§4Archer");
			arco.setItemMeta(arcom);

			ItemStack glad = new ItemStack(Material.IRON_FENCE);
			ItemMeta gladm = glad.getItemMeta();
			gladm.setDisplayName("§4Gladiator");
			glad.setItemMeta(gladm);

			ItemStack pinguim = new ItemStack(Material.PACKED_ICE);
			ItemMeta pinguimm = pinguim.getItemMeta();
			pinguimm.setDisplayName("§4Pinguim");
			pinguim.setItemMeta(pinguimm);

			ItemStack ninja = new ItemStack(Material.ENDER_PEARL);
			ItemMeta ninjam = ninja.getItemMeta();
			ninjam.setDisplayName("§4Ninja");
			ninja.setItemMeta(ninjam);

			ItemStack refil = new ItemStack(Material.MUSHROOM_SOUP);
			ItemMeta refilm = refil.getItemMeta();
			refilm.setDisplayName("§4Refiller");
			refil.setItemMeta(refilm);

			ItemStack mage = new ItemStack(Material.ENDER_PORTAL_FRAME);
			ItemMeta magem = mage.getItemMeta();
			magem.setDisplayName("§4Endermage");
			mage.setItemMeta(magem);

			ItemStack grap = new ItemStack(Material.LEASH);
			ItemMeta grapm = grap.getItemMeta();
			grapm.setDisplayName("§4Grappler");
			grap.setItemMeta(grapm);

			ItemStack puurga = new ItemStack(Material.COCOA);
			ItemMeta puurgam = puurga.getItemMeta();
			puurgam.setDisplayName("§4Puurga - Kit Dedicado");
			puurga.setItemMeta(puurgam);

			ItemStack critical = new ItemStack(Material.REDSTONE);
			ItemMeta criticalm = critical.getItemMeta();
			criticalm.setDisplayName("§4Critical");
			critical.setItemMeta(criticalm);

			ItemStack granada = new ItemStack(Material.EGG);
			ItemMeta granadam = granada.getItemMeta();
			granadam.setDisplayName("§4Granadier");
			granada.setItemMeta(granadam);

			ItemStack dark = new ItemStack(Material.COAL);
			ItemMeta darkm = dark.getItemMeta();
			darkm.setDisplayName("§4DarkMage");
			dark.setItemMeta(darkm);

			ItemStack vip = new ItemStack(Material.GOLD_INGOT);
			ItemMeta vipm = vip.getItemMeta();
			vipm.setDisplayName("§6§oCompre seu VIP");
			vip.setItemMeta(vipm);

			ItemStack vidro = new ItemStack(Material.VINE);
			ItemMeta vidrom = vidro.getItemMeta();
			vidrom.setDisplayName("§6§o-");
			vidro.setItemMeta(vidrom);

			ItemStack warp = new ItemStack(Material.DIAMOND);
			ItemMeta warpm = warp.getItemMeta();
			warpm.setDisplayName("§2§oYoutuber");
			warp.setItemMeta(warpm);

			kits.setItem(0, carpete);
			kits.setItem(1, vinha);
			kits.setItem(2, vip);
			kits.setItem(3, vinha);
			kits.setItem(4, polvora);
			kits.setItem(5, vinha);
			kits.setItem(6, warp);
			kits.setItem(7, vinha);
			kits.setItem(8, vinha);
			kits.setItem(9, vidro);
			kits.setItem(10, vinha);
			kits.setItem(11, vinha);
			kits.setItem(12, jelly);
			kits.setItem(13, hit);
			kits.setItem(14, refil);
			kits.setItem(15, vinha);
			kits.setItem(16, vinha);
			kits.setItem(17, vidro);
			kits.setItem(18, vinha);
			kits.setItem(19, hulk);
			kits.setItem(20, stomper);
			kits.setItem(21, viking);
			kits.setItem(22, puurga);
			kits.setItem(23, dark);
			kits.setItem(24, critical);
			kits.setItem(25, glad);
			kits.setItem(26, vinha);
			kits.setItem(27, vinha);
			kits.setItem(28, thor);
			kits.setItem(29, snail);
			kits.setItem(30, viper);
			kits.setItem(31, grap);
			kits.setItem(32, granada);
			kits.setItem(33, pinguim);
			kits.setItem(34, anchor);
			kits.setItem(35, vinha);
			kits.setItem(36, vinha);
			kits.setItem(37, vinha);
			kits.setItem(38, vinha);
			kits.setItem(39, rider);
			kits.setItem(40, ninja);
			kits.setItem(41, special);
			kits.setItem(42, vinha);
			kits.setItem(43, vinha);
			kits.setItem(44, vinha);
			kits.setItem(45, vidro);
			kits.setItem(46, vinha);
			kits.setItem(47, vinha);
			kits.setItem(48, vinha);
			kits.setItem(49, vinha);
			kits.setItem(50, vinha);
			kits.setItem(51, vinha);
			kits.setItem(52, vinha);
			kits.setItem(53, vidro);

			p.openInventory(kits);
		}
		return false;
	}

	@EventHandler
	public void colocaragua(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		if ((p.getItemInHand().getType() == Material.TRAPPED_CHEST) && (event.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& (event.getAction() == Action.RIGHT_CLICK_AIR)) {
			Bukkit.dispatchCommand(p, "kit");
		}
	}
}
