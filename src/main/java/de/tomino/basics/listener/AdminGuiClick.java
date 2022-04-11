package de.tomino.basics.listener;

import de.tomino.basics.utils.Languages;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class AdminGuiClick implements Listener {

    public static boolean maintenance = false;

    @EventHandler()
    public void onClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase(Languages.AdminGUITitle)) {
            event.setCancelled(true);
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(" ")) {
                return;

            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(Languages.AdminStopGUI)) {
                Bukkit.broadcastMessage(Languages.AdminStop);
                Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("Basics"), new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.getServer().shutdown();
                    }
                }, 20 * 60 * 3);

            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(Languages.AdminReloadGUI)) {
                Bukkit.broadcastMessage("§c§lReloading...");
                Bukkit.reload();

            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(Languages.AdminMaintenanceGUI)) {
                Bukkit.broadcastMessage(Languages.MaintenanceKickMessage);

                if (maintenance) {
                    maintenance = false;
                    player.sendMessage(Languages.AdminMaintenanceOFF);

                } else {
                    maintenance = true;
                    player.sendMessage(Languages.AdminMaintenanceON);
                }
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (!(p.hasPermission("basics.admin") || p.hasPermission("basics.*"))) {
                        p.kickPlayer(Languages.MaintenanceKickMessage);

                    }
                }
            }
        }
    }
}

