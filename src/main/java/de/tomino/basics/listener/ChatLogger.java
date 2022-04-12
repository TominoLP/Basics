package de.tomino.basics.listener;

import de.tomino.basics.utils.DiscordWebhook;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Calendar;
import java.util.Locale;

public class ChatLogger implements Listener {

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        Calendar cal = Calendar.getInstance(Locale.GERMANY);
        String time = String.format("%02d:%02d:%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));

        DiscordWebhook.send("[" + time + "] " + event.getPlayer().getName() + ": " + event.getMessage());
    }

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        Calendar cal = Calendar.getInstance(Locale.GERMANY);
        String time = String.format("%02d:%02d:%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));

        DiscordWebhook.send("[" + time + "] " + event.getPlayer().getName() + ": " + event.getMessage());
    }


}
