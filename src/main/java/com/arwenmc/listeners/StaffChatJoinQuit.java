package com.arwenmc.listeners;

import com.arwenmc.StaffChat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class StaffChatJoinQuit implements Listener {

    StaffChat plugin;
    public StaffChatJoinQuit(StaffChat plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        UUID playerUUID = event.getPlayer().getUniqueId();
        if (event.getPlayer().hasPermission("sc.admin")) {
            // add to admin group
            plugin.admin.add(playerUUID);
        } else if (event.getPlayer().hasPermission("sc.staff")) {
            // add to staff group
            plugin.staff.add(playerUUID);
        } else {
            // add to regular group
            plugin.player.add(playerUUID);
        }
    }

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event) {
        UUID playerUUID = event.getPlayer().getUniqueId();
        if (event.getPlayer().hasPermission("sc.admin")) {
            if (plugin.admin.contains(playerUUID)) {
                // remove to admin group
                plugin.admin.remove(playerUUID);
            }
        } else if (event.getPlayer().hasPermission("sc.staff")) {
            if (plugin.admin.contains(playerUUID)) {
                // remove to staff group
                plugin.staff.add(playerUUID);
            }
        } else {
            if (plugin.player.contains(playerUUID)) {
                // remove to regular group
                plugin.player.add(playerUUID);
            }
        }
    }

}
