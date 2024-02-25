package dev.maximde.datalogger.bukkit.commands;

import dev.maximde.datalogger.bukkit.utils.DataConfig;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class ListAltAccounts implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command arg1, @NotNull String arg2, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("advancedlogger.getalts")) {
                if (args.length == 1) {
                    Player t = Bukkit.getPlayer(args[0]);
                    if (t == null) {
                        OfflinePlayer ot = Bukkit.getOfflinePlayer(args[0]);
                        if (!DataConfig.isRegistered(ot.getUniqueId().toString())) {
                            p.sendMessage("§cPlayer not found!");
                            return false;
                        }
                        List<String> altAccounts = new ArrayList<>();
                        altAccounts.clear();
                        for (String key : DataConfig.cfg.getKeys(false)) {
                            if (DataConfig.cfg.getString(key + ".IP").equals(DataConfig.getIP(ot.getUniqueId().toString()))) {
                                if (!DataConfig.cfg.getString(key + ".Name").equals(t.getName())) {
                                    altAccounts.add(DataConfig.cfg.getString(key + ".Name"));
                                }
                            }
                        }
                        if (altAccounts.isEmpty()) {
                            p.sendMessage("§cNo alt account for player: " + ot.getName() + " found!");
                        } else {
                            p.sendMessage("§aAlt accounts of " + ot.getName() + ":");
                            for (String altAccName : altAccounts) {
                                p.sendMessage(altAccName);
                            }
                            p.sendMessage("§a--------------------");
                        }
                    } else {
                        if (!DataConfig.isRegistered(t.getUniqueId().toString())) {
                            p.sendMessage("§cPlayer not found!");
                            return false;
                        }
                        List<String> altAccounts = new ArrayList<>();
                        altAccounts.clear();
                        for (String key : DataConfig.cfg.getKeys(false)) {
                            if (DataConfig.cfg.getString(key + ".IP").equals(DataConfig.getIP(t.getUniqueId().toString()))) {
                                if (!DataConfig.cfg.getString(key + ".Name").equals(t.getName())) {
                                    altAccounts.add(DataConfig.cfg.getString(key + ".Name"));
                                }
                            }
                        }
                        if (altAccounts.isEmpty()) {
                            p.sendMessage("§cNo alt account for player: " + t.getName() + " found!");
                        } else {
                            p.sendMessage("§aAlt accounts of " + t.getName() + ":");
                            for (String altAccName : altAccounts) {
                                p.sendMessage(altAccName);
                            }
                            p.sendMessage("§a--------------------");
                        }
                    }
                } else {
                    p.sendMessage("§c/getalts <playername>");
                }
            } else {
                p.sendMessage("§cNo permissions!");
            }
        } else {
            if (args.length == 1) {
                Player t = Bukkit.getPlayer(args[0]);
                if (t == null) {
                    OfflinePlayer ot = Bukkit.getOfflinePlayer(args[0]);
                    if (!DataConfig.isRegistered(ot.getUniqueId().toString())) {
                        org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§cPlayer not found!");
                        return false;
                    }
                    List<String> altAccounts = new ArrayList<>();
                    altAccounts.clear();
                    for (String key : DataConfig.cfg.getKeys(false)) {
                        if (DataConfig.cfg.getString(key + ".IP").equals(DataConfig.getIP(ot.getUniqueId().toString()))) {
                            if (!DataConfig.cfg.getString(key + ".Name").equals(ot.getName())) {
                                altAccounts.add(DataConfig.cfg.getString(key + ".Name"));
                            }
                        }
                    }
                    if (altAccounts.isEmpty()) {
                        org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§cNo alt account for player: " + ot.getName() + " found!");
                    } else {
                        org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§aAlt accounts of " + ot.getName() + ":");
                        for (String altAccName : altAccounts) {
                            org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage(altAccName);
                        }
                        org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§a--------------------");
                    }
                } else {
                    if (!DataConfig.isRegistered(t.getUniqueId().toString())) {
                        org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§cPlayer not found!");
                        return false;
                    }
                    List<String> altAccounts = new ArrayList<>();
                    altAccounts.clear();
                    for (String key : DataConfig.cfg.getKeys(false)) {
                        if (DataConfig.cfg.getString(key + ".IP").equals(DataConfig.getIP(t.getUniqueId().toString()))) {
                            if (!DataConfig.cfg.getString(key + ".Name").equals(t.getName())) {
                                altAccounts.add(DataConfig.cfg.getString(key + ".Name"));
                            }
                        }
                    }
                    if (altAccounts.isEmpty()) {
                        org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§cNo alt account for player: " + t.getName() + " found!");
                    } else {
                        org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§aAlt accounts of " + t.getName() + ":");
                        for (String altAccName : altAccounts) {
                            org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage(altAccName);
                        }
                        org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§a--------------------");
                    }
                }
            } else {
                org.bukkit.Bukkit.getServer().getConsoleSender().sendMessage("§cgetalts <playername>");
            }
        }
        return true;
    }

    /**
     * MaximDe 2022.
     *
     * LINKS:
     * https://github.com/JavaDevMC
     * https://www.spigotmc.org/members/maximde.1620695/
     */
}
