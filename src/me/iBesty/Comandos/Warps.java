package me.iBesty.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.iBesty.Main;

public class Warps implements CommandExecutor, Listener {
	public Warps(Main plugin) {
	}

	@EventHandler
	public void onClickKit(InventoryClickEvent e) {
		if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null)) {
			Inventory inv = e.getInventory();
			Player p = (Player) e.getWhoClicked();
			if (inv.getTitle().equals("§2Warps")) {
				e.setCancelled(true);
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Challenge")) {
					Bukkit.dispatchCommand(p, "challenge");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4ReiDaMesa")) {
					Bukkit.dispatchCommand(p, "rdm");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4MaeDaRua")) {
					Bukkit.dispatchCommand(p, "mdr");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4FPS")) {
					Bukkit.dispatchCommand(p, "fps");
					p.closeInventory();
				}
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§41v1")) {
					Bukkit.dispatchCommand(p, "1v1");
					p.closeInventory();
				}
			}
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (label.equalsIgnoreCase("warps")) {
			Inventory kits = Bukkit.getServer().createInventory(p, 27, "§2Warps");

			ItemStack vinha = new ItemStack(Material.THIN_GLASS);
			ItemMeta vm = vinha.getItemMeta();
			vm.setDisplayName("§2§o§lWarps");
			vinha.setItemMeta(vm);

			ItemStack carpete = new ItemStack(Material.LAVA_BUCKET);
			ItemMeta carpetem = carpete.getItemMeta();
			carpetem.setDisplayName("§4Challenge");
			carpete.setItemMeta(carpetem);

			ItemStack rdm = new ItemStack(Material.CAKE);
			ItemMeta rdmm = rdm.getItemMeta();
			rdmm.setDisplayName("§4ReiDaMesa");
			rdm.setItemMeta(rdmm);

			ItemStack mdr = new ItemStack(Material.BRICK);
			ItemMeta mdrm = mdr.getItemMeta();
			mdrm.setDisplayName("§4MaeDaRua");
			mdr.setItemMeta(mdrm);

			ItemStack fps = new ItemStack(Material.GLASS);
			ItemMeta fpsm = fps.getItemMeta();
			fpsm.setDisplayName("§4FPS");
			fps.setItemMeta(fpsm);

			ItemStack dica = new ItemStack(Material.BLAZE_ROD);
			ItemMeta dicam = dica.getItemMeta();
			dicam.setDisplayName("§41v1");
			dica.setItemMeta(dicam);

			kits.setItem(0, vinha);
			kits.setItem(1, vinha);
			kits.setItem(2, vinha);
			kits.setItem(3, vinha);
			kits.setItem(4, vinha);
			kits.setItem(5, vinha);
			kits.setItem(6, vinha);
			kits.setItem(7, vinha);
			kits.setItem(8, vinha);
			kits.setItem(9, vinha);
			kits.setItem(10, vinha);
			kits.setItem(11, carpete);
			kits.setItem(12, rdm);
			kits.setItem(13, mdr);
			kits.setItem(14, fps);
			kits.setItem(15, dica);
			kits.setItem(16, vinha);
			kits.setItem(17, vinha);
			kits.setItem(18, vinha);
			kits.setItem(19, vinha);
			kits.setItem(20, vinha);
			kits.setItem(21, vinha);
			kits.setItem(22, vinha);
			kits.setItem(23, vinha);
			kits.setItem(24, vinha);
			kits.setItem(25, vinha);
			kits.setItem(26, vinha);

			p.openInventory(kits);
		}
		return false;
	}
}
