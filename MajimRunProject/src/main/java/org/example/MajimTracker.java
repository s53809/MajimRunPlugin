package org.example;
import org.bukkit.Bukkit;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class MajimTracker implements Listener {

    Player majim;
    boolean isGameStart = false;
    @EventHandler
    public void OnWorldBorderEvent(StartGameEvent event){
        Bukkit.broadcastMessage("MajimTracker 실행 완료");
        majim = MajimHandler.Ins().GetMajim();
        Bukkit.broadcastMessage("Majim is " + majim.getName());
        isGameStart = true;

        List<Player> players;
        players = (List<Player>)Bukkit.getOnlinePlayers();
        for(int i = 0;i<players.size();i++){
            Location loca = players.get(i).getLocation();
            loca.setWorld(players.get(i).getWorld());
            loca.setX(MajimRunner.Ins().mWorldBorderCenterX +
                    (((MajimRunner.Ins().mWorldBorderSize / 2) - 2)
                            * Math.cos((360 / players.size()) * i)));
            loca.setY(10);
            loca.setZ(MajimRunner.Ins().mWorldBorderCenterZ +
                    (((MajimRunner.Ins().mWorldBorderSize / 2) - 2)
                            * Math.sin((360 / players.size()) * i)));
            loca.setY(players.get(i).getWorld().getHighestBlockAt((int)loca.getX(), (int)loca.getZ()).getY() + 2);
            loca.setY(loca.getY() + 3);

            players.get(i).teleport(loca);
        }
    }

    @EventHandler
    public void PlayerWalkEvent(PlayerMoveEvent event){
        if(!isGameStart || !MajimHandler.Ins().isSaigonoTime) return;
        
        Title.sendActionBarAll("마짐의 좌표 : " +
                (int)majim.getLocation().getX() + " " +
                (int)majim.getLocation().getY() + " " +
                (int)majim.getLocation().getZ());
    }

    @EventHandler
    public void PlayerDeadEvent(EntityResurrectEvent event){
        if(event.getEntityType() == EntityType.PLAYER){
            Player player = (Player)event.getEntity();
            if(player == MajimHandler.Ins().GetMajim()){
                EndGameEvent ev = new EndGameEvent();

                Bukkit.getPluginManager().callEvent(ev);
                if(!ev.isCancelled()){
                    ev.setCancelled(true);
                }
                player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 20 * 60, 100));
                Title.sendTitleAll("마짐이 사망하였습니다 추격자의 승리!",
                        player.getLastDamageCause().getEntity().getName() + "의 막타!",
                        1, 50, 1);
            }
            else{
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * 60, 100));
            }
            event.setCancelled(false);
            player.playEffect(EntityEffect.TOTEM_RESURRECT);
        }
    }
}