package me.iBesty.Comandos;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.iBesty.Main;

public class Inventario implements CommandExecutor, Listener {
	Main main;
	public static final List<Player> admin = new ArrayList<Player>();

	public Inventario(Main plugin) {
		plugin = this.main;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Voce nao e um jogador!");
			return false;
		}
		Player p = (Player) sender;
		if (commandLabel.equalsIgnoreCase("inv")) {
			if (p.hasPermission("sv.inv")) {
				if (args.length == 0) {
					p.sendMessage(ChatColor.GOLD + "Utilize >> " + ChatColor.GRAY + "/inv <Player>");
				} else if (args.length == 1) {
					Player target = p.getServer().getPlayer(args[0]);
					if (target != null) {
						p.sendMessage(ChatColor.GOLD + "Observando >> " + ChatColor.GRAY + target.getName());
						p.openInventory(target.getInventory());
					} else {
						p.sendMessage(ChatColor.RED + "Jogador " + args[0] + "inexistente.");
					}
				} else {
					p.sendMessage(ChatColor.GOLD + "Utilize >> " + ChatColor.GRAY + "/inv <Player>");
				}
			} else {
				p.sendMessage(ChatColor.RED + "Voce nao tem permissao para isso!");
			}
		}
		return false;
	}
}
