package mx.x10.gamedomain.hungryhub.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BelowBedrock implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}
		Player player = (Player) sender;
		Location l = new Location(player.getWorld(), player.getLocation().getX(), -2, player.getLocation().getZ());
		player.sendMessage("[HungryHub]: Teleported to " + player.getLocation().getX() + " -2 " + player.getLocation().getZ());
		player.teleport(l);
		
		return true;

	}

}
