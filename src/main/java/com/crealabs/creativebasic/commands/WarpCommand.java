package com.crealabs.creativebasic.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.io.File;
import java.io.IOException;

public class WarpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        File file = new File("plugins/CreativeBasic","warps.yml");
        YamlConfiguration warps = YamlConfiguration.loadConfiguration(file);

        if (cmd.getName().equalsIgnoreCase("delwarp")) {
            if (p.hasPermission("creativebasic.cmd.delwarp")) {
                if (args.length == 1) {

                    if (warps.getString(args[0]) != null) {
                        warps.set(args[0], null);
                        p.sendMessage("§cYou have remove warp : " + args[0]);
                        try {
                            warps.save(file);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        p.sendMessage("§cWarp not exist !");
                    }
                } else {
                    p.sendMessage("§cUsage: /delwarp <name>");
                }
            } else {
                p.sendMessage("§cError you don't have permission for this !");
            }
        }
        if(cmd.getName().equalsIgnoreCase("setwarp")){
            if (p.hasPermission("creativebasic.cmd.setwarp")) {
                if (args.length == 1) {
                    String world = p.getWorld().getName();
                    double x = p.getLocation().getX();
                    double y = p.getLocation().getY();
                    double z = p.getLocation().getZ();
                    double yaw = p.getLocation().getYaw();
                    double pitch = p.getLocation().getPitch();
                    warps.set(String.valueOf(args[0]) + ".world", world);
                    warps.set(String.valueOf(args[0]) + ".x", Double.valueOf(x));
                    warps.set(String.valueOf(args[0]) + ".y", Double.valueOf(y));
                    warps.set(String.valueOf(args[0]) + ".z", Double.valueOf(z));
                    warps.set(String.valueOf(args[0]) + ".yaw", Double.valueOf(yaw));
                    warps.set(String.valueOf(args[0]) + ".pitch", Double.valueOf(pitch));
                    try {
                        warps.save(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    p.sendMessage("§4[§cArmaCommand§4] §cTu as bien crée le warp §4" + args[0]+ " §c!");
                } else {
                    p.sendMessage("§4[§cArmaCommand§4] §c/setwarp <Warp>");
                }
            } else {
                p.sendMessage("§4[§cArmaCommand§4] §cTu n'as pas la permission pour faire ceci");
            }
        }
        if(cmd.getName().equalsIgnoreCase("warp")){
            if (p.hasPermission("creativebasic.cmd.warp")) {
                if(args.length == 0){
                    int i = 0;
                    p.sendMessage("§cList of warps :");
                    for (String key : warps.getKeys(true)) {
                        if (!key.contains(".")) {
                            i++;
                            p.sendMessage( "§9" + i + " : §b" + key);
                        }
                    }
                }
                if (args.length == 1) {
                    if (warps.getString(args[0]) != null) {
                        String world = warps.getString(String.valueOf(args[0]) + ".world");
                        double x = warps.getDouble(String.valueOf(args[0]) + ".x");
                        double y = warps.getDouble(String.valueOf(args[0]) + ".y");
                        double z = warps.getDouble(String.valueOf(args[0]) + ".z");
                        double yaw = warps.getDouble(String.valueOf(args[0]) + ".yaw");
                        double pitch = warps.getDouble(String.valueOf(args[0]) + ".pitch");
                        Location loc = new Location(Bukkit.getWorld(world), x, y, z);
                        loc.setPitch((float)pitch);
                        loc.setYaw((float)yaw);
                        p.teleport(loc);
                        p.sendMessage( "§cYou succesfully teleported to " + args[0]);
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDERMEN_TELEPORT,80,20);
                    } else {
                        p.sendMessage("§cWarp not exist !");
                    }
                }
            } else {
                p.sendMessage("§cError you don't have permission for this !");
            }
        }
        return false;

    }
}
