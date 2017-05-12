package mx.x10.gamedomain.hungryhub.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class Equipinv implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this command!");
			return false;
		}

		Player player = (Player) sender;
		if (player.hasPermission("hungryhub.equip")) {
			Inventory inv = Bukkit.createInventory(null, 9, "Equip Inv");

			ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD);
			ItemStack shield = new ItemStack(Material.SHIELD);
			ItemStack totem = new ItemStack(Material.TOTEM);
			ItemStack leatherChestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
			ItemStack chainPants = new ItemStack(Material.CHAINMAIL_LEGGINGS);
			ItemStack leatherBoots = new ItemStack(Material.LEATHER_BOOTS);

			diamondSword.addUnsafeEnchantment(Enchantment.KNOCKBACK, 5);

			inv.addItem(diamondSword, shield, totem, leatherChestplate, chainPants, leatherBoots);

			player.openInventory(inv);

			return true;
		} else {
			player.sendMessage(ChatColor.RED + "You do not have permission to use that command!");
			return false;
		}

	}

}