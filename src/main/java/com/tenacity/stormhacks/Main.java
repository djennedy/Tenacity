package com.tenacity.stormhacks;

import org.javacord.api.DiscordApi;

public class Main {
    public static void main(String[] args) {
        TenacityApi tenacityApi = TenacityApi.getInstance();

        tenacityApi.api.addMessageCreateListener(
                event ->
                {
                    if (event.getMessageContent().equalsIgnoreCase("!ping"))
                    {
                        event.getChannel().sendMessage("Pong!");
                    }
                }
        );
    }
}
