package com.crealabs.creativebasic.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(cmd.getName().equalsIgnoreCase("gamemode")){
            if(args.length == 0){
                sender.sendMessage("§cUsage : /gamemode [0,1,2,3] <name>");
            }
            if(args.length == 1){
                Player p = (Player)sender;
                if(!(sender instanceof Player))return false;
                if(args[0].equalsIgnoreCase("0")){
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage("§cYour gamemode changed to Gamemode survival !");
                    return true;
                }
                if(args[0].equalsIgnoreCase("1")){
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage("§cYour gamemode changed to Gamemode creative !");
                    return true;
                }
                if(args[0].equalsIgnoreCase("2")){
                    p.setGameMode(GameMode.ADVENTURE);
                    p.sendMessage("§cYour gamemode changed to Gamemode adventure !");
                    return true;
                }
                if(args[0].equalsIgnoreCase("3")){
                    p.setGameMode(GameMode.SPECTATOR);
                    p.sendMessage("§cYour gamemode changed to gamemode spectator !");
                    return true;
                }
            }
            if(args.length == 2){
                Player target = Bukkit.getPlayer(args[1]);
                if(target == null){
                    sender.sendMessage("§c"+target+" not found !");
                    return false;
                }
                if(args[0].equalsIgnoreCase("0")){
                    target.setGameMode(GameMode.SURVIVAL);
                    target.sendMessage("§cYour gamemode changed to Gamemode survival !");
                    return true;
                }
                if(args[0].equalsIgnoreCase("1")){
                    target.setGameMode(GameMode.CREATIVE);
                    target.sendMessage("§cYour gamemode changed to Gamemode creative !");
                    return true;
                }
                if(args[0].equalsIgnoreCase("2")){
                    target.setGameMode(GameMode.ADVENTURE);
                    target.sendMessage("§cYour gamemode changed to Gamemode adventure !");
                    return true;
                }
                if(args[0].equalsIgnoreCase("3")){
                    target.setGameMode(GameMode.SPECTATOR);
                    target.sendMessage("§cYour gamemode changed to gamemode spectator !");
                    return true;
                }
            }
        }
        return false;
    }
}
