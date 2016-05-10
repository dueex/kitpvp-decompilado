package me.iBesty.Comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Tag implements Listener, CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("tag")) {
			Player p = (Player) sender;
			if (args.length == 0) {
				p.sendMessage(ChatColor.WHITE + "/Tag < "
						+ "§fDefault §6Pro §bYoutuber §5Mod §d§oTrial §cAdmin §4Owner §f>");
				return false;
			}
			if (args[0].equalsIgnoreCase("default")) {
				if (p.hasPermission("tag.normal")) {
					p.sendMessage(ChatColor.GREEN + "Tag Alterada Para Default");
					p.setDisplayName(ChatColor.WHITE + p.getName() + ChatColor.WHITE);
					p.setPlayerListName(ChatColor.WHITE + p.getName() + ChatColor.WHITE);
				} else {
					p.sendMessage(ChatColor.RED + "Voce Nao Possui Esse Rank");
				}
			} else if (args[0].equalsIgnoreCase("pro")) {
				if (p.hasPermission("tag.pro")) {
					p.sendMessage(ChatColor.GREEN + "Tag Alterada Para Pro");
					p.setDisplayName(ChatColor.GOLD + p.getName() + ChatColor.WHITE);
					p.setPlayerListName(ChatColor.GOLD + p.getName() + ChatColor.WHITE);
				} else {
					p.sendMessage(ChatColor.RED + "Voce Nao Possui Esse Rank");
				}
			} else if (args[0].equalsIgnoreCase("youtuber")) {
				if (p.hasPermission("tag.youtuber")) {
					p.sendMessage(ChatColor.GREEN + "Tag Alterada Para Youtuber");
					p.setDisplayName(ChatColor.AQUA + p.getName() + ChatColor.WHITE);
					p.setPlayerListName(ChatColor.AQUA + p.getName() + ChatColor.WHITE);
				} else {
					p.sendMessage(ChatColor.RED + "Voce Nao Possui Esse Rank");
				}
			} else if (args[0].equalsIgnoreCase("mod")) {
				if (p.hasPermission("tag.mod")) {
					p.sendMessage(ChatColor.GREEN + "Tag Alterada Para Mod");
					p.setDisplayName(ChatColor.DARK_PURPLE + p.getName() + ChatColor.WHITE);
					p.setPlayerListName(ChatColor.DARK_PURPLE + p.getName() + ChatColor.WHITE);
				} else {
					p.sendMessage(ChatColor.RED + "Voce Nao Possui Esse Rank");
				}
			} else if (args[0].equalsIgnoreCase("trial")) {
				if (p.hasPermission("tag.trial")) {
					p.sendMessage(ChatColor.LIGHT_PURPLE + "Tag Alterada Para ModPlus");
					p.setDisplayName(ChatColor.LIGHT_PURPLE + p.getName() + ChatColor.WHITE);
					p.setPlayerListName(ChatColor.LIGHT_PURPLE + p.getName() + ChatColor.WHITE);
				} else {
					p.sendMessage(ChatColor.RED + "Voce Nao Possui Esse Rank");
				}
			} else if (args[0].equalsIgnoreCase("admin")) {
				if (p.hasPermission("tag.admin")) {
					p.sendMessage(ChatColor.GREEN + "Tag Alterada Para Admin");
					p.setDisplayName(ChatColor.RED + "§o" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName(ChatColor.RED + "§o" + p.getName() + ChatColor.WHITE);
				} else {
					p.sendMessage(ChatColor.RED + "Voce Nao Possui Esse Rank");
				}
			} else if (args[0].equalsIgnoreCase("owner")) {
				if (p.hasPermission("tag.owner")) {
					p.sendMessage(ChatColor.GREEN + "Tag Alterada Para Owner");
					p.setDisplayName(ChatColor.DARK_RED + "§o" + p.getName() + ChatColor.WHITE);
					p.setPlayerListName(ChatColor.DARK_RED + "§o" + p.getName() + ChatColor.WHITE);
				} else {
					p.sendMessage(ChatColor.RED + "Voce Nao Possui Esse Rank");
				}
			}
		}
		return false;
	}

	public static String getShortStr(String s) {
		if (s.length() == 16) {
			String shorts = s.substring(0, s.length() - 4);
			return shorts;
		}
		if (s.length() == 15) {
			String shorts = s.substring(0, s.length() - 3);
			return shorts;
		}
		if (s.length() == 14) {
			String shorts = s.substring(0, s.length() - 2);
			return shorts;
		}
		if (s.length() == 13) {
			String shorts = s.substring(0, s.length() - 1);
			return shorts;
		}
		if (s.length() == 12) {
			String shorts = s.substring(0, s.length() - 1);
			return shorts;
		}
		if (s.length() == 11) {
			String shorts = s.substring(0, s.length() - 1);
			return shorts;
		}
		return s;
	}
}
