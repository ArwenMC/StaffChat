package com.arwenmc;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class StaffChat extends JavaPlugin {

    PluginDescriptionFile pdfFile = this.getDescription();

    @Override
    public void onEnable() {
        getLogger().info("StaffChat v" + pdfFile.getVersion() + " has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("StaffChat v" + pdfFile.getVersion() + " has been disabled.");
    }

}
