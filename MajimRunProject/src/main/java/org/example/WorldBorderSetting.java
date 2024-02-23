package org.example;

import org.bukkit.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;

public class WorldBorderSetting implements Listener{

    @EventHandler
    public void OnWorldBorderEvent(StartGameEvent event){
        Bukkit.broadcastMessage("월드보더 셋팅 함수 호출 완료");

        WorldBorder wb = Bukkit.getWorld("world").getWorldBorder();
        wb.setCenter(MajimRunner.Ins().mWorldBorderCenterX, MajimRunner.Ins().mWorldBorderCenterZ);
        wb.setSize(MajimRunner.Ins().mWorldBorderSize);
    }

    @EventHandler
    public void OffWorldBorderEvent(EndGameEvent event){
        WorldBorder wb = Bukkit.getWorld("world").getWorldBorder();
        MajimHandler.Ins().isGameStart = false;
        wb.setCenter(0,0);
        wb.setSize(30000000);
    }
}
