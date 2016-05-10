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

public class Kit implements CommandExecutor, Listener {
	public Kit(Main plugin) {
	}

	@EventHandler
	public void onClickKit(InventoryClickEvent e) {
		if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {
			Inventory inv = e.getInventory();
			Player p = (Player) e.getWhoClicked();
			if (inv.getTitle().equals("§4§lKits")) {
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 5.0F, 5.0F);
				e.setCancelled(true);
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§oPvP")) {
					Bukkit.dispatchCommand(p, "pvp");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§oJellyFish")) {
					Bukkit.dispatchCommand(p, "jellyfish");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§oKangaroo")) {
					Bukkit.dispatchCommand(p, "kangaroo");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§oArcher")) {
					Bukkit.dispatchCommand(p, "archer");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§oFisherman")) {
					Bukkit.dispatchCommand(p, "fisherman");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§oGorila")) {
					Bukkit.dispatchCommand(p, "gorila");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§oFujao")) {
					Bukkit.dispatchCommand(p, "fujao");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("Kits Premium")) {
					Bukkit.dispatchCommand(p, "kitvip");
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§oSniper")) {
					Bukkit.dispatchCommand(p, "sniper");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6§oCompre seu VIP")) {
					p.performCommand("Comprar");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§2§oYoutuber")) {
					p.sendMessage("§6§o                                   -=-");
					p.sendMessage("§2Para Ter  TAG §6VIP §2Voce Deve Ter 500Subs + Video No Servidor");
					p.sendMessage("§2Para Ter TAG §bYOUTUBER §2Voce Deve Ter 1k e FAZER 1 Video No Servidor");
					p.sendMessage("§6§o                                   -=-");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§oPhantom")) {
					Bukkit.dispatchCommand(p, "phantom");
					p.closeInventory();
				}
			}
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (label.equalsIgnoreCase("kit")) {
			Inventory kits = Bukkit.getServer().createInventory(p, 54, "§4§lKits");

			ItemStack vinha = new ItemStack(Material.THIN_GLASS);
			ItemMeta vm = vinha.getItemMeta();
			vm.setDisplayName("-");
			vinha.setItemMeta(vm);

			ItemStack carpete = new ItemStack(Material.CARPET);
			ItemMeta carpetem = carpete.getItemMeta();
			carpetem.setDisplayName("Kits Premium");
			carpete.setItemMeta(carpetem);

			ItemStack polvora = new ItemStack(Material.SULPHUR);
			ItemMeta polvoram = polvora.getItemMeta();
			polvoram.setDisplayName("§4§l§oKits");
			polvora.setItemMeta(polvoram);

			ItemStack pvp = new ItemStack(Material.STONE_SWORD);
			ItemMeta pvpm = pvp.getItemMeta();
			pvpm.setDisplayName("§a§oPvP");
			pvp.setItemMeta(pvpm);

			ItemStack kanga = new ItemStack(Material.FIREWORK);
			ItemMeta kangam = kanga.getItemMeta();
			kangam.setDisplayName("§a§oKangaroo");
			kanga.setItemMeta(kangam);

			ItemStack fish = new ItemStack(Material.FISHING_ROD);
			ItemMeta fishm = fish.getItemMeta();
			fishm.setDisplayName("§a§oFisherman");
			fish.setItemMeta(fishm);

			ItemStack arco = new ItemStack(Material.BOW);
			ItemMeta arcom = arco.getItemMeta();
			arcom.setDisplayName("§a§oArcher");
			arco.setItemMeta(arcom);

			ItemStack gorila = new ItemStack(Material.SAPLING);
			ItemMeta gorilam = gorila.getItemMeta();
			gorilam.setDisplayName("§a§oGorila");
			gorila.setItemMeta(gorilam);

			ItemStack fujao = new ItemStack(Material.SLIME_BALL);
			ItemMeta fujaom = fujao.getItemMeta();
			fujaom.setDisplayName("§a§oFujao");
			fujao.setItemMeta(fujaom);

			ItemStack sniper = new ItemStack(Material.BOW);
			ItemMeta sniperm = fujao.getItemMeta();
			sniperm.setDisplayName("§a§oSniper");
			sniper.setItemMeta(sniperm);

			ItemStack vip = new ItemStack(Material.GOLD_INGOT);
			ItemMeta vipm = vip.getItemMeta();
			vipm.setDisplayName("§6§oCompre seu VIP");
			vip.setItemMeta(vipm);

			ItemStack warp = new ItemStack(Material.DIAMOND);
			ItemMeta warpm = warp.getItemMeta();
			warpm.setDisplayName("§2§oYoutuber");
			warp.setItemMeta(warpm);

			ItemStack vidro = new ItemStack(Material.VINE);
			ItemMeta vidrom = vidro.getItemMeta();
			vidrom.setDisplayName("-");
			vidro.setItemMeta(vidrom);

			ItemStack phantom = new ItemStack(Material.FEATHER);
			ItemMeta phantomm = phantom.getItemMeta();
			phantomm.setDisplayName("§2§oPhantom");
			phantom.setItemMeta(phantomm);

			kits.setItem(0, vinha);
			kits.setItem(1, vinha);
			kits.setItem(2, vip);
			kits.setItem(3, vinha);
			kits.setItem(4, polvora);
			kits.setItem(5, vinha);
			kits.setItem(6, warp);
			kits.setItem(7, vinha);
			kits.setItem(8, carpete);
			kits.setItem(9, vidro);
			kits.setItem(10, vinha);
			kits.setItem(11, vinha);
			kits.setItem(12, vinha);
			kits.setItem(13, vinha);
			kits.setItem(14, vinha);
			kits.setItem(15, vinha);
			kits.setItem(16, vinha);
			kits.setItem(17, vidro);
			kits.setItem(18, vinha);
			kits.setItem(19, vinha);
			kits.setItem(20, vinha);
			kits.setItem(21, pvp);
			kits.setItem(22, arco);
			kits.setItem(23, kanga);
			kits.setItem(24, vinha);
			kits.setItem(25, vinha);
			kits.setItem(26, vinha);
			kits.setItem(27, vinha);
			kits.setItem(28, vinha);
			kits.setItem(29, sniper);
			kits.setItem(30, fish);
			kits.setItem(31, gorila);
			kits.setItem(32, fujao);
			kits.setItem(33, phantom);
			kits.setItem(34, vinha);
			kits.setItem(35, vinha);
			kits.setItem(36, vinha);
			kits.setItem(37, vinha);
			kits.setItem(38, vinha);
			kits.setItem(39, vinha);
			kits.setItem(40, vinha);
			kits.setItem(41, vinha);
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
