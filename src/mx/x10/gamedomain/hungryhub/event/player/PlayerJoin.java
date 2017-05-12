package mx.x10.gamedomain.hungryhub.event.player;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import mx.x10.gamedomain.hungryhub.HungryHub;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_11_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_11_R1.PacketPlayOutTitle;
import net.minecraft.server.v1_11_R1.PacketPlayOutTitle.EnumTitleAction;

public class PlayerJoin implements Listener {
	private HungryHub plugin;

	public PlayerJoin(HungryHub pl) {
		plugin = pl;
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.getPlayer().getInventory().clear();
		String welcome = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("Welcome Message"));
		PacketPlayOutTitle welcomeTitle = new PacketPlayOutTitle(EnumTitleAction.TITLE, 
				ChatSerializer.a("{\"text\":\"" + welcome + "\"}"), 20, 40, 40);
		((CraftPlayer)event.getPlayer()).getHandle().playerConnection.sendPacket(welcomeTitle);
		event.getPlayer().getInventory().setItem(plugin.getConfig().getInt("Menu Item Slot"), nameItem(Material.GRASS, "Server Menu"));
		List<String> cmds = plugin.getConfig().getStringList("Join Commands");
		for(String cmd : cmds) {
			Bukkit.getServer().dispatchCommand(event.getPlayer(), cmd);
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
