package org.example;

import org.bukkit.Bukkit;

public class MajimRunner
{
    private static MajimRunner instance;

    public static MajimRunner Ins(){
        if(instance == null) instance = new MajimRunner();
        return instance;
    }
    public double mWorldBorderCenterX;
    public double mWorldBorderCenterZ;
    public int mWorldBorderSize;
    public float mGameTime;
    public float mFeverTime;

    public MajimRunner(){
        mWorldBorderCenterX = 0;
        mWorldBorderCenterZ = 0;
        mGameTime = 0;
        mFeverTime = 0;
        mWorldBorderSize = 0;
    }

    public void SetWorldBorder(double centerX, double centerZ, int borderSize){
        mWorldBorderCenterX = centerX;
        mWorldBorderCenterZ = centerZ;
        mWorldBorderSize = borderSize;
    }

    public void StartGame(){
        Bukkit.broadcastMessage("Start Game 실행 완료");

        StartGameEvent event = new StartGameEvent();

        Bukkit.getPluginManager().callEvent(event);
        if(!event.isCancelled()){
            event.setCancelled(true);
        }
    }
}
