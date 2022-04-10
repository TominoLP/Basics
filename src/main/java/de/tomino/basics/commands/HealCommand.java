package de.tomino.basics.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender.hasPermission("basics.heal") || sender.hasPermission("basics.*")) {
            if (args.length == 0) {

                Player executor = Bukkit.getPlayer(sender.getName());
                executor.setHealth(20);
                executor.setFoodLevel(20);


            } else if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);

                if (target != null && target.isOnline()) {
                    target.setHealth(20);
                    target.setFoodLevel(20);

                } else {

                    sender.sendMessage("§cPlayer " + args[0] + " not found!");
                    return true;
                }

            }

        } else {
            sender.sendMessage("§cYou don't have the permission to use this command!");
        }

        return false;
    }
}
