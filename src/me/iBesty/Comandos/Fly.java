package me.iBesty.Comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.iBesty.Main;

public class Fly implements CommandExecutor {
	private Main plugin;

	public Fly(Main plugin) {
		this.setPlugin(plugin);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if ((cmd.getName().equalsIgnoreCase("fly")) && (p.hasPermission("vip.fly"))) {
			if (args.length == 0) {
				if (!p.getAllowFlight()) {
					p.setAllowFlight(true);
					p.sendMessage("§6Utilizando >> §8Modo Voar para " + ChatColor.GRAY + p.getName());
				} else {
					p.setAllowFlight(false);
					p.sendMessage("§6Utilizando >> §8Modo Sem Voar para " + ChatColor.GRAY + p.getName());
				}
			} else {
				Player t = p.getServer().getPlayer(args[0]);
				if (t != null) {
					if (!t.getAllowFlight()) {
						t.setAllowFlight(true);
						t.sendMessage("§6Voo Habilitado para: " + ChatColor.RED + t.getName());
					} else {
						t.setAllowFlight(false);
						t.sendMessage("§6Voo Desabilitado para: " + ChatColor.RED + t.getName());
					}
				} else {
					p.sendMessage("§4Erro: Jogador inexistente!");
				}
			}
		}
		return false;
	}

	public Main getPlugin() {
		return plugin;
	}

	public void setPlugin(Main plugin) {
		this.plugin = plugin;
	}
}
