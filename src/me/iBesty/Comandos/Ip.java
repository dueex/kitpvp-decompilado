package me.iBesty.Comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.iBesty.Main;

public class Ip implements CommandExecutor {
	private Main plugin;

	public Ip(Main plugin) {
		this.setPlugin(plugin);
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.DARK_RED + "Voce nao e um jogador!");
			return false;
		}
		Player p = (Player) sender;
		if ((commandLabel.equalsIgnoreCase("ip")) && (p.hasPermission("sv.staff"))) {
			if (args.length == 1) {
				Player target = p.getServer().getPlayer(args[0]);
				if (target != null) {
					p.sendMessage(ChatColor.RED + "IP: " + ChatColor.RED + target.getAddress().getHostString());
				} else {
					p.sendMessage("Jogador " + args[0] + " inexistente!");
				}
			} else {
				p.sendMessage("Errado! Use /" + commandLabel + " <jogador>");
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
