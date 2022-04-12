package de.tomino.basics.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Calendar;
import java.util.Locale;

public class ChatLogger implements Listener {

    @EventHandler
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {

        /*Player player = event.getPlayer();
        DiscordWeb1 webhook = new DiscordWeb1(Config.WEBHOOK);
        webhook.addEmbed(new DiscordWeb1.EmbedObject()
                .setTitle(player.getName())
                .setDescription(event.getMessage())
                .setColor(DiscordWeb1.color.GREEN)
        );
        try {
            webhook.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        Calendar cal = Calendar.getInstance(Locale.GERMANY);
        String time = String.format("%02d:%02d:%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));

        /*DiscordWebHook.sendtoDC("[" + time + "]" + event.getPlayer().getName() + ": " + event.getMessage());*/
    }

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        Calendar cal = Calendar.getInstance(Locale.GERMANY);
        String time = String.format("%02d:%02d:%02d", cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND));

        /*DiscordWebHook.sendtoDC("[" + time + "]" + event.getPlayer().getName() + ": " + event.getMessage());*/
    }


}
