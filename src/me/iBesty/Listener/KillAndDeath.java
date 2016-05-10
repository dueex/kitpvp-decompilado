package me.iBesty.Listener;

import me.iBesty.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KillAndDeath implements Listener {
	public Main plugin;

	public KillAndDeath(Main Fight, Main plugin) {
		this.plugin = plugin;
	}

	public KillAndDeath(Main fight) {
	}

	@EventHandler
	public void Matar(PlayerDeathEvent e) {
		Player p = e.getEntity();
		if ((p.getKiller() instanceof Player)) {
			Player k = p.getKiller();
			Location l = k.getLocation();
			Location lp = p.getLocation();
			p.sendMessage(
					ChatColor.RED + "Voce foi morto por: " + ChatColor.DARK_RED + ChatColor.ITALIC + k.getName());
			k.sendMessage(ChatColor.GREEN + "Voce matou: " + ChatColor.DARK_GREEN + ChatColor.ITALIC + p.getName());
			k.playSound(l, Sound.ANVIL_LAND, 10.0F, 1.0F);
			p.playSound(lp, Sound.IRONGOLEM_DEATH, 10.0F, 1.0F);
		}
	}
}
