package com.arwenmc.commands;

import com.arwenmc.StaffChat;
import com.arwenmc.util.ChannelType;
import com.google.common.collect.Lists;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class ChatCommand implements CommandExecutor, TabExecutor {

    StaffChat plugin;
    public ChatCommand(StaffChat plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(plugin.NOT_PLAYER);
            return true;
        } else {
            Player player = (Player) commandSender;
            if (player.hasPermission(plugin.scStaff) || player.hasPermission(plugin.scAdmin)) {
                if (args.length == 0) {
                    player.sendMessage(ChatColor.RED + "You must specify a chat channel.");
                }
                // either staff or admin
            } else {
                commandSender.sendMessage(plugin.NO_PERMISSION);
                return true;
            }
        }
        return false;
    }

    public List<String> onTabComplete(CommandSender commandSender, Command command, String label, String[] args) {
        List<String> argOne = Arrays.asList("regular", "staff", "admin", "get");
        List<String> listFinal = Lists.newArrayList();

        switch (args.length) {
            case 1:
                for (String s : argOne) {
                    if (s.startsWith(args[0])) listFinal.add(s);
                }
                return listFinal;
        }
        return null;
    }
}
