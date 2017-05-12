package mx.x10.gamedomain.hungryhub;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import mx.x10.gamedomain.hungryhub.commands.BelowBedrock;
import mx.x10.gamedomain.hungryhub.commands.Equip;
import mx.x10.gamedomain.hungryhub.commands.Equipgui;
import mx.x10.gamedomain.hungryhub.commands.Equipinv;
import mx.x10.gamedomain.hungryhub.commands.Gma;
import mx.x10.gamedomain.hungryhub.commands.Gmc;
import mx.x10.gamedomain.hungryhub.commands.Gms;
import mx.x10.gamedomain.hungryhub.commands.Gmsp;
import mx.x10.gamedomain.hungryhub.commands.Menu;
import mx.x10.gamedomain.hungryhub.commands.Reload;
import mx.x10.gamedomain.hungryhub.commands.Staff;
import mx.x10.gamedomain.hungryhub.event.block.BlockBreak;
import mx.x10.gamedomain.hungryhub.event.inventory.InventoryClick;
import mx.x10.gamedomain.hungryhub.event.player.PlayerChat;
import mx.x10.gamedomain.hungryhub.event.player.PlayerClick;
import mx.x10.gamedomain.hungryhub.event.player.PlayerDrop;
import mx.x10.gamedomain.hungryhub.event.player.PlayerJoin;

public class HungryHub extends JavaPlugin {

	public void onEnable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = Logger.getLogger("Minecraft");

		registerCommands();
		registerEvents();
		registerConfig();

		logger.info(pdfFile.getName() + " Ver: [" + pdfFile.getVersion() + "] has been enabled!");
	}

	public void onDisable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = Logger.getLogger("Minecraft");

		logger.info(pdfFile.getName() + " Ver: [" + pdfFile.getVersion() + "] has been disabled!");
	}

	public void registerCommands() {
		getCommand("gmc").setExecutor(new Gmc());
		getCommand("gms").setExecutor(new Gms());
		getCommand("gma").setExecutor(new Gma());
		getCommand("gmsp").setExecutor(new Gmsp());
		getCommand("belowbedrock").setExecutor(new BelowBedrock());
		getCommand("staff").setExecutor(new Staff(this));
		getCommand("equip").setExecutor(new Equip());
		getCommand("equipinv").setExecutor(new Equipinv());
		getCommand("equipgui").setExecutor(new Equipgui());
		getCommand("menu").setExecutor(new Menu(this));
		getCommand("hhbreload").setExecutor(new Reload(this));
	}

	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();

		pm.registerEvents(new BlockBreak(), this);
		pm.registerEvents(new PlayerChat(), this);
		pm.registerEvents(new PlayerJoin(this), this);
		pm.registerEvents(new InventoryClick(this), this);
		pm.registerEvents(new PlayerClick(this), this);
		pm.registerEvents(new PlayerDrop(this), this);
	}

	private void registerConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
}
