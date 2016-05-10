package me.iBesty.Comandos;

import java.util.Arrays;
import me.iBesty.Listener.Array;
import me.iBesty.Main;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Report implements CommandExecutor {
	private Main plugin;

	public Report(Main plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		final Player p = (Player) sender;
		if (!(sender instanceof Player)) {
			sender.sendMessage("§cVoce nao e um jogador!");
			return false;
		}
		if (commandLabel.equalsIgnoreCase("report")) {
			if (args.length >= 2) {
				Player target = p.getServer().getPlayer(args[0]);
				if (target != null) {
					if (Array.reported.contains(p.getName())) {
						p.sendMessage("§cCalma extressado , ja tem um staff olhando");
						return true;
					}
					String reportMsg = StringUtils.join(Arrays.copyOfRange(args, 1, args.length), " ");
					Array.reported.add(p.getName());
					p.sendMessage("§8Voce reportou o §b" + target.getName() + "§8 por §b" + reportMsg);
					for (Player s : Bukkit.getOnlinePlayers()) {
						if (s.hasPermission("sv.staff")) {
							s.playSound(s.getLocation(), Sound.ANVIL_USE, 5.0F, 5.0F);
							s.sendMessage(
									"§b§l=-==-=-=-==-=*=-==-=-=-==-=\n§4REPORT DE JOGADOR! VEJA ABAIXO:\n§4NOME: §6"
											+

											target.getName() + "\n" + "§4MOTIVO: §6" + reportMsg + "\n"
											+ "§4REPORTER: §6" + p.getName() + "\n"
											+ "§b§l=-==-=-=-==-=*=-==-=-=-==-=");
							Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
								public void run() {
									Array.reported.remove(p.getName());
									p.sendMessage("§1Pode reportar denovo :D");
								}
							}, 150L);
						}
					}
				} else {
					p.sendMessage("Jogador " + args[0] + " nao esta online.");
				}
			} else {
				p.sendMessage("§cArgumentos insuficientes. Use: /" + commandLabel + " <jogador> <motivo>");
			}
		}
		return false;
	}
}
