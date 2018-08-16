package com.arwenmc;

import com.arwenmc.commands.AdminChatCommand;
import com.arwenmc.commands.ChatCommand;
import com.arwenmc.commands.StaffChatCommand;
import com.arwenmc.listeners.SCJoinQuit;
import com.arwenmc.util.ChannelType;
import net.md_5.bungee.api.ChatColor;
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

    // Array List
    public ArrayList<UUID> admin = new ArrayList<UUID>();
    public ArrayList<UUID> staff = new ArrayList<UUID>();
    public ArrayList<UUID> player = new ArrayList<UUID>();

    public Map<UUID, ChannelType> chatChannel = new HashMap<UUID, ChannelType>();

    public Permission scAdmin = new Permission("sc.admin");
    public Permission scStaff = new Permission("sc.staff");

    public String NOT_PLAYER = ChatColor.translateAlternateColorCodes('&', config.getString("general.not_player"));
    public String NO_PERMISSION = ChatColor.translateAlternateColorCodes('&', config.getString("general.no_permission"));

    @Override
    public void onEnable() {
        getLogger().info("StaffChat v" + pdfFile.getVersion() + " has been enabled.");

        pluginManager.registerEvents(new SCJoinQuit(this), this);
        pluginManager.addPermission(scAdmin);
        pluginManager.addPermission(scStaff);

        this.saveDefaultConfig();

        getCommand("chat").setTabCompleter(new ChatCommand(this)); // switching channel command
        getCommand("schat").setExecutor(new StaffChatCommand(this)); // sends specific message to staff channel
        getCommand("achat").setExecutor(new AdminChatCommand(this)); // sends specific message to admin channel
    }

    @Override
    public void onDisable() {
        getLogger().info("StaffChat v" + pdfFile.getVersion() + " has been disabled.");
        this.saveConfig();
    }

}
