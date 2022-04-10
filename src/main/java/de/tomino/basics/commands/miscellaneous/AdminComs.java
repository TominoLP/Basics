package de.tomino.basics.commands.miscellaneous;

import de.tomino.basics.listener.AdminGuiClick;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class AdminComs implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender.hasPermission("basics.admin") || sender.hasPermission("basics.*")) {
            if (args.length == 0) {
                sender.sendMessage("§c/admin <reload|stop|maintence>");
            } else if (args[0].equalsIgnoreCase("reload")) {
                sender.sendMessage("§aReloading...");
                sender.getServer().reload();
            } else if (args[0].equalsIgnoreCase("stop")) {
                Bukkit.broadcastMessage("§cServer wird in 3m gestoppt!");
                Bukkit.getScheduler().runTaskLater((Bukkit.getPluginManager().getPlugin("Basics")), new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.getServer().shutdown();
                    }
                }, 20 * 60 * 3);

            } else if (args[0].equalsIgnoreCase("maintence")) {
                if (AdminGuiClick.maintenance) {

                    AdminGuiClick.maintenance = false;
                    sender.sendMessage("§aMaintenance wurde deaktiviert!");

                } else {
                    AdminGuiClick.maintenance = true;
                    sender.sendMessage("§aMaintenance wurde aktiviert!");
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        if (!(p.hasPermission("basics.admin") || p.hasPermission("basics.*"))) {
                            p.kickPlayer("§cServer wird wegen Wartungsarbeiten heruntergefahren!");

                        }


                    }
                }
            }
        }

        return false;
    }
}
