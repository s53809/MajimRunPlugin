package org.example;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
public class EventListener implements Listener{
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        event.setJoinMessage(
                ChatColor.GREEN + "마1짐 서버에 " + event.getPlayer().getName() + " 등장!!!");
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent e){
        DiamondTracker diamondTracker = new DiamondTracker();

        Player player = e.getPlayer();
        Action action = e.getAction();

        if (action == Action.RIGHT_CLICK_AIR) {
            if(player.getInventory().getItemInMainHand().getType() == Material.DIAMOND){
                if(MajimHandler.Ins().GetMajim() == null) return;
                diamondTracker.SetPlayer(player, MajimHandler.Ins().GetMajim());
                diamondTracker.DiamondTracking();
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
            }
        }
    }
}
