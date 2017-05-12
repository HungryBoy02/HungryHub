package mx.x10.gamedomain.hungryhub.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mx.x10.gamedomain.hungryhub.HungryHub;

public class Reload implements CommandExecutor {
	private HungryHub plugin;

	public Reload(HungryHub pl) {
		plugin = pl;
	}

	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
		Player player = (Player) sender;
		if (player.hasPermission("")){
		plugin.reloadConfig();
		plugin.saveConfig();
		
		player.sendMessage(ChatColor.GOLD + "Reloaded Hungry Hub config!");
		} else player.sendMessage(ChatColor.RED + "You can't do that!");
		return true;
	}
	

}
