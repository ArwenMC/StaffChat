package com.arwenmc.listeners;

import com.arwenmc.StaffChat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class StaffChatJoinQuit implements Listener {

    StaffChat plugin;
    public StaffChatJoinQuit(StaffChat plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        if (event.getPlayer().hasPermission("sc.admin")) {
            // add to admin group
            plugin.admin.add(event.getPlayer().getUniqueId());
        } else if (event.getPlayer().hasPermission("sc.staff")) {
            // add to staff group
            plugin.staff.add(event.getPlayer().getUniqueId());
        } else {
            // add to regular group
            plugin.player.add(event.getPlayer().getUniqueId());
        }
    }

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event) {
        if (event.getPlayer().hasPermission("sc.admin")) {
            if (plugin.admin.contains(event.getPlayer().getUniqueId())) {
                // remove to admin group
                plugin.admin.remove(event.getPlayer().getUniqueId());
            }
        } else if (event.getPlayer().hasPermission("sc.staff")) {
            if (plugin.admin.contains(event.getPlayer().getUniqueId())) {
                // remove to staff group
                plugin.staff.add(event.getPlayer().getUniqueId());
            }
        } else {
            if (plugin.player.contains(event.getPlayer().getUniqueId())) {
                // remove to regular group
                plugin.player.add(event.getPlayer().getUniqueId());
            }
        }
    }

}
