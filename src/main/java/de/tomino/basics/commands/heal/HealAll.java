package de.tomino.basics.commands.heal;

import de.tomino.basics.utils.Languages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealAll implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender.hasPermission("basics.heal.all") || sender.hasPermission("basics.*")) {
            for (Player players : Bukkit.getOnlinePlayers()) {

                players.setHealth(20);
                players.setFoodLevel(20);
                players.sendMessage(Languages.HealAll);
            }
        } else {
            sender.sendMessage(Languages.NoPermission);
        }

        return false;
    }
}
