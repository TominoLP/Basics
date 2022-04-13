package de.tomino.basics.utils.server;

import de.tomino.basics.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.Server;

public class ServerReload {

    public static void reload() {

        Config.CFG.set("restart", true);
        Config.save();

        Bukkit.broadcastMessage("§c[§6Reload§c] §7Reloading...");
        Server server = Bukkit.getServer();
        server.reload();
        Bukkit.broadcastMessage("§c[§6Reload§c] §7Reload complete!");

    }
}
