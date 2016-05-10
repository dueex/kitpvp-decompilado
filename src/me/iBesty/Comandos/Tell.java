package me.iBesty.Comandos;

import me.iBesty.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tell implements CommandExecutor {
	private Main plugin;

	public Tell(Main plugin) {
		this.setPlugin(plugin);
	}

	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		Player p = (Player) sender;
		if ((cmd.equalsIgnoreCase("tell")) || (cmd.equalsIgnoreCase("msg"))) {
			if (args.length < 2) {
				p.sendMessage(ChatColor.RED + "/tell <jogador> <mensagem>");
				return true;
			}
			int i = 1;
			int para = args.length;
			String MSG = "";
			while (i < para) {
				MSG = MSG + args[i] + " ";
				i++;
			}
			Player target = Bukkit.getPlayerExact(args[0]);
			if (target != null) {
				target.sendMessage(ChatColor.GOLD + "[" + ChatColor.GRAY + p.getName() + ChatColor.GOLD + "-> Eu] "
						+ ChatColor.GRAY + MSG);
				p.sendMessage(ChatColor.GOLD + "[Eu -> " + ChatColor.GRAY + target.getName() + ChatColor.GOLD + "] "
						+ ChatColor.GRAY + MSG);
			} else {
				p.sendMessage(ChatColor.RED + "Este player nao está online!");
			}
			return false;
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
