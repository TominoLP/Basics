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
import de.tomino.basics.listener.ChatLogger;
import de.tomino.basics.listener.MaintenanceConect;
import de.tomino.basics.utils.Config;
import de.tomino.basics.utils.DiscordWebHook;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Basics extends JavaPlugin {

    private static Basics instance;

    public static Basics getInstance() {
        return instance;
    }

    // Plugin startup logic
    @Override
    public void onEnable() {

        instance = getInstance();
        Config.load();

        // Register commands
        Objects.requireNonNull(getCommand("Gm")).setExecutor(new GameMode());
        Objects.requireNonNull(getCommand("Tp")).setExecutor(new Teleport());
        Objects.requireNonNull(getCommand("TpHere")).setExecutor(new TpHere());
        Objects.requireNonNull(getCommand("TpHereAll")).setExecutor(new TpHereAll());
        Objects.requireNonNull(getCommand("Heal")).setExecutor(new Heal());
        Objects.requireNonNull(getCommand("HealAll")).setExecutor(new HealAll());
        Objects.requireNonNull(getCommand("EC")).setExecutor(new EnderChest());
        Objects.requireNonNull(getCommand("Fly")).setExecutor(new Fly());
        Objects.requireNonNull(getCommand("FlySpeed")).setExecutor(new FlySpeed());
        Objects.requireNonNull(getCommand("BlockBreakSwitch")).setExecutor(new BlockBreakSwitch());
        Objects.requireNonNull(getCommand("AdminGui")).setExecutor(new AdminGui());
        Objects.requireNonNull(getCommand("AdminCms")).setExecutor(new AdminCms());
        Objects.requireNonNull(getCommand("Day")).setExecutor(new Day());
        Objects.requireNonNull(getCommand("Night")).setExecutor(new Night());
        Objects.requireNonNull(getCommand("Midnight")).setExecutor(new Midnight());
        Objects.requireNonNull(getCommand("Noon")).setExecutor(new Noon());
        Objects.requireNonNull(getCommand("Sunrise")).setExecutor(new Sunrise());
        Objects.requireNonNull(getCommand("Sunset")).setExecutor(new Sunset());


        // Register events
        Bukkit.getPluginManager().registerEvents(new BlockBreak(), this);
        Bukkit.getPluginManager().registerEvents(new AdminGuiClick(), this);
        Bukkit.getPluginManager().registerEvents(new MaintenanceConect(), this);
        Bukkit.getPluginManager().registerEvents(new ChatLogger(), this);


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

