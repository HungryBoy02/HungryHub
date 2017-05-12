package mx.x10.gamedomain.hungryhub.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Equipgui implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}

		Player player = (Player) sender;
		if (player.hasPermission("hungryhub.equip") || player.isOp() || player.hasPermission("hungryhub.*")) {
			Inventory inv = Bukkit.createInventory(null, 9, "Equip GUI");
			
			ItemStack combatButton = nameItem(Material.DIAMOND_SWORD, "Combat set ");
			inv.setItem(4, combatButton);
			
			player.openInventory(inv);
			
			
			
			return true;
		}else{
			player.sendMessage(ChatColor.RED + "You do not have permission to use that command!");
			return false;
		}
		
	}
	
	private ItemStack nameItem(ItemStack item, String name) {
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.RESET + name);
		
		item.setItemMeta(meta);
		return item;
	}
	private ItemStack nameItem(Material item, String name) {
		return nameItem(new ItemStack(item), name);
	}
}