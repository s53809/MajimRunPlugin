package org.example;

import org.apache.commons.lang.ObjectUtils;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.KeyedBossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.Bukkit;
import org.bukkit.command.TabExecutor;
import org.bukkit.event.EventHandler;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandTimer implements TabExecutor, Listener {
    private final MajimRun plugin = MajimRun.getPlugin(MajimRun.class);

    private final String key = "CommandTimer";
    private final NamespacedKey namespacedKey = new NamespacedKey(plugin, key);
    private int tempTimer;

    private BukkitTask task;

    private final KeyedBossBar bar = Bukkit.createBossBar(namespacedKey, ChatColor.RED + key, BarColor.RED, BarStyle.SOLID);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length < 1) sender.sendMessage("매개변수가 없습니다");
        else if(args.length == 3) {
            if (args[0].equals("time")) {
                if (args[1].equals("set")) {
                    int time = 0;

                    try {
                        time = Integer.parseInt(args[2]);
                        sender.sendMessage("commandSuccessed");
                    } catch (NumberFormatException e) {
                        sender.sendMessage("commandFailed");
                        return false;
                    }
                    plugin.timer = time;
                    return true;
                }
            } else if (args[0].equals("lastTime")) {
                if (args[1].equals("set")) {
                    int time = 0;

                    try {
                        time = Integer.parseInt(args[2]);
                    } catch (NumberFormatException e) {
                        return false;
                    }
                    plugin.lastTime = time;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> list = new ArrayList<>();
        if(sender instanceof Player)
        {
            if (args.length == 1) {
                list.add("time");
                list.add("lastTime");
                Collections.sort(list);
                return list;
            } else if (args.length == 2) {
                List<String> arguments = new ArrayList<>();
                arguments.add("set");
                Collections.sort(arguments);
                return arguments;
            }

        }
        return null;
    }

    @EventHandler
    public void OnStartGameEvent(StartGameEvent event)
    {
        for (Player player : plugin.getServer().getOnlinePlayers()) {
            // TODO: Check facing direction
            bar.addPlayer(player);
        }
        if(task != null)
        {
            task.cancel();
        }
        //Bukkit.broadcastMessage("Started");
        //Bukkit.broadcastMessage(Integer.toString(timer));
        tempTimer = plugin.timer + 1;
        task = new BukkitRunnable() {
            @Override
            public void run() {
                tempTimer -= 1;
                bar.setTitle(Integer.toString(tempTimer/60) + " : " + Integer.toString(tempTimer%60));
                bar.setProgress((float)tempTimer/plugin.timer);
                if(bar.getProgress() > (float)plugin.lastTime/(float)plugin.timer)
                {
                    bar.setColor(BarColor.GREEN);
                } else if(plugin.lastTime == tempTimer){
                    bar.setColor(BarColor.RED);
                    Bukkit.broadcastMessage("lastTime");
                }
                else {
                    bar.setColor(BarColor.RED);
                }
                if(tempTimer == 0)
                {
                    this.cancel();
                    bar.removeAll();
                    Bukkit.broadcastMessage("GameEnd");
                    return;
                }
            }
        }.runTaskTimer(plugin, 0L, 20L);
    }
}
