package com.arwenmc.commands;

import com.arwenmc.StaffChat;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabExecutor;

public class ChatCommand implements CommandExecutor, TabExecutor {

    StaffChat plugin;
    public ChatCommand(StaffChat plugin) {
        this.plugin = plugin;
    }
}
