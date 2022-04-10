package de.tomino.basics.commands.movment.fly;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlySpeed implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player executor = Bukkit.getPlayer(sender.getName());

        if (executor.hasPermission("basics.fly.speed")) {

            if (args.length == 0) {
                executor.setFlySpeed(0.1F);
                executor.sendMessage("§aFlySpeed set to 1");
            } else if (args.length == 1) {
                try {
                    float speedI = (float) Double.parseDouble(args[0]);
                    float speedo = speedI / 10;
                    if (speedI > 10) {
                        sender.sendMessage("§cSpeed can't be higher than 10!");
                        return true;
                    }
                    executor.setFlySpeed(speedo);
                    sender.sendMessage("§aFlySpeed set to §e" + speedI + "§a.");

                } catch (IllegalArgumentException e) {
                    sender.sendMessage("§cInvalid speed!\n §c/flyspeed <speed>");
                }
            }
            if (args.length == 2) {

                Player target = Bukkit.getPlayer(args[1]);

                try {
                    float speedI = (float) Double.parseDouble(args[0]);
                    float speedo = speedI / 10;
                    if (speedI > 10) {
                        sender.sendMessage("§cSpeed can't be higher than 10!");
                        return true;

                    }
                    target.setFlySpeed(speedo);

                } catch (IllegalArgumentException e) {
                    sender.sendMessage("§cInvalid speed!\n §c/flyspeed <speed>");
                }

            }
        } else {
            sender.sendMessage("§cYou don't have the permission to use this command!");
        }
        return false;
    }
}
