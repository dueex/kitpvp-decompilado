package me.iBesty.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.iBesty.Main;

public class Broadcast implements CommandExecutor {
	Main main;

	public Broadcast(Main plugin) {
		plugin = this.main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
		if ((cmd.getName().equalsIgnoreCase("bc")) || (cmd.getName().equalsIgnoreCase("broadcast"))) {
			if (!sender.hasPermission("sv.bc")) {
				sender.sendMessage(ChatColor.DARK_RED + "Sem Permission!");
				return true;
			}
			if (args.length == 0) {
				sender.sendMessage(ChatColor.GOLD + " Use:" + ChatColor.GREEN + " /bc {Msg}");
			} else {
				String message = "";
				for (String part : args) {
					if (message != "") {
						message = message + " ";
					}
					message = message + part;
				}
				Bukkit.getServer().broadcastMessage(ChatColor.BLUE + "[ANUNCIO] " + ChatColor.GRAY + message);
			}
		}
		return false;
	}
}
