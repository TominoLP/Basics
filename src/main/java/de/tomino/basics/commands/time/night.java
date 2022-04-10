package de.tomino.basics.commands.time;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class night implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player executor = (Player) sender;

        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage("accelerating threw the day");

        }
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("Basics"), new Runnable() {

            @Override
            public void run() {
                if (executor.getWorld().getTime() > 14000 && executor.getWorld().getTime() < 14400) {

                    Bukkit.getScheduler().cancelTasks(Bukkit.getPluginManager().getPlugin("Basics"));
                } else {
                    executor.getWorld().setTime((int) executor.getWorld().getTime() + 150);
                }
            }
        }, 0L, 1L);
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage("The night has fallen...");

        }


        return false;
    }
}
