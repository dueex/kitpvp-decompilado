package me.iBesty.Listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.iBesty.Main;

public class PlacaDeSopa implements Listener {
	private Main plugin;

	public PlacaDeSopa(Main instance) {
		this.setPlugin(instance);
	}

	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		if (e.getLine(0).equalsIgnoreCase("sopa")) {
			e.setLine(0, "§4§o<---()--->");
			e.setLine(1, "§oSopa Pa Nois");
		}
	}

	@EventHandler
	public void inv(PlayerInteractEvent e) {
		Player p = e.getPlayer();

		ItemStack sopas = new ItemStack(Material.MUSHROOM_SOUP);

		Inventory inve = Bukkit.getServer().createInventory(p, 36, ChatColor.GOLD + "Sopas");

		inve.setItem(0, sopas);
		inve.setItem(1, sopas);
		inve.setItem(2, sopas);
		inve.setItem(3, sopas);
		inve.setItem(4, sopas);
		inve.setItem(5, sopas);
		inve.setItem(6, sopas);
		inve.setItem(7, sopas);
		inve.setItem(8, sopas);
		inve.setItem(9, sopas);
		inve.setItem(10, sopas);
		inve.setItem(11, sopas);
		inve.setItem(12, sopas);
		inve.setItem(13, sopas);
		inve.setItem(14, sopas);
		inve.setItem(15, sopas);
		inve.setItem(16, sopas);
		inve.setItem(17, sopas);
		inve.setItem(18, sopas);
		inve.setItem(19, sopas);
		inve.setItem(20, sopas);
		inve.setItem(21, sopas);
		inve.setItem(22, sopas);
		inve.setItem(23, sopas);
		inve.setItem(24, sopas);
		inve.setItem(25, sopas);
		inve.setItem(26, sopas);
		inve.setItem(27, sopas);
		inve.setItem(28, sopas);
		inve.setItem(29, sopas);
		inve.setItem(30, sopas);
		inve.setItem(31, sopas);
		inve.setItem(32, sopas);
		inve.setItem(33, sopas);
		inve.setItem(34, sopas);
		inve.setItem(35, sopas);
		if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (e.getClickedBlock() != null)
				&& ((e.getClickedBlock().getType() == Material.WALL_SIGN)
						|| (e.getClickedBlock().getType() == Material.SIGN_POST))) {
			Sign s = (Sign) e.getClickedBlock().getState();
			String[] lines = s.getLines();
			if ((lines.length > 2) && (lines[1].equals("§oSopa Pa Nois")) && (lines.length > 1)
					&& (lines[0].equals("§4§o<---()--->"))) {
				p.openInventory(inve);
			}
		}
	}

	public Main getPlugin() {
		return plugin;
	}

	public void setPlugin(Main plugin) {
		this.plugin = plugin;
	}
}
