package me.notdew.com.destroy;

import org.bukkit.plugin.java.JavaPlugin;

public final class Destroy extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("destroy").setExecutor(new DestroyCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
