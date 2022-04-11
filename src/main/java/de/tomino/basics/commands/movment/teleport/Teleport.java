package de.tomino.basics.commands.movment.teleport;

import de.tomino.basics.utils.Languages;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teleport implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 1) {

            if (!(sender instanceof Player)) {
                System.out.println(Languages.ConsoleExecute);
                return true;
            }

            // Permission check
            if (sender.hasPermission("basics.teleport")) {

                String pName = args[0];
                Player target = null;

                // Check if the player is online and not NULL
                try {
                    target = Bukkit.getPlayer(pName);
                } catch (Exception e) {
                    sender.sendMessage(Languages.PlayerNotFound.replace("%player%", args[0]));
                }
                if (target == null) {
                    sender.sendMessage(Languages.PlayerNotFound.replace("%player%", args[0]));
                    return true;
                }

                Player executor = Bukkit.getPlayer(sender.getName());

                // get location of players
                Location targetL = target.getLocation();
                Location senderL = executor.getLocation();

                // set Location from sender to target
                senderL.setX(targetL.getX());
                senderL.setY(targetL.getY());
                senderL.setZ(targetL.getZ());
                senderL.setPitch(targetL.getPitch());
                senderL.setYaw(targetL.getYaw());

                // teleport sender to target
                sender.sendMessage(Languages.TeleportSelf.replace("%target%", target.getName()));

            } else {
                sender.sendMessage(Languages.NoPermission);
            }


        } else if (args.length == 2) {

            // Permission check
            if (sender.hasPermission("basics.teleport.others")) {


                String pName = args[0];
                String pName2 = args[1];

                Player fromP = null;
                Player toP = null;

                // get player from args[0] & args[1]
                try {
                    fromP = Bukkit.getPlayer(pName);
                } catch (Exception e) {
                    sender.sendMessage(Languages.PlayerNotFound.replace("%player%", args[0]));
                }

                try {
                    toP = Bukkit.getPlayer(pName2);
                } catch (Exception e) {
                    sender.sendMessage(Languages.PlayerNotFound.replace("%player%", args[1]));
                }

                // check if both players are online and not null
                if (fromP == null) {
                    sender.sendMessage(Languages.PlayerNotFound.replace("%player%", args[0]));
                    return true;
                }

                if (toP == null) {
                    sender.sendMessage(Languages.PlayerNotFound.replace("%player%", args[1]));
                    return true;
                }

                Player executor = Bukkit.getPlayer(sender.getName());

                // get location of both players
                Location fromL = fromP.getLocation();
                Location toL = toP.getLocation();

                // set location of fromP to location of toP
                fromL.setX(toL.getX());
                fromL.setY(toL.getY());
                fromL.setZ(toL.getZ());
                fromL.setPitch(toL.getPitch());
                fromL.setYaw(toL.getYaw());

                // send message to executor and fromP
                if (toP == executor.getPlayer()) {
                    fromP.sendMessage(Languages.TeleportSelf.replace("%target%", toP.getName()));

                } else {
                    fromP.sendMessage(Languages.TeleportOther.replace("%target%", toP.getName()).replace("%executor%", executor.getName()));
                    executor.sendMessage(Languages.TeleportSelf.replace("%target%", toP.getName()));
                }

            } else {
                sender.sendMessage(Languages.NoPermission);
            }
        }
        return false;
    }
}
