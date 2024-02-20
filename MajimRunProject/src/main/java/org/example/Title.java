package org.example;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;

public class Title {

    public static void sendActionBar(Player player, String text){
        Bukkit.broadcastMessage(player.getName() + "에게 메세지를 보냅니다.");
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(text));
    }

    public static void sendActionBar(List<Player> players, String text){
        for(Player player : players){
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(text));
        }
    }

    @SuppressWarnings("unchecked")
    public static void sendActionBarAll(String text){
        sendActionBar((List<Player>) Bukkit.getOnlinePlayers(), text);
    }

    public static void sendTitle(Player player, String title, String subTitle, int fadeInTime, int stayTime, int fadeOutTime){
        player.sendTitle(title, subTitle, fadeInTime, stayTime, fadeOutTime);
    }

    public static void sendTitle(Player player, String title, int fadeInTime, int stayTime, int fadeOutTime){
        player.sendTitle(title, "", fadeInTime, stayTime, fadeOutTime);
    }

    public static void sendTitle(List<Player> players, String title, String subTitle, int fadeInTime, int stayTime, int fadeOutTime){
        for(Player player : players){
            player.sendTitle(title, subTitle, fadeInTime, stayTime, fadeOutTime);
        }
    }

    @SuppressWarnings("unchecked")
    public static void sendTitleAll(String title, String subTitle, int fadeInTime, int stayTime, int fadeOutTime){
        sendTitle((List<Player>) Bukkit.getOnlinePlayers(), title, subTitle, fadeInTime, stayTime, fadeOutTime);
    }
}
