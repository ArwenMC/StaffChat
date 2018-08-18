package com.arwenmc;

import com.arwenmc.commands.AdminChatCommand;
import com.arwenmc.commands.ChatCommand;
import com.arwenmc.commands.StaffChatCommand;
import com.arwenmc.listeners.SCChat;
import com.arwenmc.listeners.SCJoinQuit;
import com.arwenmc.util.ChannelType;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StaffChat extends JavaPlugin {

    PluginDescriptionFile pdfFile = this.getDescription(); // gets information from plugin.yml
    PluginManager pluginManager = this.getServer().getPluginManager(); // allows for events / permissions
    FileConfiguration config = this.getConfig(); // gets information from config

    public Map<UUID, ChannelType> chatChannel = new HashMap<UUID, ChannelType>(); // usings UUIDs rather than Player because UUIDs don't change

    public Permission scAdmin = new Permission("sc.admin");
    public Permission scStaff = new Permission("sc.staff");

    public boolean KEEP_PLAYER_DATA = config.getBoolean("general.keep_player_data");
    public String NOT_PLAYER = ChatColor.translateAlternateColorCodes('&', config.getString("general.not_player"));
    public String NO_PERMISSION = ChatColor.translateAlternateColorCodes('&', config.getString("general.no_permission"));

    @Override
    public void onEnable() {
        getLogger().info("StaffChat v" + pdfFile.getVersion() + " has been enabled.");

        pluginManager.registerEvents(new SCJoinQuit(this), this);
        pluginManager.registerEvents(new SCChat(this), this);
        pluginManager.addPermission(scAdmin);
        pluginManager.addPermission(scStaff);

        this.saveDefaultConfig();

        getCommand("chat").setTabCompleter(new ChatCommand(this)); // switching channel command
        getCommand("schat").setExecutor(new StaffChatCommand(this)); // sends specific message to staff channel
        getCommand("achat").setExecutor(new AdminChatCommand(this)); // sends specific message to admin channel
        getCommand("staffchat").setExecutor(new CommandExecutor() { // debug command only reload for developers <3
            @Override
            public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
                if (command.getName().equalsIgnoreCase("staffchat")) {
                    if (commandSender.hasPermission(scAdmin)) {
                        if (args.length == 0 || args.length >= 2) {
                            commandSender.sendMessage(ChatColor.RED + "Too many arguments, the correct syntax is: /staffchat dumpchannels");
                            return false;
                        } else {
                            if (args[0].equalsIgnoreCase("dumpchannels")) {
                                commandSender.sendMessage("UUID, PlayerName (ifOnline), Channel");
                                for (Map.Entry<UUID, ChannelType> entry : chatChannel.entrySet()) {
                                    commandSender.sendMessage(entry.getKey() + ", " + Bukkit.getPlayer(entry.getKey()) + ", " + entry.getValue().getChannel());
                                }
                                return true;
                            } else {
                                commandSender.sendMessage(ChatColor.RED + "Too many arguments, the correct syntax is: /staffchat dumpchannels");
                                return false;
                            }
                        }
                    } else {
                        commandSender.sendMessage(NO_PERMISSION);
                        return true;
                    }
                }
                return false;
            }
        });
    }

    @Override
    public void onDisable() {
        getLogger().info("StaffChat v" + pdfFile.getVersion() + " has been disabled.");
        this.saveConfig();
    }

}
