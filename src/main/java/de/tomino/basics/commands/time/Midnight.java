package de.tomino.basics.commands.time;

import de.tomino.basics.utils.Languages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Midnight implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player executor = (Player) sender;

        for (Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage(Languages.TimeSkip);

        }
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Bukkit.getPluginManager().getPlugin("Basics"), new Runnable() {

            @Override
            public void run() {
                if (executor.getWorld().getTime() > 17900 && executor.getWorld().getTime() < 18100) {

                    Bukkit.getScheduler().cancelTasks(Bukkit.getPluginManager().getPlugin("Basics"));
                } else {
                    executor.getWorld().setTime((int) executor.getWorld().getTime() + 150);
                }
            }
        }, 0L, 1L);

        return false;
    }
}
