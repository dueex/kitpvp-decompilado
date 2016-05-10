package me.iBesty.Kits;

import java.text.DecimalFormat;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;

import me.iBesty.Main;
import me.iBesty.Listener.Array;

public class Ninja implements Listener, CommandExecutor {
	private Main plugin;
	public HashMap<Player, Player> a = new HashMap<Player, Player>();
	public HashMap<Player, Long> b = new HashMap<Player, Long>();

	public Ninja(Main main) {
		this.plugin = main;
	}

	@EventHandler
	public void a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
		if (((paramEntityDamageByEntityEvent.getDamager() instanceof Player))
				&& ((paramEntityDamageByEntityEvent.getEntity() instanceof Player))) {
			final Player localPlayer1 = (Player) paramEntityDamageByEntityEvent.getDamager();
			Player localPlayer2 = (Player) paramEntityDamageByEntityEvent.getEntity();
			if (Array.ninja.contains(localPlayer1.getName())) {
				this.a.put(localPlayer1, localPlayer2);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
					public void run() {
						Backpacker.cooldownbk.remove(localPlayer1);
					}
				}, 200L);
			}
		}
	}

	@EventHandler
	public void a(PlayerToggleSneakEvent paramPlayerToggleSneakEvent) {
		Player localPlayer1 = paramPlayerToggleSneakEvent.getPlayer();
		if ((paramPlayerToggleSneakEvent.isSneaking()) && (Array.ninja.contains(localPlayer1.getName()))
				&& (this.a.containsKey(localPlayer1))) {
			Player localPlayer2 = (Player) this.a.get(localPlayer1);
			if ((localPlayer2 != null) && (!localPlayer2.isDead())) {
				String str = null;
				if (this.b.get(localPlayer1) != null) {
					long l = ((Long) this.b.get(localPlayer1)).longValue() - System.currentTimeMillis();
					DecimalFormat localDecimalFormat = new DecimalFormat("##");
					int i = (int) l / 1000;
					str = localDecimalFormat.format(i);
				}
				if ((this.b.get(localPlayer1) == null)
						|| (((Long) this.b.get(localPlayer1)).longValue() < System.currentTimeMillis())) {
					if (localPlayer1.getLocation().distance(localPlayer2.getLocation()) < 100.0D) {
						localPlayer1.teleport(localPlayer2.getLocation());
						localPlayer1.sendMessage(ChatColor.GREEN + "Teleportado");
						this.b.put(localPlayer1, Long.valueOf(System.currentTimeMillis() + 10000L));
					} else {
						localPlayer1.sendMessage(ChatColor.RED + "O Ultimo jogador hitado esta muito longe!");
					}
				} else {
					localPlayer1.sendMessage(ChatColor.RED + "Ninja em cooldown de " + str + " segundos!");
				}
			}
		}
	}

	public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
		Player p = (Player) sender;
		ItemStack dima = new ItemStack(Material.STONE_SWORD);
		ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		dima.addEnchantment(Enchantment.DAMAGE_ALL, 1);
		if (cmd.equalsIgnoreCase("ninja")) {
			if (Array.used.contains(p.getName())) {
				p.sendMessage("§cSomente 1 Kit por vida!");
				return true;
			}
			if (!p.hasPermission("kit.ninja")) {
				p.sendMessage("§c§oVoce nao tem permissao para este kit!");
				return true;
			}
			Array.used.add(p.getName());
			p.sendMessage(ChatColor.GOLD + "Utilizando >> " + ChatColor.GRAY + "Ninja");
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents(null);
			p.getInventory().clear();
			Array.ninja.add(p.getName());
			p.getInventory().addItem(new ItemStack[] { dima });
			for (int i = 0; i <= 34; i++) {
				p.getInventory().addItem(new ItemStack[] { sopa });
			}
		}
		return false;
	}
}
