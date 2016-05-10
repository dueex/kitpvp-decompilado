package me.iBesty.Comandos;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public final class Build implements Listener, CommandExecutor {
	public static final String prefix = "ß4[Servidor] ";
	private static boolean build = false;

	public final boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if ((cmd.getName().equalsIgnoreCase("build")) && (p.hasPermission("p.staff"))) {
			if (args.length == 0) {
				sender.sendMessage("ß4[Servidor] Modo Construir esta:  " + (build ? ChatColor.GREEN + "Ativado"
						: new StringBuilder().append(ChatColor.RED).append("Desativado").toString()));
				sender.sendMessage(ChatColor.DARK_RED + "Sintaxe correta:" + ChatColor.DARK_RED + "/build [on|off]");
				return true;
			}
			if (args[0].equalsIgnoreCase("on")) {
				build = true;
				sender.sendMessage("ß4ßo[Servidor] Modo Construir esta: " + (build ? ChatColor.GREEN + "Ativado"
						: new StringBuilder().append(ChatColor.RED).append("desativado").toString()));
			} else if (args[0].equalsIgnoreCase("off")) {
				build = false;
				sender.sendMessage("√Çßc√Çßo[Servidor] Modo Construir esta: " + (build ? ChatColor.RED + "Desativado"
						: new StringBuilder().append(ChatColor.RED).append("desativado").toString()));
			} else {
				sender.sendMessage(ChatColor.RED + "Sintaxe correta:" + ChatColor.DARK_RED + "/build [on|off]");
			}
			return true;
		}
		return true;
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public final void onBlockPlace(BlockPlaceEvent event) {
		if (!build) {
			event.setCancelled(true);
		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public final void onBlockBreak(BlockBreakEvent event) {
		if (!build) {
			event.setCancelled(true);
		}
	}
}
