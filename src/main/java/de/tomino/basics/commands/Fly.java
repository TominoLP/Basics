package de.tomino.basics.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("§cYou must be a player to use this command!");
            return true;
        }

        if (args.length == 0) {
            if (sender.hasPermission("basics.fly")) {

                Player executor = Bukkit.getPlayer(sender.getName());
                executor.setAllowFlight(!executor.getAllowFlight());
                executor.sendMessage("§aDu hast den Fly-Modus §7" + (executor.getAllowFlight() ? "§aaktiviert" : "§cdeaktiviert") + "§a.");
            } else {
                sender.sendMessage("§cDu hast keine Berechtigung, diesen Befehl zu benutzen.");
            }

        } else if (args.length == 1) {
            if (sender.hasPermission("basics.fly.others")) {

                Player target = Bukkit.getPlayer(args[0]);

                if (target == null || !target.isOnline()) {
                    sender.sendMessage("§cPlayer " + args[0] + " not found!");
                    return true;

                } else {
                    target.setAllowFlight(!target.getAllowFlight());
                    target.sendMessage("§aDu hast den Fly-Modus §7" + (target.getAllowFlight() ? "§aaktiviert" : "§cdeaktiviert") + "§a.");
                }
            } else {
                sender.sendMessage("§cYou don't have the permission to do this!\n§7You need the permission: §6basics.fly.others");
            }
        }
        return false;
    }
}
