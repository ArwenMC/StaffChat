package com.arwenmc.commands;

import com.arwenmc.StaffChat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.List;

public class ChatCommand implements CommandExecutor, TabExecutor {

    StaffChat plugin;
    public ChatCommand(StaffChat plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        return false;
    }

    public List<String> onTabComplete(CommandSender commandSender, Command command, String label, String[] args) {
        return null;
    }
}
