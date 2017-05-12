package mx.x10.gamedomain.hungryhub.commands;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import mx.x10.gamedomain.hungryhub.HungryHub;

public class Menu implements CommandExecutor {
	
	private HungryHub plugin;

	public Menu(HungryHub pl) {
		plugin = pl;
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}

		Player player = (Player) sender;
		String menuSize = plugin.getConfig().getString("Menu Size (Must be a multiple of 9)");
		Inventory inv = Bukkit.createInventory(null, Integer.parseInt(menuSize), "Server Menu");
		
		List<String> menuitems = plugin.getConfig().getStringList("Menu Items");
		
		for(String item : menuitems) {
			String itemout[]=item.split("-");
			if(itemout[0].equalsIgnoreCase("compass")){
				ItemStack hubButton = nameItem(Material.COMPASS, itemout[1]);
				inv.setItem(Integer.parseInt(itemout[2]), hubButton);
			}
			if(itemout[0].equalsIgnoreCase("diamondsword")){
				ItemStack hubButton = nameItem(Material.DIAMOND_SWORD, itemout[1]);
				inv.setItem(Integer.parseInt(itemout[2]), hubButton);
			}
			if(itemout[0].equalsIgnoreCase("goldsword")){
				ItemStack hubButton = nameItem(Material.GOLD_SWORD, itemout[1]);
				inv.setItem(Integer.parseInt(itemout[2]), hubButton);
			}
			if(itemout[0].equalsIgnoreCase("ironsword")){
				ItemStack hubButton = nameItem(Material.IRON_SWORD, itemout[1]);
				inv.setItem(Integer.parseInt(itemout[2]), hubButton);
			}
			if(itemout[0].equalsIgnoreCase("diamondshovel")){
				ItemStack hubButton = nameItem(Material.DIAMOND_SPADE, itemout[1]);
				inv.setItem(Integer.parseInt(itemout[2]), hubButton);
			}
			if(itemout[0].equalsIgnoreCase("goldshovel")){
				ItemStack hubButton = nameItem(Material.GOLD_SPADE, itemout[1]);
				inv.setItem(Integer.parseInt(itemout[2]), hubButton);
			}
			if(itemout[0].equalsIgnoreCase("ironshovel")){
				ItemStack hubButton = nameItem(Material.IRON_SPADE, itemout[1]);
				inv.setItem(Integer.parseInt(itemout[2]), hubButton);
			}
			if(itemout[0].equalsIgnoreCase("grassblock")){
				ItemStack hubButton = nameItem(Material.GRASS, itemout[1]);
				inv.setItem(Integer.parseInt(itemout[2]), hubButton);
			}
			if(itemout[0].equalsIgnoreCase("stoneblock")){
				ItemStack hubButton = nameItem(Material.STONE, itemout[1]);
				inv.setItem(Integer.parseInt(itemout[2]), hubButton);
			}
			if(itemout[0].equalsIgnoreCase("ironbars")){
				ItemStack hubButton = nameItem(Material.IRON_FENCE, itemout[1]);
				inv.setItem(Integer.parseInt(itemout[2]), hubButton);
			}
			if(itemout[0].equalsIgnoreCase("endrod")){
				ItemStack hubButton = nameItem(Material.END_ROD, itemout[1]);
				inv.setItem(Integer.parseInt(itemout[2]), hubButton);
			}
			if(itemout[0].equalsIgnoreCase("totem")){
				ItemStack hubButton = nameItem(Material.TOTEM, itemout[1]);
				inv.setItem(Integer.parseInt(itemout[2]), hubButton);
			}
			if(itemout[0].equalsIgnoreCase("glassblock")){
				ItemStack hubButton = nameItem(Material.GLASS, itemout[1]);
				inv.setItem(Integer.parseInt(itemout[2]), hubButton);
			}
			if(itemout[0].equalsIgnoreCase("snowball")){
				ItemStack hubButton = nameItem(Material.SNOW_BALL, itemout[1]);
				inv.setItem(Integer.parseInt(itemout[2]), hubButton);
			}
			
		}
		
		
		

		player.openInventory(inv);

		return true;
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