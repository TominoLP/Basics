package de.tomino.basics.utils.server;

import de.tomino.basics.utils.DiscordWebhook;
import de.tomino.basics.utils.Languages;
import de.tomino.basics.utils.color;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.IOException;

import static de.tomino.basics.utils.Config.WEBHOOK;


public class ServerMaintrance {

    public static boolean Maintenance = false;

    public static void maintenance(Player player) {
        Bukkit.broadcastMessage(Languages.MaintenanceKickMessage);

        if (Maintenance) {
            Maintenance = false;
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


        } else if (!Maintenance) {
            Maintenance = true;
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
