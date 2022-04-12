package de.tomino.basics.commands.miscellaneous;

import de.tomino.basics.listener.AdminGuiClick;
import de.tomino.basics.utils.DiscordWebhook;
import de.tomino.basics.utils.Languages;
import de.tomino.basics.utils.color;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

import static de.tomino.basics.utils.Config.WEBHOOK;


public class AdminCms implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender.hasPermission("basics.admin") || sender.hasPermission("basics.*")) {
            if (args.length == 0) {
                sender.sendMessage("§c/admin <reload|stop|maintence>");

            } else if (args[0].equalsIgnoreCase("reload")) {
                sender.sendMessage("§aReloading...");
                sender.getServer().reload();

            } else if (args[0].equalsIgnoreCase("stop")) {
                Bukkit.broadcastMessage(Languages.AdminStop);
                Bukkit.getScheduler().runTaskLater((Bukkit.getPluginManager().getPlugin("Basics")), new Runnable() {

                    @Override
                    public void run() {
                        Bukkit.getServer().shutdown();
                    }
                }, 20 * 60 * 3);

            } else if (args[0].equalsIgnoreCase("maintence") || args[0].equalsIgnoreCase("Wartung")) {
                if (AdminGuiClick.maintenance) {

                    AdminGuiClick.maintenance = false;
                    sender.sendMessage(Languages.AdminMaintenanceOFF);

                    DiscordWebhook webhook = new DiscordWebhook(WEBHOOK);
                    webhook.addEmbed(new DiscordWebhook.EmbedObject()
                            .setTitle("Maintenance was turned off")
                            .setDescription("by " + sender.getName())
                            .setFooter("%time%", "")
                            .setColor(color.BLUE)
                    );
                    try {
                        webhook.execute();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    AdminGuiClick.maintenance = true;
                    sender.sendMessage(Languages.AdminMaintenanceON);

                    DiscordWebhook webhook = new DiscordWebhook(WEBHOOK);
                    webhook.addEmbed(new DiscordWebhook.EmbedObject()
                            .setTitle("Maintenance was turned on")
                            .setDescription("by " + sender.getName())
                            .setFooter("%time%", "")
                            .setColor(color.BLUE)
                    );
                    try {
                        webhook.execute();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        if (!(p.hasPermission("basics.admin") || p.hasPermission("basics.*"))) {
                            p.kickPlayer(Languages.MaintenanceKickMessage);

                        }
                    }
                }
            }
        }
        return false;
    }
}
