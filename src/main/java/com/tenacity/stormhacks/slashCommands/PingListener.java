package com.tenacity.stormhacks.slashCommands;

import com.tenacity.stormhacks.TenacityApi;
import org.javacord.api.DiscordApi;
import org.javacord.api.interaction.SlashCommandInteraction;

public class PingListener {
    DiscordApi api = TenacityApi.getInstance().api;

    public PingListener()
    {
        api.addSlashCommandCreateListener(event -> {
            SlashCommandInteraction slashCommandInteraction = event.getSlashCommandInteraction();
            if (slashCommandInteraction.getCommandName().equals("ping")) {
                    slashCommandInteraction.createImmediateResponder()
                        .setContent("Pong!")
                        .respond();
            }
        });
    }
}
