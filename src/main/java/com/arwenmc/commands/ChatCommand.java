package com.arwenmc.commands;

import com.arwenmc.StaffChat;
import com.google.common.collect.Lists;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.Arrays;
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
        List<String> argOne = Arrays.asList("reload");
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
