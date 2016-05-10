package me.iBesty.Comandos;

import me.iBesty.Main;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {
	Main main;

	public Gamemode(Main plugin) {
		plugin = this.main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player) sender;
		if ((cmd.getName().equalsIgnoreCase("gm")) && (sender.hasPermission("sv.gm"))) {
			if (args.length != 1) {
				player.sendMessage(ChatColor.RED + "/gm 0/1");
				return true;
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("0")) {
					player.setGameMode(GameMode.SURVIVAL);
					player.sendMessage(ChatColor.GOLD + "Utilizando >> " + ChatColor.GRAY + "Modo Sobrevivencia!");
				}
				if (args[0].equalsIgnoreCase("1")) {
					player.setGameMode(GameMode.CREATIVE);
					player.sendMessage(ChatColor.GOLD + "Utilizando >> " + ChatColor.GRAY + "Modo Criativo!");
				}
				return true;
			}
		}
		return false;
	}
}
