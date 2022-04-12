package de.tomino.basics.listener;

import de.tomino.basics.utils.Languages;
import de.tomino.basics.utils.server.ServerMaintrance;
import de.tomino.basics.utils.server.ServerReload;
import de.tomino.basics.utils.server.ServerStop;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class AdminGuiClick implements Listener {

    @EventHandler()
    public void onClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase(Languages.AdminGUITitle)) {
            event.setCancelled(true);

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(" ")) {
                return;

            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(Languages.AdminStopGUI)) {
                ServerStop.stop();

            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(Languages.AdminReloadGUI)) {
                ServerReload.reload();

            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(Languages.AdminMaintenanceGUI)) {
                ServerMaintrance.maintenance(player);
            }
        }
    }
}

