package com.arwenmc;

import com.arwenmc.listeners.StaffChatJoinLeave;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.UUID;

public class StaffChat extends JavaPlugin {

    PluginDescriptionFile pdfFile = this.getDescription();
    PluginManager pluginManager = this.getServer().getPluginManager();

    public ArrayList<UUID> admin = new ArrayList<UUID>();
    public ArrayList<UUID> staff = new ArrayList<UUID>();
    public ArrayList<UUID> player = new ArrayList<UUID>();

    @Override
    public void onEnable() {
        getLogger().info("StaffChat v" + pdfFile.getVersion() + " has been enabled.");

        pluginManager.registerEvents(new StaffChatJoinLeave(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("StaffChat v" + pdfFile.getVersion() + " has been disabled.");
    }

}
