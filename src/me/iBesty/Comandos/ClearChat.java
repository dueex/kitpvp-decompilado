package me.iBesty.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChat implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Voce nao e um jogador!");
			return false;
		}
		Player p = (Player) sender;
		if ((commandLabel.equalsIgnoreCase("cchat")) && (p.hasPermission("admin.mod"))) {
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage(" ");
			Bukkit.broadcastMessage("§5O Chat Foi Limpo Por " + p.getName());
		}
		return false;
	}
}
