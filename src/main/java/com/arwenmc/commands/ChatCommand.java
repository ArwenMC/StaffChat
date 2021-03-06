package com.arwenmc.commands;

import com.arwenmc.StaffChat;
import com.arwenmc.util.ChannelType;
import com.google.common.collect.Lists;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
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
                // either staff or admin
                if (args.length == 0) {
                    player.sendMessage(ChatColor.RED + "You must specify a chat channel.");
                    return false;
                } else if (args.length == 1) {
                    // successful amount of arguments.
                    switch (args[0]) {
                        case "admin":
                            addPlayerToGroup(player, ChannelType.ADMIN);
                        case "staff":
                            addPlayerToGroup(player, ChannelType.STAFF);
                        case "default":
                            addPlayerToGroup(player, ChannelType.DEFAULT);
                        case "get":
                            player.sendMessage(ChatColor.GREEN + "You are currently in the channel: " + plugin.chatChannel.get(player.getUniqueId()).getChannel()); // gets the pluginchannel
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Too many arguments, please check your syntax");
                    return false;
                }
            } else {
                commandSender.sendMessage(plugin.NO_PERMISSION);
                return true;
            }
        }
        return false;
    }

    public List<String> onTabComplete(CommandSender commandSender, Command command, String label, String[] args) {
        List<String> argOne = Arrays.asList("admin", "get", "default", "staff");
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

    public void addPlayerToGroup(Player player, ChannelType channelType) {
        if (!(plugin.chatChannel.get(player.getUniqueId()).equals(channelType))) {
            if (channelType.equals(ChannelType.ADMIN)) {
                if (player.hasPermission(plugin.scAdmin)) {
                    plugin.chatChannel.put(player.getUniqueId(), ChannelType.ADMIN);
                } else {

                }
            } else if (channelType.equals(ChannelType.STAFF)) {
                if (player.hasPermission(plugin.scAdmin) || player.hasPermission(plugin.scStaff)) {

                }
            } else if (channelType.equals(ChannelType.DEFAULT)) {

            } else {
                Bukkit.getLogger().severe("Error when given channel. Channel given " + channelType + " was unknown.");
                throw new IllegalArgumentException("Error when given channel. Channel given " + channelType + " was unknown.");
            }
        } else {
            player.sendMessage(ChatColor.GREEN + "You are already in the channel: " + channelType.getChannel());
        }
    }
}
