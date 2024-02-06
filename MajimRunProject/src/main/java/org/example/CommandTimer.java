package org.example;

import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.NamespacedKey;

import java.io.File;

public class CommandTimer implements CommandExecutor {
    private final MajimRun plugin = MajimRun.getPlugin(MajimRun.class);

    private final String key = "CommandTimer";
    private final NamespacedKey namespacedKey = new NamespacedKey(plugin, key);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Bukkit.createBossBar(namespacedKey, key, BarColor.RED, BarStyle.SOLID);

        Bukkit.broadcastMessage("Started");
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.runTaskTimer(plugin,() -> {
            Bukkit.broadcastMessage("Mooooo!");
            }, 20L * 10L, 20L*5L);

        return false;
    }
}
