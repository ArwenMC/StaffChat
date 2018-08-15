package com.arwenmc.listeners;

import com.arwenmc.StaffChat;
import com.arwenmc.util.ChannelType;
import org.bukkit.entity.Player;
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
        Player eventPlayer = event.getPlayer();
        UUID playerUUID = eventPlayer.getUniqueId();
        if (eventPlayer.hasPermission(plugin.scAdmin)) {
            // add admin's UUID to ArrayList
            plugin.admin.add(playerUUID);
        } else if (eventPlayer.hasPermission(plugin.scStaff)) {
            // add staff's UUID to ArrayList
            plugin.staff.add(playerUUID);
        }
    }

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event) {
        Player eventPlayer = event.getPlayer();
        UUID playerUUID = eventPlayer.getUniqueId();
        if (event.getPlayer().hasPermission(plugin.scAdmin)) {
            if (plugin.chatChannel.containsKey(playerUUID)) {
                // remove to admin group
                plugin.chatChannel.put(playerUUID, ChannelType.ADMIN)
            }
        } else if (event.getPlayer().hasPermission(plugin.scStaff)) {
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

    public void addToGroup(Player player) {

    }

}
