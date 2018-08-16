package com.arwenmc.listeners;

import com.arwenmc.StaffChat;
import com.arwenmc.util.ChannelType;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.UUID;

public class SCListener implements Listener {

    @EventHandler
    public void onPlayerChatEvent(AsyncPlayerChatEvent event) {
        ChannelType type = new StaffChat().chatChannel.get(event.getPlayer().getUniqueId());

        if (type.equals(ChannelType.ADMIN)) {
            for (UUID uuid : new StaffChat().player) {
                event.getRecipients().remove(Bukkit.getPlayer(uuid));
            }
            for (UUID uuid : new StaffChat().admin) {
                event.getRecipients().add(Bukkit.getPlayer(uuid));
            }
        }
    }

}
