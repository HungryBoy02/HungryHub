package mx.x10.gamedomain.hungryhub.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gmsp implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}
		Player player = (Player) sender;
		if (player.hasPermission("hungryhub.gmcmd")) {
			player.sendMessage(ChatColor.GOLD + "Set gamemode to spectator");
			player.setGameMode(GameMode.SPECTATOR);

			return true;
		} else {
			player.sendMessage(ChatColor.RED + "You do not have permission to use that command!");
			return false;
		}
	}

}