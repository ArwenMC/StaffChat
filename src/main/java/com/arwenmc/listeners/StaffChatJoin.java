package com.arwenmc.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class StaffChatJoin implements Listener {

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        if (event.getPlayer().hasPermission("sc.admin")) {
            // add to admin group
        } else if (event.getPlayer().hasPermission("sc.staff")) {
            // add to staff group
        }
    }

}
