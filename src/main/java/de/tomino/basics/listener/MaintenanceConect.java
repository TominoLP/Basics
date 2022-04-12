package de.tomino.basics.listener;

import de.tomino.basics.utils.server.ServerMaintrance;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class MaintenanceConect implements Listener {

    @EventHandler
    public void onConnect(org.bukkit.event.player.PlayerLoginEvent event) {

        if (ServerMaintrance.Maintenance) {

            if (!(event.getPlayer().hasPermission("basics.maintenance") || event.getPlayer().hasPermission("basics.admin"))) {
                event.disallow(PlayerLoginEvent.Result.KICK_OTHER, "§Game is currently in maintenance mode.");
            } else {
                event.allow();
                event.getPlayer().sendMessage("§aServer is currently under maintenance.");
            }

        } else {
            event.allow();
        }
    }
}
