package com.arwenmc.commands;

import com.arwenmc.StaffChat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffChatCommand implements CommandExecutor {

    StaffChat plugin;
    public StaffChatCommand(StaffChat plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(plugin.NOT_PLAYER);
            return true;
        } else {
            Player player = (Player) commandSender;
            if (player.hasPermission(plugin.scStaff)) {
                // send messa
            } else {
                player.sendMessage(plugin.NO_PERMISSION);
                return true;
            }
        }
    }

}
