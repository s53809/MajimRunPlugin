package org.example;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.WorldBorder;
import org.bukkit.Bukkit;
public class WorldBorderSetting implements Listener{

    @EventHandler
    public void WorldBorderSetting(StartGameEvent event){
        WorldBorder wb = Bukkit.getWorld("world").getWorldBorder();
        wb.setCenter(MajimRunner.Ins().mWorldBorderCenterX, MajimRunner.Ins().mWorldBorderCenterZ);
        wb.setSize(MajimRunner.Ins().mWorldBorderSize);
    }
}
