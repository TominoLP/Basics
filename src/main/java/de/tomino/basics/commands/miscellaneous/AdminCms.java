package de.tomino.basics.commands.miscellaneous;

import de.tomino.basics.utils.server.ServerMaintrance;
import de.tomino.basics.utils.server.ServerReload;
import de.tomino.basics.utils.server.ServerStop;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class AdminCms implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender.hasPermission("basics.admin") || sender.hasPermission("basics.*")) {
            if (args.length == 0) {
                sender.sendMessage("§c/admin <reload|stop|maintence>");

            } else if (args[0].equalsIgnoreCase("reload")) {
                ServerReload.reload();

            } else if (args[0].equalsIgnoreCase("stop")) {
                ServerStop.stop();

            } else if (args[0].equalsIgnoreCase("maintence") || args[0].equalsIgnoreCase("Wartung")) {
                Player player = (Player) sender;
                ServerMaintrance.maintenance(player);
            }
        }
        return false;
    }
}
