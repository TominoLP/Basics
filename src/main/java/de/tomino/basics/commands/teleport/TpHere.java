package de.tomino.basics.commands.teleport;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpHere implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 1) {
            if (sender.hasPermission("basics.tphere") || sender.hasPermission("basics.*")) {
                Player executor = Bukkit.getPlayer(sender.getName());
                Player target = Bukkit.getPlayer(args[0]);

                if (target != null) {
                    target.teleport(executor);
                    sender.sendMessage("§aDu hast " + target.getName() + " zu dir teleportiert.");
                } else {
                    sender.sendMessage("§cPlayer " + args[0] + " not found!");
                }
            } else {
                sender.sendMessage("§cYou don't have the permission to use this command! \n§cYou need the permission basics.tphere or basics.*");
            }
        }
        return false;
    }
}
