package me.iBesty.Listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.permissions.Permission;

public class Permissions implements Listener {
	public Permission StaffChat = new Permission("sv.staffchat");
	public Permission StaffReceiveChat = new Permission("sv.staffchat");

	public static void semPermiassao(Player player) {
		player.sendMessage(ChatColor.RED + "Voce nao tem permissao!");
	}
}
