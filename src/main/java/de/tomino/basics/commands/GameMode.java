package de.tomino.basics.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.Console;

public class GameMode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        // check if player is player
        if (!(sender instanceof Player)) {
            sender.sendMessage("You must be a player to execute this command!");
            return false;
        }

        // Permission check
        String pName = null;
        String Mode = null;
        if (sender.hasPermission("basics.gamemode") || sender.hasPermission("basics.*")) {

            if (args.length == 1) {

                // Set gamemode to survival
                if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("s")) {
                    player.setGameMode(org.bukkit.GameMode.SURVIVAL);
                    player.sendMessage("§aYou are now in survival mode!");

                    // Set gamemode to creative
                } else if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("c")) {
                    player.setGameMode(org.bukkit.GameMode.CREATIVE);
                    player.sendMessage("§aYou are now in creative mode!");

                    // Set gamemode to adventure
                } else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("a")) {
                    player.setGameMode(org.bukkit.GameMode.ADVENTURE);
                    player.sendMessage("§aYou are now in adventure mode!");

                    // Set gamemode to spectator
                } else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("sp")) {
                    player.setGameMode(org.bukkit.GameMode.SPECTATOR);
                    player.sendMessage("§aYou are now in spectator mode!");
                }
            }

            if (args.length == 0) {
                player.sendMessage("§aYou are now in " + player.getGameMode().toString().toLowerCase() + " mode!");

            } else if (player.hasPermission("basics.gamemode.others") || player.hasPermission("basics.*")) {

                pName = args[0];
                if (pName == null) {
                    return false;
                }
                Mode = args[1];
                if (Mode == null) {
                    return false;
                }
                Player target = Bukkit.getPlayer(pName);

                if (target == null) {
                    player.sendMessage("§cPlayer not found!");
                }
                if (Mode.equalsIgnoreCase("0") || Mode.equalsIgnoreCase("survival") || Mode.equalsIgnoreCase("s")) {
                    target.setGameMode(org.bukkit.GameMode.SURVIVAL);
                    target.sendMessage("§aYou are now in survival mode!");
                    sender.sendMessage("§aYou set " + target.getName() + " to survival mode!");

                } else if (Mode.equalsIgnoreCase("1") || Mode.equalsIgnoreCase("creative") || Mode.equalsIgnoreCase("c")) {
                    target.setGameMode(org.bukkit.GameMode.CREATIVE);
                    target.sendMessage("§aYou are now in creative mode!");
                    sender.sendMessage("§aYou set " + target.getName() + " to creative mode!");

                } else if (Mode.equalsIgnoreCase("2") || Mode.equalsIgnoreCase("adventure") || Mode.equalsIgnoreCase("a")) {
                    target.setGameMode(org.bukkit.GameMode.ADVENTURE);
                    target.sendMessage("§aYou are now in adventure mode!");
                    sender.sendMessage("§aYou set " + target.getName() + " to adventure mode!");

                } else if (Mode.equalsIgnoreCase("3") || Mode.equalsIgnoreCase("spectator") || Mode.equalsIgnoreCase("sp")) {
                    target.setGameMode(org.bukkit.GameMode.SPECTATOR);
                    target.sendMessage("§aYou are now in spectator mode!");
                    sender.sendMessage("§aYou set " + target.getName() + " to spectator mode!");

                }


            }

        } else {
            player.sendMessage("§cYou don't have the permission to execute this command!");
        }
        sender.sendMessage(pName + " is now in " + Mode + " mode!");
        return false;
    }
}
