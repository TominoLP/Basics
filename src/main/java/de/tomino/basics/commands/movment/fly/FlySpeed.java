package de.tomino.basics.commands.movment.fly;

import de.tomino.basics.utils.Languages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlySpeed implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player executor = Bukkit.getPlayer(sender.getName());

        if (sender instanceof Player) {
            sender.sendMessage(Languages.ConsoleExecute);
            return true;
        }

        if (executor.hasPermission("basics.fly.speed")) {

            if (args.length == 0) {
                executor.setFlySpeed(0.1F);
                executor.sendMessage(Languages.FlySpeedNormal);
            } else if (args.length == 1) {
                try {
                    float speedI = (float) Double.parseDouble(args[0]);
                    float speedo = speedI / 10;
                    if (speedI > 10) {
                        sender.sendMessage(Languages.FlySpeedMAX);
                        return true;
                    }
                    executor.setFlySpeed(speedo);
                    sender.sendMessage(Languages.FlySpeed.replace("%speed%", speedI + ""));

                } catch (IllegalArgumentException e) {
                    sender.sendMessage(Languages.FlySpeedInvalid);
                }
            }

            if (args.length == 2) {

                Player target = Bukkit.getPlayer(args[1]);

                try {
                    float speedI = (float) Double.parseDouble(args[0]);
                    float speedo = speedI / 10;
                    if (speedI > 10) {
                        sender.sendMessage(Languages.FlySpeedMAX);
                        return true;

                    }
                    target.setFlySpeed(speedo);

                } catch (IllegalArgumentException e) {
                    sender.sendMessage(Languages.FlySpeedInvalid);
                }
            }
        } else {
            sender.sendMessage(Languages.NoPermission);
        }
        return false;
    }
}
