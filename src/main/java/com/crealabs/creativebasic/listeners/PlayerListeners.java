package com.crealabs.creativebasic.listeners;

import com.crealabs.creativebasic.main.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import java.io.File;
import java.io.IOException;

public class PlayerListeners implements Listener {
    private final Main plugin;
    public PlayerListeners(Main main) {
        plugin = main;
    }


    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        File file = new File("plugins/CreativeBasic/PlayerData",e.getPlayer().getUniqueId() +".yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        config.set("name", e.getPlayer().getName());
        config.set("Location.world", e.getPlayer().getWorld().getName());
        config.set("Location.x", e.getPlayer().getLocation().getX());
        config.set("Location.y", e.getPlayer().getLocation().getY());
        config.set("Location.z", e.getPlayer().getLocation().getZ());
        config.set("Location.yaw", e.getPlayer().getLocation().getYaw());
        config.set("Location.pitch", e.getPlayer().getLocation().getPitch());
        config.set("lastlocation",null);
        try {
            config.save(file);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        File file = new File("plugins/CreativeBasic/PlayerData",e.getPlayer().getUniqueId() +".yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        config.set("name", e.getPlayer().getName());
        config.set("Location.world", e.getPlayer().getWorld().getName());
        config.set("Location.x", e.getPlayer().getLocation().getX());
        config.set("Location.y", e.getPlayer().getLocation().getY());
        config.set("Location.z", e.getPlayer().getLocation().getZ());
        config.set("Location.yaw", e.getPlayer().getLocation().getYaw());
        config.set("Location.pitch", e.getPlayer().getLocation().getPitch());
        config.set("lastlocation",null);
        try {
            config.save(file);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player player = e.getPlayer();
        FileConfiguration config = this.plugin.getConfig();
        if(!player.hasPermission(config.getString("Protection.BreakPermission"))){
            player.sendMessage("§cYou can't break !");
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent e){
        File file = new File("plugins/CreativeBasic/PlayerData", e.getPlayer().getUniqueId() +".yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        config.set("lastlocation.world",e.getFrom().getWorld());
        config.set("lastlocation.x",e.getFrom().getBlockX());
        config.set("lastlocation.y",e.getFrom().getBlockY());
        config.set("lastlocation.z",e.getFrom().getBlockZ());

        try {
            config.save(file);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
