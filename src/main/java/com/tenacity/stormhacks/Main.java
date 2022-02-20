package com.tenacity.stormhacks;

import com.tenacity.stormhacks.slashCommands.HelpListener;
import com.tenacity.stormhacks.slashCommands.PingListener;
import org.javacord.api.entity.server.Server;
import org.javacord.api.interaction.*;

import java.util.Arrays;
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

        //Debugging Server
        Server myServer= tenacityApi.api.getServerById("890685750981586944").get();

        //Adding slash commands
        //TODO: Change all create for server to global before submission
//        SlashCommand help = SlashCommand.with("help","Shows how to use the bot.").createGlobal(tenacityApi.api).join();
//        SlashCommand ping = SlashCommand.with("ping", "A simple ping pong command!").createGlobal(tenacityApi.api).join();
//        SlashCommand test = SlashCommand.with("test","testing server only slash command").createForServer(myServer).join();
        SlashCommand praise = SlashCommand.with("praise","Lists the accomplishments of the user saved"
                , new SlashCommandOptionBuilder()
                        .setType(SlashCommandOptionType.USER)
                        .setName("User")
                        .setDescription("The user that you would like to show their accomplishments to.")
                        .setRequired(true)
                )
                .createForServer(myServer)
                .join();
        SlashCommand addPraise = SlashCommand.with("addpraise","Adds an accomplishment of a user",
                new SlashCommandOptionBuilder()
                        .setType(SlashCommandOptionType.USER)
                        .setName("User")
                        .setDescription("The user that you would like to add an accomplishment to")
                        .setRequired(true),
                new SlashCommandOptionBuilder()
                        .setType(SlashCommandOptionType.STRING)
                        .setName("Accomplishment")
                        .setDescription("The accomplishment you would like to add")
                        .setRequired(true)
                )
                .createForServer(myServer)
                .join();

        //Listeners
        HelpListener helpListener = new HelpListener();
        PingListener pingListener = new PingListener();



    }
}