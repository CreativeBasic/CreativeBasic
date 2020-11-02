package com.crealabs.creativebasic.listeners;

import com.crealabs.creativebasic.main.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerListeners implements Listener {
    private final Main plugin;
    public PlayerListeners(Main main) {
        plugin = main;
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
}
