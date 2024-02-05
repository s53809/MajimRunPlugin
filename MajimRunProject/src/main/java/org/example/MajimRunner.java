package org.example;

import org.bukkit.Bukkit;

public class MajimRunner
{
    private static MajimRunner instance;

    public static MajimRunner Ins(){
        if(instance == null) instance = new MajimRunner();
        return instance;
    }
    private double mWorldBorderCenterX;
    private double mWorldBorderCenterZ;
    private int mWorldBorderSize;
    private float mGameTime;
    private float mFeverTime;

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
        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(),
                "worldborder center " + mWorldBorderCenterX + " " + mWorldBorderCenterZ);
        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(),
                "worldborder set " + mWorldBorderSize + " 2");
    }
}
