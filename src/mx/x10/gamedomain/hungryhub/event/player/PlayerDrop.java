package mx.x10.gamedomain.hungryhub.event.player;

import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;


import mx.x10.gamedomain.hungryhub.HungryHub;


public class PlayerDrop implements Listener {
	Logger logger = Logger.getLogger("Minecraft");
	private HungryHub plugin;

	public PlayerDrop(HungryHub pl) {
		plugin = pl;
	}
	@EventHandler
	public void dropEvent(PlayerDropItemEvent event) {
		Player p = event.getPlayer();
		
		if (!(p.getWorld().getName().equalsIgnoreCase(plugin.getConfig().getString("Hub World"))))
			return;
		event.setCancelled(event.getItemDrop().getItemStack().getType() == Material.GRASS);
		return;
	}
}
