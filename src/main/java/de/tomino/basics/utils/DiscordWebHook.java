package de.tomino.basics.utils;

import org.json.simple.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DiscordWebHook {

    public static URL url;

    static {
        try {
            url = new URL(Config.WEBHOOK);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    public static void sendtoDC(String message) {

        if (Config.WEBHOOK.equals("https://discordapp.com/api/webhooks/") || Config.WEBHOOK.equals("")) {
            return;
        }

        JSONObject json = new JSONObject();
        json.put("content", message);


        try {

            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.addRequestProperty("Content-Type", "application/json");
            con.addRequestProperty("User-Agent", "Java-Discord-Webhook");
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.getOutputStream().write(json.toJSONString().getBytes());
            con.getOutputStream().flush();
            con.getOutputStream().close();
            con.getInputStream().close();
            con.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
