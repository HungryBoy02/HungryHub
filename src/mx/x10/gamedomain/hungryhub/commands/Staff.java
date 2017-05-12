package mx.x10.gamedomain.hungryhub.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mx.x10.gamedomain.hungryhub.HungryHub;

public class Staff implements CommandExecutor {
	
	private HungryHub plugin;
	
	public Staff(HungryHub pl) {
		plugin = pl;
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}
		Player player = (Player) sender;
		String liststaff = "";
		List<String> serverStaff = plugin.getConfig().getStringList("Server Staff");
		
		player.sendMessage("List of server staff:");
		for(String staff : serverStaff) {
			liststaff = liststaff + staff + " ";
		}
		player.sendMessage(liststaff);
		return true;
	}

}