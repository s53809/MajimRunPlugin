package org.example;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.FileConfiguration;

public class CommandSetMajim implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length != 1) commandSender.sendMessage("명령어 잘못 입력했습니다.");
        else{
            Player player = Bukkit.getPlayer(strings[0]);
            if(player == null) commandSender.sendMessage("올바른 플레이어 이름이 아닙니다.");
            else{
                MajimHandler.Ins().SetMajim(player);
                commandSender.sendMessage("이제부터 마짐은 " + MajimHandler.Ins().GetMajim().getName() + "입니다.");
            }
        }
        return true;
    }
}
