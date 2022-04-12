package de.tomino.basics.utils.server;

import de.tomino.basics.utils.Languages;
import org.bukkit.Bukkit;

public class ServerStop {

    public static void stop() {

        Bukkit.broadcastMessage(Languages.AdminStop);
        Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("Basics"), new Runnable() {
            @Override
            public void run() {
                Bukkit.getServer().shutdown();
            }
        }, 20 * 60 * 3);
    }
}
