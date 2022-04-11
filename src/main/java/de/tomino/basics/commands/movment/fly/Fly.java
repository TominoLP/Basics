package de.tomino.basics.commands.movment.fly;

import de.tomino.basics.utils.Languages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(Languages.ConsoleExecute);
            return true;
        }

        if (args.length == 0) {
            if (sender.hasPermission("basics.fly")) {

                Player executor = Bukkit.getPlayer(sender.getName());
                executor.setAllowFlight(!executor.getAllowFlight());
                if (executor.getAllowFlight()) {
                    executor.sendMessage(Languages.FlyEnabled);
                } else {
                    executor.sendMessage(Languages.FlyDisabled);
                }


            } else {
                sender.sendMessage(Languages.NoPermission);
            }

        } else if (args.length == 1) {
            if (sender.hasPermission("basics.fly.others")) {

                Player target = Bukkit.getPlayer(args[0]);

                if (target == null || !target.isOnline()) {
                    sender.sendMessage(Languages.PlayerNotFound.replace("%player%", args[0]));
                    return true;

                } else {
                    target.setAllowFlight(!target.getAllowFlight());
                    if (target.getAllowFlight()) {
                        target.sendMessage(Languages.FlyEnabled);
                    } else {
                        target.sendMessage(Languages.FlyDisabled);
                    }

                }
            } else {
                sender.sendMessage(Languages.NoPermission);
            }
        }
        return false;
    }
}
