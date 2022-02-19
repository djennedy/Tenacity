package com.tenacity.stormhacks;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TenacityApi {
    private static TenacityApi tenacityApi = null;
    public DiscordApi api;

    private TenacityApi()
    {
        try(InputStream inputStream = new FileInputStream("src/main/resources/config.properties"))
        {
            Properties properties = new Properties();
            properties.load(inputStream);

            api=new DiscordApiBuilder().setToken(properties.getProperty("token")).login().join();

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public static TenacityApi getInstance()
    {
        if (tenacityApi==null)
            tenacityApi= new TenacityApi();
        return tenacityApi;
    }
}
