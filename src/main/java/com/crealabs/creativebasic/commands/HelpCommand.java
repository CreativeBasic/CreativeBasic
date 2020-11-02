package com.crealabs.creativebasic.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(cmd.getName().equalsIgnoreCase("help")){
            sender.sendMessage("§7§m----------------- §8CreativeBasic §7§m-----------------");
            sender.sendMessage("§7");
            sender.sendMessage("§71-");
            return true;
        }
        return false;
    }
}
