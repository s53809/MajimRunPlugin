package org.example;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MajimRun extends JavaPlugin {

    public int timer = 5*60;
    public int lastTime = 1*60;
    private static MajimRun instance;
    public static MajimRun Ins() {
        return instance;
    }
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
        getServer().getPluginManager().registerEvents(new CommandTimer(), this);
        getServer().getPluginManager().registerEvents(new MajimTracker(), this);
        getServer().getPluginManager().registerEvents(new DelayedTask(this), this);

    }

    @Override
    public void onDisable() {
        getLogger().info("OnDisable is called");
    }

    public void BongIn(Player player, long second){
        try{
            Thread.sleep(1000 * second);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * 60, 249));
            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20 * 60, 249));
        }catch(InterruptedException e){

        }
    }
}

