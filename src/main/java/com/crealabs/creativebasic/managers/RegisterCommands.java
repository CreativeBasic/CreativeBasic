package com.crealabs.creativebasic.managers;

import com.crealabs.creativebasic.commands.HelpCommand;
import com.crealabs.creativebasic.main.Main;

public class RegisterCommands {
    private final Main plugin;
    public RegisterCommands(Main main){
        plugin = main;
    }

    public void registerCommands(){
        this.plugin.getCommand("help").setExecutor(new HelpCommand());
    }
}
