package com.crealabs.creativebasic.main;

import com.crealabs.creativebasic.commands.BackCommand;
import com.crealabs.creativebasic.commands.GamemodeCommand;
import com.crealabs.creativebasic.commands.HelpCommand;
import com.crealabs.creativebasic.commands.WarpCommand;
import com.crealabs.creativebasic.listeners.PlayerListeners;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Logger;

public class Main extends JavaPlugin {
    private FileConfiguration config;
    File cfile;
    static Main instance;
    @Override
    public void onEnable() {
        instance = this;
        Logger.getGlobal().info("[CreativeBasic] Enable all settings");
        registerCommands();
        registerEvents();
        config = getConfig();
        config.options().copyDefaults(true);
        saveDefaultConfig();
        cfile = new File(getDataFolder(), "config.yml");
    }

    private void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerListeners(this),this);
    }

    public static Main getInstance() {
        return instance;
    }
    public void registerCommands(){
        this.getCommand("help").setExecutor(new HelpCommand());
        this.getCommand("back").setExecutor(new BackCommand());
        this.getCommand("warp").setExecutor(new WarpCommand());
        this.getCommand("setwarp").setExecutor(new WarpCommand());
        this.getCommand("delwarp").setExecutor(new WarpCommand());
        this.getCommand("gamemode").setExecutor(new GamemodeCommand());
    }
    @Override
    public void onDisable() {
        Logger.getGlobal().info("[CreativeBasic] Disable all settings");
    }
}
