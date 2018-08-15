package com.arwenmc.listeners;

import com.arwenmc.StaffChat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class StaffChatJoin implements Listener {

    StaffChat plugin;
    public StaffChatJoin(StaffChat plugin) {
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

}
