package me.iBesty.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class QuandoMorrer implements Listener {
	@EventHandler
	public void quandoMorrer(PlayerDeathEvent e) {
		Player p = e.getEntity();

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
		e.setDroppedExp(0);
		e.setNewLevel(0);
	}
}
