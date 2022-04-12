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
import de.tomino.basics.utils.DiscordWebhook;
import de.tomino.basics.utils.UpdaterAPI;
import de.tomino.basics.utils.color;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.function.Consumer;

import static de.tomino.basics.utils.Config.WEBHOOK;

public final class Basics extends JavaPlugin {

    private static final String currentVersion = "1.2.0";
    private static Basics instance;

    public static Basics getInstance() {
        return instance;
    }

    // Plugin startup logic
    @Override
    public void onEnable() {

        instance = getInstance();


        Config.load();

        UpdaterAPI.setAutoDelete(true);
        UpdaterAPI.downloadUpdater(new File("plugins/Basics/Updater.jar"));

        UpdaterAPI.getLatestReleaseFromGithub("TominoLP", "Basics", new Consumer<String[]>() {
            @Override
            public void accept(String[] strings) {
                if (UpdaterAPI.compareVersions(currentVersion, strings[0].replace("v", "")) == -1) {
                    DiscordWebhook webhook = new DiscordWebhook(WEBHOOK);
                    webhook.addEmbed(new DiscordWebhook.EmbedObject()
                            .setTitle("Basics Update")
                            .setDescription("A new version of Basics is available!")
                            .setColor(new Color(0, 255, 0))
                            .addField("Current Version", currentVersion, true)
                            .addField("New Version", strings[0].replace("v", " "), true)
                            .addField("It will be downloaded in the next restart!", "", true)
                            .setFooter("%time%", "")

                    );
                    try {
                        webhook.execute();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            UpdaterAPI.getLatestReleaseFromGithub("TominoLP", "Basics", new Consumer<String[]>() {

                @Override
                public void accept(String[] strings) {
                    File newFile = new File("plugins/Basics-" + strings[0] + ".jar");
                    if (strings[0].contains("pre")) return;

                    if (UpdaterAPI.compareVersions(currentVersion, strings[0].replace("v", "")) == -1) {
                        System.out.println("[Basics] Outdated version found!");
                        try {
                            UpdaterAPI.update(strings[1], newFile);
                            DiscordWebhook webhook = new DiscordWebhook(WEBHOOK);
                            webhook.addEmbed(new DiscordWebhook.EmbedObject()
                                    .setColor(new Color(250, 130, 0))
                                    .setTitle("Basics Plugin Updated")
                                    .setDescription("Successfully updated to " + strings[0])
                                    .setFooter("%time%", " ")
                            );
                            try {
                                webhook.execute();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }));


        System.out.println(
                "\n █████╗  █████╗ ███████╗ █████╗ ███╗  ██╗ ██████╗██████╗ ██╗██████╗ ███████╗\n" +
                        "██╔══██╗██╔══██╗██╔════╝██╔══██╗████╗ ██║██╔════╝██╔══██╗██║██╔══██╗██╔════╝\n" +
                        "██║  ██║██║  ╚═╝█████╗  ███████║██╔██╗██║╚█████╗ ██████╔╝██║██████╔╝█████╗\n" +
                        "██║  ██║██║  ██╗██╔══╝  ██╔══██║██║╚████║ ╚═══██╗██╔═══╝ ██║██╔══██╗██╔══╝\n" +
                        "╚█████╔╝╚█████╔╝███████╗██║  ██║██║ ╚███║██████╔╝██║     ██║██║  ██║███████╗\n" +
                        " ╚════╝  ╚════╝ ╚══════╝╚═╝  ╚═╝╚═╝  ╚══╝╚═════╝ ╚═╝     ╚═╝╚═╝  ╚═╝╚══════╝"
        );

        System.out.println(Config.RELOAD + " test 1");
        DiscordWebhook webhook = new DiscordWebhook(WEBHOOK);
        if (!(Config.RELOAD)) {
            webhook.addEmbed(new DiscordWebhook.EmbedObject()
                    .setColor(new Color(0, 130, 0))
                    .setTitle("Basics Plugin Started")
                    .setFooter("%time%", " ")

            );
            try {
                webhook.execute();
                Config.CFG.set("restart", false);
                Config.save();
                System.out.println(Config.RELOAD + "test 2");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            webhook.addEmbed(new DiscordWebhook.EmbedObject()
                    .setColor(new Color(255, 0, 0))
                    .setTitle("Basics Plugin Restarted")
                    .setFooter("%time%", " ")

            );

            try {
                webhook.execute();
                System.out.println(Config.RELOAD + "test 2b");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



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

    }

    @Override
    public void onDisable() {

        System.out.println(Config.RELOAD + "test 3");

        if (Config.RELOAD) {
            return;
        }

        DiscordWebhook webhook = new DiscordWebhook(WEBHOOK);
        webhook.addEmbed(new DiscordWebhook.EmbedObject()
                .setColor(color.RED)
                .setTitle("Basics Plugin Stopped")
                .setFooter("%time%", " ")

        );
        try {
            webhook.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Config.save();
        System.out.println(Config.RELOAD + "test 4");
    }
}

