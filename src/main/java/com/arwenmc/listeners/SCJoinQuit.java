package com.arwenmc.listeners;

import com.arwenmc.StaffChat;
import com.arwenmc.util.ChannelType;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class SCJoinQuit implements Listener {

    StaffChat plugin;
    public SCJoinQuit(StaffChat plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player eventPlayer = event.getPlayer();
        UUID playerUUID = eventPlayer.getUniqueId();

        plugin.chatChannel.put(playerUUID, ChannelType.DEFAULT); // adds the player to the default group, of course they could change this.

        if (plugin.KEEP_PLAYER_DATA) {
            if (!(plugin.chatChannel.containsKey(playerUUID))) {
                plugin.chatChannel.put(playerUUID, ChannelType.DEFAULT); // adds the player to the hashmap
            }
        }

        if (plugin.chatChannel.containsKey(playerUUID)) {
            eventPlayer.sendMessage(ChatColor.GREEN + "Hey, you are set to talk on channel: " + plugin.chatChannel.get(playerUUID).getChannel());
        }
    }

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event) {
        Player eventPlayer = event.getPlayer();
        UUID playerUUID = eventPlayer.getUniqueId();
        if (!(plugin.KEEP_PLAYER_DATA)) {
            plugin.chatChannel.remove(playerUUID); // removes the player from the hashmap as they have now disconnected
        }
    }
}
