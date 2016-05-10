package me.iBesty.Listener;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.help.HelpTopic;

import me.iBesty.Main;

public class All implements Listener {
	public Main plugin;

	public All(Main instance) {
		this.plugin = instance;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
		if (!event.isCancelled()) {
			Player player = event.getPlayer();
			String cmd = event.getMessage().split(" ")[0];
			HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(cmd);
			if (topic == null) {
				player.sendMessage(ChatColor.GRAY + "Comando desconhecido.");
				event.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onMe(PlayerCommandPreprocessEvent event) {
		Player p = event.getPlayer();
		if (event.getMessage().toLowerCase().startsWith("/me")) {
			event.setCancelled(true);
			p.sendMessage("§cEste comando foi retirado!");
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void chatFormat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (p.hasPermission("sv.chatcolorido")) {
			String msg = e.getMessage().replace("&", "§");
			e.setFormat(p.getDisplayName() + "§4§l >> " + "§f" + msg);
		} else {
			e.setFormat(p.getDisplayName() + "§4§l >> " + "§7" + e.getMessage());
		}
	}

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (!p.isOp()) {
			e.setCancelled(true);
			p.sendMessage("");
		}
	}

	@EventHandler
	public void fullJoin(PlayerLoginEvent event) {
		Player p = event.getPlayer();
		if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
			if (p.hasPermission("comprei.vip")) {
				event.setResult(PlayerLoginEvent.Result.ALLOWED);
			} else {
				event.setKickMessage("§cServidor Cheio! §aCompre vip e entre .!");
			}
		} else if (event.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST) {
			event.setKickMessage(ChatColor.GRAY + "Estamos em manutencÃ£o para melhorar sua jogabilidade!");
		}
	}

	@EventHandler
	public void onItemDrop(final ItemSpawnEvent e) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
			public void run() {
				e.getEntity().remove();
				e.getLocation().getWorld().playEffect(e.getEntity().getLocation(), Effect.SMOKE, 10);
			}
		}, 15L);
	}

	private Map<String, Long> timeout = new HashMap<>();

	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if ((this.timeout.containsKey(p.getName()))
				&& (((Long) this.timeout.get(p.getName())).longValue() > System.currentTimeMillis())) {
			p.sendMessage(ChatColor.RED + "VocÃª esta escrevendo muito rapido.");
			e.setCancelled(true);
			return;
		}
		this.timeout.put(p.getName(), Long.valueOf(System.currentTimeMillis() + 3000L));
	}

	@EventHandler
	public void DisableFireSpread(BlockSpreadEvent e) {
		if (e.getNewState().getType() == Material.FIRE) {
			e.setCancelled(true);
		}
	}
}
