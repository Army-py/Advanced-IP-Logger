package dev.maximde.datalogger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import dev.maximde.datalogger.commands.GetData;
import dev.maximde.datalogger.events.JoinEvent;
import dev.maximde.datalogger.events.QuitEvent;

public class DataLogger extends JavaPlugin {

	public void onEnable() {
		registerEvents();
		registerCommands();
    		getServer().getConsoleSender().sendMessage("§c==>> §4§kAdvanced IP Logger§r§c <<==");
    		getServer().getConsoleSender().sendMessage("§c============================");
    		getServer().getConsoleSender().sendMessage("§c==Plugin by MaximDe=========");
    		getServer().getConsoleSender().sendMessage("§bhttps://discord.gg/ahxyCMT8bM");
    		getServer().getConsoleSender().sendMessage("§bhttps://www.spigotmc.org/members/maximde.1620695/");
    		getServer().getConsoleSender().sendMessage("§c============================");
	}
	
	public void registerEvents() {
		Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
		Bukkit.getPluginManager().registerEvents(new QuitEvent(), this);
	}
	
	public void registerCommands() {
		this.getCommand("getdata").setExecutor(new GetData());
	}
	
	/**
	 * MaximDe 2022.
	 * 
	 * LINKS:
	 * https://github.com/JavaDevMC
	 * https://www.spigotmc.org/members/maximde.1620695/
	 */
}
