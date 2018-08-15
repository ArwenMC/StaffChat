package com.arwenmc;

import com.arwenmc.commands.ChatCommand;
import com.arwenmc.listeners.StaffChatJoinQuit;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.UUID;

public class StaffChat extends JavaPlugin {

    PluginDescriptionFile pdfFile = this.getDescription();
    PluginManager pluginManager = this.getServer().getPluginManager();
    FileConfiguration config = this.getConfig();

    // Array List
    public ArrayList<UUID> admin = new ArrayList<UUID>();
    public ArrayList<UUID> staff = new ArrayList<UUID>();
    public ArrayList<UUID> player = new ArrayList<UUID>();

    public ArrayList<UUID> inAdminChat = new ArrayList<UUID>();
    public ArrayList<UUID> inStaffChat = new ArrayList<UUID>();

    public Permission scAdmin = new Permission("sc.admin");
    public Permission scStaff = new Permission("sc.staff");

    public String NOT_PLAYER = ChatColor.translateAlternateColorCodes('&', config.getString("general.not_player"));
    public String NO_PERMISSION = ChatColor.translateAlternateColorCodes('&', config.getString("general.no_permission"));

    @Override
    public void onEnable() {
        getLogger().info("StaffChat v" + pdfFile.getVersion() + " has been enabled.");

        pluginManager.registerEvents(new StaffChatJoinQuit(this), this);
        pluginManager.addPermission(scAdmin);
        pluginManager.addPermission(scStaff);

        getCommand("chat").setTabCompleter(new ChatCommand(this));
    }

    @Override
    public void onDisable() {
        getLogger().info("StaffChat v" + pdfFile.getVersion() + " has been disabled.");
    }

}
