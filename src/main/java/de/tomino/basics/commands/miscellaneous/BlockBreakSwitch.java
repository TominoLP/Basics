package de.tomino.basics.commands.miscellaneous;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BlockBreakSwitch implements CommandExecutor {
    public static boolean BBActive;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("basics.blockbreak.change")) {

            if (BBActive) {
                sender.sendMessage("§aBlockBreak aktiviert");
                BBActive = false;
            } else {
                sender.sendMessage("§cBlockBreak deaktiviert");
                BBActive = true;
            }
        } else {
            sender.sendMessage("§cDu hast keine Berechtigung");
        }

        return false;
    }
}
