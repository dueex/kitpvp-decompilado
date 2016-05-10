package me.iBesty.Comandos;

import java.util.ArrayList;
import me.iBesty.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Administrador implements CommandExecutor, Listener {
	public Main plugin;

	public Administrador(Main instance) {
		this.plugin = instance;
	}

	private ArrayList<Player> admin = new ArrayList<Player>();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Comando para players!");
				return true;
			}
			Player player = (Player) sender;
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Voce nao pode usa admin!");
				return true;
			}
			if ((cmd.getName().equalsIgnoreCase("admin")) && (player.hasPermission("sv.admin"))) {
				if (!this.admin.contains(player)) {
					for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
						pl.hidePlayer(player);
					}
					this.admin.add(player);
					player.sendMessage(ChatColor.GREEN + "Ninguem pode te ver!");
					player.setGameMode(GameMode.CREATIVE);
					player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000000, 10));
					return true;
				}
				for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
					pl.showPlayer(player);
				}
				this.admin.remove(player);
				player.sendMessage(ChatColor.GREEN + "Todos podem te ver!");
				player.setGameMode(GameMode.SURVIVAL);
				player.removePotionEffect(PotionEffectType.INVISIBILITY);
				return true;
			}
		}
		return false;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		for (Player p : this.admin) {
			e.getPlayer().hidePlayer(p);
		}
	}

	@EventHandler
	public void abriuoinventario(PlayerInteractEntityEvent event) {
		if (!(event.getRightClicked() instanceof Player)) {
			return;
		}
		Player p = event.getPlayer();
		Player r = (Player) event.getRightClicked();
		if ((this.admin.contains(p)) && (p.getItemInHand().getType() == Material.AIR)) {
			p.openInventory(r.getInventory());
		}
	}

	@EventHandler
	public void inventoryOpen(PlayerInteractEntityEvent event) {
		if (!(event.getRightClicked() instanceof Player)) {
			return;
		}
		Player p = event.getPlayer();
		Player r = (Player) event.getRightClicked();
		if (this.admin.contains(p)) {
			p.openInventory(r.getInventory());
		}
	}
}
