package com.arwenmc.listeners;

import com.arwenmc.StaffChat;
import com.arwenmc.util.ChannelType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class StaffChatChat implements Listener {

    @EventHandler
    public void onPlayerChatEvent(AsyncPlayerChatEvent event) {
        ChannelType type = new StaffChat().chatChannel.get(event.getPlayer().getUniqueId());
    }

}
