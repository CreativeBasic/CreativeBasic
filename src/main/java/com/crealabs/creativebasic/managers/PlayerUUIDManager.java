package com.crealabs.creativebasic.managers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.io.IOException;

public class PlayerUUIDManager implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        File file = new File("plugins/CreativeBasic/PlayerData",String.valueOf(e.getPlayer().getUniqueId()));
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        config.set("name", e.getPlayer().getName());
        config.set("Location.world", e.getPlayer().getWorld().getName());
        config.set("Location.x", e.getPlayer().getLocation().getX());
        config.set("Location.y", e.getPlayer().getLocation().getY());
        config.set("Location.z", e.getPlayer().getLocation().getZ());
        config.set("Location.yaw", e.getPlayer().getLocation().getYaw());
        config.set("Location.pitch", e.getPlayer().getLocation().getPitch());
        try {
            config.save(file);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        File file = new File("plugins/CreativeBasic/PlayerData",String.valueOf(e.getPlayer().getUniqueId()));
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        config.set("name", e.getPlayer().getName());
        config.set("Location.world", e.getPlayer().getWorld().getName());
        config.set("Location.x", e.getPlayer().getLocation().getX());
        config.set("Location.y", e.getPlayer().getLocation().getY());
        config.set("Location.z", e.getPlayer().getLocation().getZ());
        config.set("Location.yaw", e.getPlayer().getLocation().getYaw());
        config.set("Location.pitch", e.getPlayer().getLocation().getPitch());
        try {
            config.save(file);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
