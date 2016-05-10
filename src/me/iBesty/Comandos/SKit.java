package me.iBesty.Comandos;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class SKit implements Listener, CommandExecutor {
	public HashMap<String, ItemStack[]> kits = new HashMap<String, ItemStack[]>();
	public HashMap<String, ItemStack[]> armor = new HashMap<String, ItemStack[]>();

	public boolean isInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException localNumberFormatException) {
		}
		return false;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Somente jogadores podem executar este comando!");
			return true;
		}
		Player p = (Player) sender;
		if ((cmd.getName().equalsIgnoreCase("skit")) && ((p.hasPermission("op.staff")) || (p.isOp()))) {
			if (args.length == 0) {
				p.sendMessage(ChatColor.RED + "Sintaxe correta: /skit criar|aplicar [nome]|[raio]");
				return true;
			}
			if (args[0].equalsIgnoreCase("criar")) {
				if (args.length == 1) {
					p.sendMessage(ChatColor.RED + "Sintaxe correta: /skit criar [nome]");
					return true;
				}
				String name = args[1];
				this.kits.put(name, p.getInventory().getContents());
				this.armor.put(name, p.getInventory().getArmorContents());
				p.sendMessage(ChatColor.GREEN + "Kit " + args[1] + " criado com sucesso!");
				return true;
			}
			if (args[0].equalsIgnoreCase("aplicar")) {
				if (args.length <= 2) {
					p.sendMessage(ChatColor.RED + "Uso correto: /skit apply [nome] [range]");
					return true;
				}
				String name = args[1];
				if ((!this.kits.containsKey(name)) && (!this.armor.containsKey(name))) {
					p.sendMessage(ChatColor.RED + "Kit " + name + " nao encontrado!");
					return true;
				}
				if (isInt(args[2])) {
					int numero = Integer.parseInt(args[2]);
					for (Entity ent : p.getNearbyEntities(numero, numero, numero)) {
						if ((ent instanceof Player)) {
							Player plr = (Player) ent;
							plr.getInventory().setArmorContents((ItemStack[]) this.armor.get(name));
							plr.getInventory().setContents((ItemStack[]) this.kits.get(name));
						}
					}
					Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Kit " + name
							+ " aplicado para jogadores em um raio de " + numero + " blocos");
					p.sendMessage(ChatColor.GREEN + "Kit " + name + " aplicado para jogadores em um raio de " + numero
							+ " blocos");
					return true;
				}
				return true;
			}
		}
		if ((cmd.getName().equalsIgnoreCase("togglepvp")) && ((p.hasPermission("p.op.staff")) || (p.isOp()))) {
			if (p.getWorld().getPVP()) {
				p.getWorld().setPVP(false);
				Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "PvP Desativado");
				p.sendMessage(ChatColor.DARK_RED + "PvP Desativado");
				return true;
			}
			p.getWorld().setPVP(true);
			Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "PvP Ativado");
			p.sendMessage(ChatColor.DARK_GREEN + "PvP Ativado");
			return true;
		}
		return true;
	}
}
