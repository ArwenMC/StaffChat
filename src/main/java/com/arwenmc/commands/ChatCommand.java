package com.arwenmc.commands;

import com.arwenmc.StaffChat;
import org.bukkit.command.CommandExecutor;

public class ChatCommand implements CommandExecutor {

    StaffChat plugin;
    public ChatCommand(StaffChat plugin) {
        this.plugin = plugin;
    }
}
