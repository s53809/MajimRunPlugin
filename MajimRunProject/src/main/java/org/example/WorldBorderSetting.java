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
    public void OnWorldBorderEvent(StartGameEvent event){
        Bukkit.broadcastMessage("월드보더 셋팅 함수 호출 완료");

        WorldBorder wb = Bukkit.getWorld("world").getWorldBorder();
        wb.setCenter(MajimRunner.Ins().mWorldBorderCenterX, MajimRunner.Ins().mWorldBorderCenterZ);
        wb.setSize(MajimRunner.Ins().mWorldBorderSize);
    }

    public void OffWorldBorderEvent(EndGameEvent event){
        WorldBorder wb = Bukkit.getWorld("world").getWorldBorder();
        wb.reset();
    }
}
