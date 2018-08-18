package com.arwenmc.commands;

import com.arwenmc.StaffChat;
import com.arwenmc.util.ChannelType;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class AdminChatCommand implements CommandExecutor {

    StaffChat plugin;
    public AdminChatCommand(StaffChat plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(plugin.NOT_PLAYER);
            return true;
        } else {
            Player player = (Player) commandSender;
            if (player.hasPermission(plugin.scAdmin)) {
                if (args.length <= 0) {
                    StringBuilder sb = new StringBuilder();
                    for (String s : args) {
                        sb.append(s).append(" ");
                    }
                    // TODO update this to use the hashmap
                    return true;
                } else {
                    player.sendMessage(ChatColor.RED + "Not enough arguments.");
                    return false;
                }
            } else {
                player.sendMessage(plugin.NO_PERMISSION);
                return true;
            }
        }
    }

}
