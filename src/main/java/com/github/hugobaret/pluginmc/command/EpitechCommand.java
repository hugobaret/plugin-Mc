package com.github.hugobaret.pluginmc.command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.ChatColor;

public class EpitechCommand implements CommandExecutor {
    @Override
    public boolean onCommand(org.bukkit.command.CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.AQUA + "Marvin -42!");
        return true;
    }
}
