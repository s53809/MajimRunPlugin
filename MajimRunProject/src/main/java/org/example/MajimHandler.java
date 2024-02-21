package org.example;

import org.bukkit.entity.Player;

public class MajimHandler {
    private static MajimHandler instance;

    public static MajimHandler Ins(){
        if(instance == null) instance = new MajimHandler();
        return instance;
    }

    private Player majim = null;

    public void SetMajim(Player player){
        majim = player;
    }

    public Player GetMajim(){
        if(majim == null) return null;
        else return majim;
    }

    public boolean isSaigonoTime = false;
}
