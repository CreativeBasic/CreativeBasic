package com.crealabs.creativebasic.commands;

import com.crealabs.creativebasic.main.Main;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;

public class BackCommand extends BukkitRunnable implements CommandExecutor {

    Player user;
    World world;
    int x;
    int y;
    int z;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;

        File file = new File("plugins/CreativeBasic/PlayerData",p.getPlayer().getUniqueId() +".yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        if(config.get("lastlocation") == null){
            p.sendMessage("§7You don't have last location !");
            return false;
        }
        this.user = p;
        this.world = (World) config.get("lastlocation.world");
        this.x = config.getInt("lastlocation.x");
        this.y = config.getInt("lastlocation.y");
        this.z = config.getInt("lastlocation.z");
        this.runTaskTimerAsynchronously(Main.getInstance(), 20L,20L);
        return false;
    }
    int i = 0;
    @Override
    public void run() {
        if(i >= 5) {
            user.teleport(new Location(world, x, y, z));
            user.sendMessage("Successfully teleported !");
            this.cancel();
            i=0;
        }
        user.sendMessage("§c"+i);
        i++;
    }

}
