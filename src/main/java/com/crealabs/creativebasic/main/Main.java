package com.crealabs.creativebasic.main;

import com.crealabs.creativebasic.managers.RegisterCommands;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {
    private final FileConfiguration config = getConfig();
    @Override
    public void onEnable() {
        Logger.getGlobal().info("[CreativeBasic] Enable all settings");
        new RegisterCommands(this).registerCommands();
        loadDefaultConfig();
    }

    @Override
    public void onDisable() {
        Logger.getGlobal().info("[CreativeBasic] Disable all settings");
    }

    public void loadDefaultConfig(){
        saveConfig();
    }
}
