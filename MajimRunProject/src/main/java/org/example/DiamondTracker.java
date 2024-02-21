package org.example;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Player;


public class DiamondTracker {
    Player myPlayer;
    Player targetPlayer;

    World myWorld;


    private Vector3 GetPlayerDirection(Vector3 pMyPosition, Vector3 pTargetPosition){
        Vector3 dir = pTargetPosition.Minus(pMyPosition);
        return dir.Normalized();
    }

    private void PrintDiamondParticle(Vector3 dir){
        //#todo : 파티클 구현하기
        for(float i = 0;i<=3.0f;i+=0.3f){
            myWorld.spawnParticle(Particle.SOUL_FIRE_FLAME,
                    myPlayer.getLocation().getX() + (dir.x * i),
                    myPlayer.getLocation().getY() + 2 + (dir.y * i),
                    myPlayer.getLocation().getZ() + (dir.z * i),
                    1,
                    0,
                    0,
                    0,
                    0
                    );
        }
    }

    public DiamondTracker(){
        myPlayer = null;
        targetPlayer = null;
    }

    public void SetPlayer(Player pMyPlayer, Player pTargetPlayer){
        myPlayer = pMyPlayer;
        targetPlayer = pTargetPlayer;
        myWorld = myPlayer.getWorld();
    }

    public void DiamondTracking(){
        if(myPlayer == null || targetPlayer == null) return;
        Location myPos = myPlayer.getLocation();
        Location targetPos = targetPlayer.getLocation();

        Vector3 myVec = new Vector3(myPos.getX(), myPos.getY(), myPos.getZ());
        Vector3 targetVec = new Vector3(targetPos.getX(), targetPos.getY(), targetPos.getZ());

        Vector3 dir = GetPlayerDirection(myVec, targetVec);

        PrintDiamondParticle(dir);
        //#todo : 고쳐지면 매개변수값을 dir로 바꾸기

        //gkgkgkgkgkkgkg
    }

    /*
    * 마짐좌표 - 나의좌표 = 내 방향에서 마짐을 향한 벡터값.Normalized
    * */
}
