package de.tomino.basics.commands.teleport;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpHereAll implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender.hasPermission("basics.tphereall") || sender.hasPermission("basics.*")) {

            for (Player players: Bukkit.getOnlinePlayers()) {

                Player executer = Bukkit.getPlayer(sender.getName());
                players.teleport(executer.getLocation());
                players.sendMessage("§aDu wurdest zu §e" + executer.getName() + "Teleportiert.");
            }
            sender.sendMessage("§aDu hast alle Spieler zu dir teleportiert.");

        }
        return false;
    }
}
