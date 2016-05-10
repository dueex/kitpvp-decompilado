package me.iBesty.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tp implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Esse plugin e apenas para players!");
			return true;
		}
		Player p = (Player) sender;
		if ((cmd.getName().equalsIgnoreCase("tp")) && (p.hasPermission("sv.tp"))) {
			if (args.length == 0) {
				p.sendMessage(ChatColor.RED + "Por favor, especifique um player!");
				return true;
			}
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if (target == null) {
				p.sendMessage(ChatColor.RED + "Nao foi possivel achar player" + args[0] + "!");
				return true;
			}
			p.teleport(target.getLocation());
			return true;
		}
		return true;
	}
}
