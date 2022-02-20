package com.tenacity.stormhacks.slashCommands;

import com.tenacity.stormhacks.TenacityApi;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.interaction.SlashCommandInteraction;
import org.javacord.api.interaction.callback.InteractionCallbackDataFlag;

import java.awt.*;

public class HelpListener {
    DiscordApi api = TenacityApi.getInstance().api;
    public HelpListener()
    {
        api.addSlashCommandCreateListener(event -> {
            SlashCommandInteraction slashCommandInteraction = event.getSlashCommandInteraction();
            if(slashCommandInteraction.getCommandName().equals("help"))
            {
                slashCommandInteraction.createImmediateResponder()
                        .setContent("Hi there!\n"+
                                "Tenacity is a Discord bot with the purpose of driving insecurities away.\n"+
                                "We often feel like other people are always more talented and accomplished than we are.\n" +
                                "However, we tend to forget that we are just as amazing as others.\n" +
                                "Tenacity is created to help combat the feeling of being inferior to others by allowing users to remind themselves and others of their own accomplishments.\n" +
                                "\n" +
                                "USAGE:\n" +
                                "/addpraise : Add to a user's list of accomplishments.\n" +
                                "/praise : Send a user's list of accomplishments to them through direct message.\n" +
                                "/rmpraise : Remove one of your accomplishments from our list.\n" +
                                "/help : Shows how to use the bot and why we build this bot.\n" +
                                "/ping : Pong!"
                        )
                        .setFlags(InteractionCallbackDataFlag.EPHEMERAL)
                        .respond();
            }
        });
    }

}
