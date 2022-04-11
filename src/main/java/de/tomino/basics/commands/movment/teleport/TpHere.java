package de.tomino.basics.commands.movment.teleport;

import de.tomino.basics.utils.Languages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpHere implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            sender.sendMessage(Languages.ConsoleExecute);
            return true;
        }

        if (args.length == 1) {
            if (sender.hasPermission("basics.tphere") || sender.hasPermission("basics.*")) {
                Player executor = Bukkit.getPlayer(sender.getName());
                Player target = Bukkit.getPlayer(args[0]);

                if (target != null) {
                    target.teleport(executor);
                    sender.sendMessage(Languages.TeleportOtherToSelf.replace("%target%", target.getName()));
                } else {
                    sender.sendMessage(Languages.PlayerNotFound);
                }
            } else {
                sender.sendMessage(Languages.NoPermission);
            }
        }
        return false;
    }
}
