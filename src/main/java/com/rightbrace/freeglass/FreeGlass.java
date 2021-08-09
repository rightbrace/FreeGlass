package com.rightbrace.freeglass;

import org.bukkit.plugin.java.JavaPlugin;
public class FreeGlass extends JavaPlugin {
    
    @Override
    public void onEnable() {
        getCommand("freeglass").setExecutor(new FreeGlassCommand());
    }
    
}
