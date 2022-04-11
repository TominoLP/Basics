package de.tomino.basics.commands.movment.teleport;

import de.tomino.basics.utils.Languages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpHereAll implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender.hasPermission("basics.tphereall") || sender.hasPermission("basics.*")) {

            for (Player players : Bukkit.getOnlinePlayers()) {

                Player executer = Bukkit.getPlayer(sender.getName());
                players.teleport(executer.getLocation());
                players.sendMessage(Languages.TeleportSelf.replace("%executor%", executer.getName()));
            }
            sender.sendMessage(Languages.TeleportAll);

        }
        return false;
    }
}
