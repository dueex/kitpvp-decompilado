package me.iBesty.Listener;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import me.iBesty.Main;

public class CorNaPlaca implements Listener {
	public static Main plugin;

	public CorNaPlaca(Main kitPvP) {
		plugin = kitPvP;
	}

	@SuppressWarnings("unused")
	@EventHandler(priority = EventPriority.MONITOR)
	public void onSignChange(SignChangeEvent event) {
		if (!event.getPlayer().isOp()) {
			return;
		}
		Block block = event.getBlock();

		Sign sign = null;
		Material type = block.getType();
		if ((type.equals(Material.SIGN)) || (type.equals(Material.SIGN_POST)) || (type.equals(Material.WALL_SIGN))) {
			sign = (Sign) block.getState();
		} else {
			return;
		}
		String[] text = event.getLines();
		int count = 0;
		for (String line : text) {
			line = line.replaceAll("&", "§");
			line = line.replaceAll("§§", "&");
			event.setLine(count, line);
			count++;
		}
	}
}
