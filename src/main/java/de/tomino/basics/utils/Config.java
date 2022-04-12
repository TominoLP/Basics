package de.tomino.basics.utils;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Config {

    public static final File CFG_FILE = new File("plugins/Basics/config.yml");
    public static final YamlConfiguration CFG = YamlConfiguration.loadConfiguration(CFG_FILE);
    public static String LANGUAGE;
    public static String WEBHOOK;
    public static String PREFIX;
    public static boolean RELOAD;

    public static void load() {

        CFG.addDefault("version", "1.0");
        CFG.addDefault("prefix", "&8[&6Basics&8]");
        CFG.addDefault("language", "en");
        CFG.addDefault("webhook", "https://discordapp.com/api/webhooks/");
        CFG.addDefault("restart", false);
        CFG.options().copyDefaults(true);
        LANGUAGE = Objects.requireNonNull(CFG.getString("language")).toLowerCase();
        WEBHOOK = CFG.getString("webhook");
        PREFIX = CFG.getString("prefix");
        RELOAD = CFG.getBoolean("restart");
        Languages.setLanguage();
        save();

        try {
            CFG.save(CFG_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void save() {
        try {
            CFG.save(CFG_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
