package de.tomino.basics.commands.miscellaneous;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderChest implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cYou must be a player to use this command!");
            return true;
        }
        if (sender.hasPermission("basics.enderchest")) {

            Player executor = Bukkit.getPlayer(sender.getName());
            executor.openInventory(executor.getEnderChest());

        } else {
            sender.sendMessage("§cYou don't have the permission to use this command!");
        }

        return false;
    }
}
