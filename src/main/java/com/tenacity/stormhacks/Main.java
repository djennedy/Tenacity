package com.tenacity.stormhacks;

import com.tenacity.stormhacks.slashCommands.*;
import org.javacord.api.entity.server.Server;
import org.javacord.api.interaction.SlashCommand;
import org.javacord.api.interaction.SlashCommandOptionBuilder;
import org.javacord.api.interaction.SlashCommandOptionType;

import java.util.List;

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

        //Adding slash commands
//        SlashCommand help = SlashCommand.with("help","Shows how to use the bot.").createGlobal(tenacityApi.api).join();
//        SlashCommand ping = SlashCommand.with("ping", "A simple ping pong command!").createGlobal(tenacityApi.api).join();
//        SlashCommand praise = SlashCommand.with("praise","Shows all of the saved accomplishments of a user."
//                , new SlashCommandOptionBuilder()
//                        .setType(SlashCommandOptionType.USER)
//                        .setName("User")
//                        .setDescription("The user that you would like to show their accomplishments to.")
//                        .setRequired(false)
//                )
//                .createGlobal(tenacityApi.api)
//                .join();
//        SlashCommand addPraise = SlashCommand.with("addpraise","Adds an accomplishment of a user",
//                new SlashCommandOptionBuilder()
//                        .setType(SlashCommandOptionType.USER)
//                        .setName("User")
//                        .setDescription("The user that you would like to add an accomplishment to")
//                        .setRequired(true),
//                new SlashCommandOptionBuilder()
//                        .setType(SlashCommandOptionType.STRING)
//                        .setName("Accomplishment")
//                        .setDescription("The accomplishment you would like to add")
//                        .setRequired(true)
//                )
//                .createGlobal(tenacityApi.api)
//                .join();
//        SlashCommand removePraise = SlashCommand.with("rmpraise", "Removes one of your accomplishments",
//                new SlashCommandOptionBuilder()
//                        .setType(SlashCommandOptionType.DECIMAL)
//                        .setName("Index")
//                        .setDescription("Index number of the accomplishment you would like to remove. Defaults to most recent if not given.")
//                        .setRequired(false)
//                )
//                .createGlobal(tenacityApi.api)
//                .join();

        //Listeners
        HelpListener helpListener = new HelpListener();
        PingListener pingListener = new PingListener();
        AddPraiseListener addPraiseListener = new AddPraiseListener();
        RemovePraiseListener removePraiseListener = new RemovePraiseListener();
        PraiseListener showPraiseListener = new PraiseListener();

    }
}