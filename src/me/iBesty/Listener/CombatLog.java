package me.iBesty.Listener;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.iBesty.Main;

public class CombatLog implements Listener {
	public Main plugin;

	public CombatLog(Main instance) {
		this.plugin = instance;
	}

	public static ArrayList<Player> incombat = new ArrayList<Player>();
	public static HashMap<Player, String> damager = new HashMap<Player, String>();

	@EventHandler
	public void onCombatTag(EntityDamageByEntityEvent e) {
		if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player))) {
			final Player p = (Player) e.getEntity();
			Player d = (Player) e.getDamager();
			if (!incombat.contains(p)) {
				p.sendMessage(ChatColor.RED + "Voce Esta Em PVP, Nao Deslogue!");
			}
			incombat.add(p);
			damager.put(p, d.getName());
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
				public void run() {
					CombatLog.incombat.remove(p);
					if (!CombatLog.incombat.contains(p)) {
						p.sendMessage(ChatColor.GREEN + "Voce Saiu Do PvP, Pode Deslogar!");
					}
				}
			}, 400L);
		}
	}

	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (incombat.contains(p)) {
			if (damager.get(p) == null) {
				p.damage(9999.0D);
			} else {
				Player d = Bukkit.getServer().getPlayer((String) damager.get(p));
				p.damage(99999.0D, d);
			}
			incombat.remove(p);
			damager.remove(p);
			Bukkit.getServer().broadcastMessage(ChatColor.YELLOW + p.getName() + " Deslogou em combate , que eZ!");
		}
	}
}
