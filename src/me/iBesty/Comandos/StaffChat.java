package me.iBesty.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.iBesty.Listener.Permissions;

public class StaffChat implements Listener, CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (commandLabel.equalsIgnoreCase("s")) {
			Player player = (Player) sender;
			if (player.hasPermission(new Permissions().StaffChat)) {
				if (args.length == 0) {
					player.sendMessage(ChatColor.RED + "Usar: " + ChatColor.RED + "/s <mensagem>");
				} else if (args.length == 1) {
					for (Player p : Bukkit.getServer().getOnlinePlayers()) {
						if (p.hasPermission(new Permissions().StaffReceiveChat)) {
							p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName()
									+ ChatColor.GOLD + ": " + ChatColor.RED + args[0]);
						}
					}
				} else if (args.length == 2) {
					for (Player p : Bukkit.getServer().getOnlinePlayers()) {
						if (p.hasPermission(new Permissions().StaffReceiveChat)) {
							p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName()
									+ ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1]);
						}
					}
				} else if (args.length == 3) {
					for (Player p : Bukkit.getServer().getOnlinePlayers()) {
						if (p.hasPermission(new Permissions().StaffReceiveChat)) {
							p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName()
									+ ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2]);
						}
					}
				} else if (args.length == 4) {
					for (Player p : Bukkit.getServer().getOnlinePlayers()) {
						if (p.hasPermission(new Permissions().StaffReceiveChat)) {
							p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName()
									+ ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2]
									+ " " + args[3]);
						}
					}
				} else if (args.length == 5) {
					for (Player p : Bukkit.getServer().getOnlinePlayers()) {
						if (p.hasPermission(new Permissions().StaffReceiveChat)) {
							p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName()
									+ ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2]
									+ " " + args[3] + " " + args[4]);
						}
					}
				} else if (args.length == 6) {
					for (Player p : Bukkit.getServer().getOnlinePlayers()) {
						if (p.hasPermission(new Permissions().StaffReceiveChat)) {
							p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName()
									+ ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2]
									+ " " + args[3] + " " + args[4] + " " + args[5]);
						}
					}
				} else if (args.length == 7) {
					for (Player p : Bukkit.getServer().getOnlinePlayers()) {
						if (p.hasPermission(new Permissions().StaffReceiveChat)) {
							p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName()
									+ ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2]
									+ " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6]);
						}
					}
				} else if (args.length == 8) {
					for (Player p : Bukkit.getServer().getOnlinePlayers()) {
						if (p.hasPermission(new Permissions().StaffReceiveChat)) {
							p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName()
									+ ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2]
									+ " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7]);
						}
					}
				} else if (args.length == 9) {
					for (Player p : Bukkit.getServer().getOnlinePlayers()) {
						if (p.hasPermission(new Permissions().StaffReceiveChat)) {
							p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName()
									+ ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2]
									+ " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7]
									+ " " + args[8]);
						}
					}
				} else if (args.length == 10) {
					for (Player p : Bukkit.getServer().getOnlinePlayers()) {
						if (p.hasPermission(new Permissions().StaffReceiveChat)) {
							p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName()
									+ ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2]
									+ " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7]
									+ " " + args[8] + " " + args[9]);
						}
					}
				} else if (args.length == 11) {
					for (Player p : Bukkit.getServer().getOnlinePlayers()) {
						if (p.hasPermission(new Permissions().StaffReceiveChat)) {
							p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName()
									+ ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2]
									+ " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7]
									+ " " + args[8] + " " + args[9] + " " + args[10]);
						}
					}
				} else if (args.length == 12) {
					for (Player p : Bukkit.getServer().getOnlinePlayers()) {
						if (p.hasPermission(new Permissions().StaffReceiveChat)) {
							p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName()
									+ ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2]
									+ " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7]
									+ " " + args[8] + " " + args[9] + " " + args[10] + " " + args[11]);
						}
					}
				} else if (args.length == 13) {
					for (Player p : Bukkit.getServer().getOnlinePlayers()) {
						if (p.hasPermission(new Permissions().StaffReceiveChat)) {
							p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName()
									+ ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2]
									+ " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7]
									+ " " + args[8] + " " + args[9] + " " + args[10] + " " + args[11] + " " + args[12]);
						}
					}
				} else if (args.length == 14) {
					for (Player p : Bukkit.getServer().getOnlinePlayers()) {
						if (p.hasPermission(new Permissions().StaffReceiveChat)) {
							p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName()
									+ ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2]
									+ " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7]
									+ " " + args[8] + " " + args[9] + " " + args[10] + " " + args[11] + " " + args[12]
									+ " " + args[13]);
						}
					}
				} else if (args.length == 15) {
					for (Player p : Bukkit.getServer().getOnlinePlayers()) {
						if (p.hasPermission(new Permissions().StaffReceiveChat)) {
							p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName()
									+ ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2]
									+ " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7]
									+ " " + args[8] + " " + args[9] + " " + args[10] + " " + args[11] + " " + args[12]
									+ " " + args[13] + " " + args[14]);
						}
					}
				} else if (args.length == 16) {
					for (Player p : Bukkit.getServer().getOnlinePlayers()) {
						if (p.hasPermission(new Permissions().StaffReceiveChat)) {
							p.sendMessage(ChatColor.BLUE + "§7[§aStaffChat§7] " + ChatColor.RED + player.getName()
									+ ChatColor.GOLD + ": " + ChatColor.RED + args[0] + " " + args[1] + " " + args[2]
									+ " " + args[3] + " " + args[4] + " " + args[5] + " " + args[6] + " " + args[7]
									+ " " + args[8] + " " + args[9] + " " + args[10] + " " + args[11] + " " + args[12]
									+ " " + args[13] + " " + args[14] + " " + args[15]);
						}
					}
				}
			}
		}
		return false;
	}
}
