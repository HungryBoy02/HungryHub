package mx.x10.gamedomain.hungryhub.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gms implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}
		Player player = (Player) sender;
		if (player.hasPermission("hungryhub.gmcmd")) {
			player.sendMessage(ChatColor.GOLD + "Set gamemode to survival");
			player.setGameMode(GameMode.SURVIVAL);

			return true;
		} else
			return false;

	}

}
