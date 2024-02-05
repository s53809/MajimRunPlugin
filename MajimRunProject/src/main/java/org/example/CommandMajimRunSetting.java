package org.example;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandMajimRunSetting implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length < 1) commandSender.sendMessage("매개변수가 없습니다");
        else{
            commandSender.sendMessage(strings[0]);
            if(strings[0].equals("help")){
                commandSender.sendMessage("worldBorderSetting <x좌표> <y좌표> <크기> : 월드보더를 세팅합니다.\n" +
                        "runGame : 마짐런을 시작합니다.\n");
            }
            if(strings[0].equals("worldBorderSetting")){
                if(strings.length != 4) {
                    commandSender.sendMessage("잘못된 매개변수를 넣으셨습니다.");
                    return false;
                }
                try{
                    double centerX = Double.parseDouble(strings[1]);
                    double centerZ = Double.parseDouble(strings[2]);
                    int size = Integer.parseInt(strings[3]);
                    MajimRunner.Ins().SetWorldBorder(centerX, centerZ, size);
                }catch(NumberFormatException ex){
                    commandSender.sendMessage("잘못된 매개변수를 넣으셨습니다.");
                }catch(Exception ex){
                    commandSender.sendMessage(ex.getMessage());
                }
            }
            if(strings[0].equals("runGame")){
                MajimRunner.Ins().StartGame();
            }
        }
        return true;
    }
}
