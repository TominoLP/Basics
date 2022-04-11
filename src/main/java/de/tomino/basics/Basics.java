package de.tomino.basics;

import de.tomino.basics.commands.heal.Heal;
import de.tomino.basics.commands.heal.HealAll;
import de.tomino.basics.commands.miscellaneous.*;
import de.tomino.basics.commands.movment.fly.Fly;
import de.tomino.basics.commands.movment.fly.FlySpeed;
import de.tomino.basics.commands.movment.teleport.Teleport;
import de.tomino.basics.commands.movment.teleport.TpHere;
import de.tomino.basics.commands.movment.teleport.TpHereAll;
import de.tomino.basics.commands.time.*;
import de.tomino.basics.listener.AdminGuiClick;
import de.tomino.basics.listener.BlockBreak;
import de.tomino.basics.listener.MaintenanceConect;
import de.tomino.basics.utils.Config;
import de.tomino.basics.utils.DiscordWebHook;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Basics extends JavaPlugin {

    private static Basics instance;

    public static Basics getInstance() {
        return instance;
    }

    // Plugin startup logic
    @Override
    public void onEnable() {

        instance = this;
        Config.load();

        // Register commands
        getCommand("Gm").setExecutor(new GameMode());
        getCommand("Tp").setExecutor(new Teleport());
        getCommand("TpHere").setExecutor(new TpHere());
        getCommand("TpHereAll").setExecutor(new TpHereAll());
        getCommand("Heal").setExecutor(new Heal());
        getCommand("HealAll").setExecutor(new HealAll());
        getCommand("EC").setExecutor(new EnderChest());
        getCommand("Fly").setExecutor(new Fly());
        getCommand("FlySpeed").setExecutor(new FlySpeed());
        getCommand("BlockBreakSwitch").setExecutor(new BlockBreakSwitch());
        getCommand("AdminGui").setExecutor(new AdminGui());
        getCommand("AdminComs").setExecutor(new AdminComs());
        getCommand("Day").setExecutor(new Day());
        getCommand("Night").setExecutor(new Night());
        getCommand("Midnight").setExecutor(new Midnight());
        getCommand("Noon").setExecutor(new Noon());
        getCommand("Sunrise").setExecutor(new Sunrise());
        getCommand("Sunset").setExecutor(new Sunset());


        // Register events
        Bukkit.getPluginManager().registerEvents(new BlockBreak(), this);
        Bukkit.getPluginManager().registerEvents(new AdminGuiClick(), this);
        Bukkit.getPluginManager().registerEvents(new MaintenanceConect(), this);


        System.out.println(
                "\n █████╗  █████╗ ███████╗ █████╗ ███╗  ██╗ ██████╗██████╗ ██╗██████╗ ███████╗\n" +
                        "██╔══██╗██╔══██╗██╔════╝██╔══██╗████╗ ██║██╔════╝██╔══██╗██║██╔══██╗██╔════╝\n" +
                        "██║  ██║██║  ╚═╝█████╗  ███████║██╔██╗██║╚█████╗ ██████╔╝██║██████╔╝█████╗\n" +
                        "██║  ██║██║  ██╗██╔══╝  ██╔══██║██║╚████║ ╚═══██╗██╔═══╝ ██║██╔══██╗██╔══╝\n" +
                        "╚█████╔╝╚█████╔╝███████╗██║  ██║██║ ╚███║██████╔╝██║     ██║██║  ██║███████╗\n" +
                        " ╚════╝  ╚════╝ ╚══════╝╚═╝  ╚═╝╚═╝  ╚══╝╚═════╝ ╚═╝     ╚═╝╚═╝  ╚═╝╚══════╝"
        );
        DiscordWebHook.sendtoDC("Basics Plugin Started");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
