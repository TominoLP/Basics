package de.tomino.basics;

import de.tomino.basics.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class Basics extends JavaPlugin {

    // Plugin startup logic
    @Override
    public void onEnable() {

        // Register commands
        getCommand("Gm").setExecutor(new GameMode());
        getCommand("Tp").setExecutor(new Teleport());
        getCommand("TpHere").setExecutor(new TpHere());
        getCommand("TpHereAll").setExecutor(new TpHereAll());
        getCommand("Heal").setExecutor(new HealCommand());


        // Register events


        System.out.println(
                "\n █████╗  █████╗ ███████╗ █████╗ ███╗  ██╗ ██████╗██████╗ ██╗██████╗ ███████╗\n" +
                        "██╔══██╗██╔══██╗██╔════╝██╔══██╗████╗ ██║██╔════╝██╔══██╗██║██╔══██╗██╔════╝\n" +
                        "██║  ██║██║  ╚═╝█████╗  ███████║██╔██╗██║╚█████╗ ██████╔╝██║██████╔╝█████╗\n" +
                        "██║  ██║██║  ██╗██╔══╝  ██╔══██║██║╚████║ ╚═══██╗██╔═══╝ ██║██╔══██╗██╔══╝\n" +
                        "╚█████╔╝╚█████╔╝███████╗██║  ██║██║ ╚███║██████╔╝██║     ██║██║  ██║███████╗\n" +
                        " ╚════╝  ╚════╝ ╚══════╝╚═╝  ╚═╝╚═╝  ╚══╝╚═════╝ ╚═╝     ╚═╝╚═╝  ╚═╝╚══════╝"
        );
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
