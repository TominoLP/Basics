package de.tomino.basics.commands.miscellaneous;

import de.tomino.basics.utils.DiscordWebHook;
import de.tomino.basics.utils.Languages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static de.tomino.basics.utils.DiscordWebHook.sendtoDC;


public class GameMode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        String pName = null;
        String Mode = null;

        // Permission check
        if (sender.hasPermission("basics.gamemode") || sender.hasPermission("basics.*")) {


            if (args.length == 1) {

                // check if player is player
                if (!(sender instanceof Player)) {
                    sender.sendMessage("You must be a player to execute this command!");
                    return true;
                } else {

                    // Set gamemode to survival
                    if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("s")) {
                        player.setGameMode(org.bukkit.GameMode.SURVIVAL);
                        player.sendMessage(Languages.GameModeSurvival);

                        // Set gamemode to creative
                    } else if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("c")) {
                        player.setGameMode(org.bukkit.GameMode.CREATIVE);
                        player.sendMessage(Languages.GameModeCreative);

                        // Set gamemode to adventure
                    } else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("a")) {
                        player.setGameMode(org.bukkit.GameMode.ADVENTURE);
                        player.sendMessage(Languages.GameModeAdventure);

                        // Set gamemode to spectator
                    } else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("sp")) {
                        player.setGameMode(org.bukkit.GameMode.SPECTATOR);
                        player.sendMessage(Languages.GameModeSpectator);
                    } else {
                        player.sendMessage(Languages.InvalidGameMode);
                    }
                }
            }

            if (args.length == 2) {

                // check if player has permission
                if (player.hasPermission("basics.gamemode.others") || player.hasPermission("basics.*")) {

                    pName = args[0];
                    Mode = args[1];

                    Player target = Bukkit.getPlayer(pName);

                    if (target != null && target.isOnline()) {

                        //set target gamemode to survival
                        if (Mode.equalsIgnoreCase("0") || Mode.equalsIgnoreCase("survival") || Mode.equalsIgnoreCase("s")) {
                            target.setGameMode(org.bukkit.GameMode.SURVIVAL);

                            if (target.getName().equals(sender.getName())) {
                                player.sendMessage(Languages.GameModeSurvival);
                            } else {
                                target.sendMessage(Languages.GameModeSurvival);
                                sender.sendMessage(Languages.GameModeSurvival_Others.replace("%player%", target.getName()));
                            }

                            //set target gamemode to creative
                        } else if (Mode.equalsIgnoreCase("1") || Mode.equalsIgnoreCase("creative") || Mode.equalsIgnoreCase("c")) {
                            target.setGameMode(org.bukkit.GameMode.CREATIVE);

                            if (target.getName().equals(sender.getName())) {
                                player.sendMessage(Languages.GameModeCreative);
                            } else {
                                target.sendMessage(Languages.GameModeCreative);
                                sender.sendMessage(Languages.GameModeCreative_Others.replace("%player%", target.getName()));
                            }

                            //set target gamemode to adventure
                        } else if (Mode.equalsIgnoreCase("2") || Mode.equalsIgnoreCase("adventure") || Mode.equalsIgnoreCase("a")) {
                            target.setGameMode(org.bukkit.GameMode.ADVENTURE);

                            if (target.getName().equals(sender.getName())) {
                                player.sendMessage(Languages.GameModeAdventure);
                            } else {
                                target.sendMessage(Languages.GameModeAdventure);
                                sender.sendMessage(Languages.GameModeAdventure_Others.replace("%player%", target.getName()));
                            }

                            //set target gamemode to spectator
                        } else if (Mode.equalsIgnoreCase("3") || Mode.equalsIgnoreCase("spectator") || Mode.equalsIgnoreCase("sp")) {
                            target.setGameMode(org.bukkit.GameMode.SPECTATOR);

                            if (target.getName().equals(sender.getName())) {
                                player.sendMessage(Languages.GameModeSpectator);
                            } else {
                                target.sendMessage(Languages.GameModeSpectator);
                                sender.sendMessage(Languages.GameModeSpectator_Others.replace("%player%", target.getName()));
                            }
                        } else {
                            sender.sendMessage(Languages.InvalidGameMode);
                        }


                    } else {
                        sender.sendMessage(Languages.PlayerNotFound.replace("%player%", pName));
                    }


                } else {
                    player.sendMessage(Languages.NoPermission);
                }
            }

        } else {
            player.sendMessage(Languages.NoPermission);
        }
        return false;
    }
}
