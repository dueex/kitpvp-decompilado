package me.iBesty.Kits;

import org.bukkit.entity.Player;

public class Fujao1 implements Runnable {
	private Player p;

	public static Runnable FujaoFuncao(Fujao paramFujao, Player paramPlayer) {
		return (Runnable) paramPlayer;
	}

	public void run() {
		Fujao.cooldownm.remove(this.p);
		this.p.sendMessage("§1Voce pode usar novamente!");
	}
}
