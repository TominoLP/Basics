package de.tomino.basics.listener;

import de.tomino.basics.utils.DiscordWebhook;
import de.tomino.basics.utils.Languages;
import de.tomino.basics.utils.color;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.io.IOException;

import static de.tomino.basics.utils.Config.WEBHOOK;

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
                    DiscordWebhook webhook = new DiscordWebhook(WEBHOOK);
                    webhook.addEmbed(new DiscordWebhook.EmbedObject()
                            .setTitle("Maintenance was turned off")
                            .setDescription("by " + player.getName())
                            .setFooter("%time%", "")
                            .setColor(color.BLUE)
                    );
                    try {
                        webhook.execute();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                } else if (!maintenance) {
                    maintenance = true;
                    player.sendMessage(Languages.AdminMaintenanceON);
                    DiscordWebhook webhook = new DiscordWebhook(WEBHOOK);
                    webhook.addEmbed(new DiscordWebhook.EmbedObject()
                            .setTitle("Maintenance was turned on")
                            .setDescription("by " + player.getName())
                            .setFooter("%time%", "")
                            .setColor(color.BLUE)
                    );
                    try {
                        webhook.execute();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

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

