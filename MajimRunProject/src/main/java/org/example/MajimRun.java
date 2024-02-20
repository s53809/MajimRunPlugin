package org.example;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MajimRun extends JavaPlugin {

    public static void main(String[] args) {

    }

    @Override
    public void onEnable() {
        getLogger().info("OnEnable is called");
        this.getCommand("minseo").setExecutor(new CommandMinseo());
        this.getCommand("setMajim").setExecutor(new CommandSetMajim());
        this.getCommand("majimRunSetting").setExecutor(new CommandMajimRunSetting());
        this.getCommand("timer").setExecutor(new CommandTimer());
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        getServer().getPluginManager().registerEvents(new WorldBorderSetting(), this);
        getServer().getPluginManager().registerEvents(new MajimTracker(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("OnDisable is called");
    }
}

