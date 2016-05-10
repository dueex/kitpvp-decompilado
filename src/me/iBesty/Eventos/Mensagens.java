package me.iBesty.Eventos;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Mensagens implements Listener {
	@EventHandler
	public void quandoEntrar(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(ChatColor.GREEN + "+ " + ChatColor.GRAY + p.getName());
	}

	@EventHandler
	public void quandoEntrar(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage(ChatColor.DARK_RED + "- " + ChatColor.GRAY + p.getName());
	}

	@EventHandler
	public void quandoMorrer(PlayerDeathEvent e) {
		e.setDeathMessage(null);
		e.getDrops().clear();
	}

	@EventHandler
	public void semFome(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}
}
