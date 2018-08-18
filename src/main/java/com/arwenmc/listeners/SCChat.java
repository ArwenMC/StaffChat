package com.arwenmc.listeners;

import com.arwenmc.StaffChat;
import com.arwenmc.util.ChannelType;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.UUID;

public class SCChat implements Listener {

    StaffChat plugin;
    public SCChat(StaffChat plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerChatEvent(AsyncPlayerChatEvent event) {
        ChannelType type = new StaffChat().chatChannel.get(event.getPlayer().getUniqueId());

        if (type.equals(ChannelType.ADMIN)) {
            // TODO update to hashmap
        }
    }

}
