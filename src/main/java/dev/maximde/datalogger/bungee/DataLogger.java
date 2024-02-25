package dev.maximde.datalogger.bungee;

import dev.maximde.datalogger.bungee.commands.GetData;
import dev.maximde.datalogger.bungee.commands.ListAltAccounts;
import dev.maximde.datalogger.bungee.events.JoinEvent;
import dev.maximde.datalogger.bungee.events.QuitEvent;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;


public class DataLogger extends Plugin {

    private static CommandSender console;

    public static CommandSender getConsole() {
        return console;
    }

    public void onEnable() {
        registerEvents();
        registerCommands();
        console = getProxy().getConsole();
        console.sendMessage(new TextComponent("§c==>> §4§kAdvanced IP Logger§r§c <<=="));
		console.sendMessage(new TextComponent("§c============================"));
		console.sendMessage(new TextComponent("§c=========§3BungeeCord§c========="));
		console.sendMessage(new TextComponent("§c============================"));
		console.sendMessage(new TextComponent("§c======Plugin by MaximDe====="));
		console.sendMessage(new TextComponent("§bhttps://discord.gg/ahxyCMT8bM"));
		console.sendMessage(new TextComponent("§bhttps://www.spigotmc.org/members/maximde.1620695/"));
		console.sendMessage(new TextComponent("§c============================"));
    }

    public void registerEvents() {
        getProxy().getPluginManager().registerListener(this, (Listener) new JoinEvent());
        getProxy().getPluginManager().registerListener(this, (Listener) new QuitEvent());
    }

    public void registerCommands() {
        getProxy().getPluginManager().registerCommand(this, new GetData("getdata"));
        getProxy().getPluginManager().registerCommand(this, new ListAltAccounts("getalts"));
    }

    /**
     * MaximDe 2022.
     *
     * LINKS:
     * https://github.com/JavaDevMC
     * https://www.spigotmc.org/members/maximde.1620695/
     */
}
