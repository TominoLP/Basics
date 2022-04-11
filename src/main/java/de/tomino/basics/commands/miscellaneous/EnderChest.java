package de.tomino.basics.commands.miscellaneous;

import de.tomino.basics.utils.Languages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderChest implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Languages.ConsoleExecute);
            return true;
        }
        if (sender.hasPermission("basics.enderchest")) {

            Player executor = Bukkit.getPlayer(sender.getName());
            executor.openInventory(executor.getEnderChest());

        } else {
            sender.sendMessage(Languages.NoPermission);
        }

        return false;
    }
}
