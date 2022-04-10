package de.tomino.basics.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class MaintenanceConect implements Listener {

    @EventHandler
    public void onConnect(org.bukkit.event.player.PlayerLoginEvent event) {

        if (AdminGuiClick.maintenance) {

            if (!(event.getPlayer().hasPermission("basics.maintenance") || event.getPlayer().hasPermission("basics.admin"))) {
                event.disallow( PlayerLoginEvent.Result.KICK_OTHER, "§cDas Spiel ist im Wartungsmodus. Bitte versuche es später erneut.");
            } else {
                event.allow();
                event.getPlayer().sendMessage("§aDer Server ist zur Zeit in Wartung.");
            }

        } else {
            event.allow();
        }
    }
}
