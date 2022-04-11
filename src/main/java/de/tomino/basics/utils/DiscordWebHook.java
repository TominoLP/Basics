package de.tomino.basics.utils;



// https://discord.com/api/webhooks/963043460443680839/2z5Tsb6YbHCnm2S3QUKvbvH0atpukWKuaWz_P5lCQLIPxFQu--8OGLRUgJSnslXvMKQ4

import org.json.simple.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DiscordWebHook {

    public static URL url;

    static {
        try {
            url = new URL("https://discord.com/api/webhooks/963043460443680839/2z5Tsb6YbHCnm2S3QUKvbvH0atpukWKuaWz_P5lCQLIPxFQu--8OGLRUgJSnslXvMKQ4");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void sendtoDC(String message) {

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
