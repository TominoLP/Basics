package de.tomino.basics.listener;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public class AdminGuiClick implements Listener {

    public static boolean maintenance = false;

    @EventHandler()
    public void onClick(InventoryClickEvent event) {

        if (event.getView().getTitle().equalsIgnoreCase("Admin Gui")) {
            event.setCancelled(true);
            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(" ")) {
                return;

            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§cStop Server")) {
                Bukkit.broadcastMessage("§cServer wird in 3m gestoppt!");
                Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("Basics"), new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.getServer().shutdown();
                    }
                }, 20 * 60 * 3);

            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§cReload Server")) {
                Bukkit.broadcastMessage("§Reloding...");
                Bukkit.reload();

            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§cMaintenance")) {
                Bukkit.broadcastMessage("§cServer wird in in Wartung geschaltet!");

                if (maintenance) {
                    maintenance = false;
                } else {
                    maintenance = true;
                }
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (!(p.hasPermission("basics.admin") || p.hasPermission("basics.*"))) {
                        p.kickPlayer("§cServer wird wegen Wartungsarbeiten heruntergefahren!");

                    }
                }
            }
        }
    }
}

