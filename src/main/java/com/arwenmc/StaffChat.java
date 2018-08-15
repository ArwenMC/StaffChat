package com.arwenmc;

import com.arwenmc.listeners.StaffChatJoin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class StaffChat extends JavaPlugin {

    PluginDescriptionFile pdfFile = this.getDescription();
    PluginManager pluginManager = this.getServer().getPluginManager();

    @Override
    public void onEnable() {
        getLogger().info("StaffChat v" + pdfFile.getVersion() + " has been enabled.");

        pluginManager.registerEvents(new StaffChatJoin(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("StaffChat v" + pdfFile.getVersion() + " has been disabled.");
    }

}
