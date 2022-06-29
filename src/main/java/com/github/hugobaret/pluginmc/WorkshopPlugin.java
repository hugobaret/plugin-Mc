package com.github.hugobaret.pluginmc;

import com.github.hugobaret.pluginmc.command.EpitechCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class WorkshopPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("WorkshopPlugin is enabled!");
        this.getCommand("epitech").setExecutor(new EpitechCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info("WorkshopPlugin is disabled!");
    }
}