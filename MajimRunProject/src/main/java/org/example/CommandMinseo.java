package org.example;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CommandMinseo implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage("You Find Secret Command!");
        Bukkit.getPlayer(commandSender.getName()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * 60, 249));
        Bukkit.getPlayer(commandSender.getName()).addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20 * 60, 249));
        return true;
    }
}
