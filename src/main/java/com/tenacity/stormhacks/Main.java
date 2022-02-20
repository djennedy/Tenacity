package com.tenacity.stormhacks;

import com.tenacity.stormhacks.slashCommands.SlashCommands;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.message.MessageFlag;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.server.Server;
import org.javacord.api.interaction.SlashCommand;
import org.javacord.api.interaction.SlashCommandInteraction;
import org.javacord.api.interaction.SlashCommandOption;
import org.javacord.api.interaction.callback.InteractionCallbackDataFlag;

import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.Optional;

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

        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("Title")
                .setDescription("Description")
                .setAuthor("Author Name", "http://google.com/", "https://cdn.discordapp.com/embed/avatars/0.png")
                .addField("A field", "Some text inside the field")
                .addInlineField("An inline field", "More text")
                .addInlineField("Another inline field", "Even more text")
                .setColor(Color.BLUE)
                .setFooter("Footer", "https://cdn.discordapp.com/embed/avatars/1.png")
                .setImage("https://media.giphy.com/media/KztT2c4u8mYYUiMKdJ/giphy.gif")
                .setThumbnail("https://images2.minutemediacdn.com/image/upload/c_crop,h_1601,w_2379,x_0,y_0/v1626804597/shape/mentalfloss/648495-gettyimages-1213860280.jpg?itok=TM9y9lQ3");

        //Debugging Server
        Server myServer= tenacityApi.api.getServerById("890685750981586944").get();

        //Adding slash commands
        //TODO: Change all create for server to global before submission
//        SlashCommand command= SlashCommand.with("help","Shows how to use the bot.").createGlobal(tenacityApi.api).join();
//        SlashCommand.with("ping", "A simple ping pong command!").createGlobal(tenacityApi.api).join();
//        SlashCommand.with("test","testing server only slash command").createForServer(myServer).join();

        //Listeners
        tenacityApi.api.addSlashCommandCreateListener(event -> {
            SlashCommandInteraction slashCommandInteraction = event.getSlashCommandInteraction();
            if (slashCommandInteraction.getCommandName().equals("ping")) {
                slashCommandInteraction.createImmediateResponder()
                        .setContent("Pong!")
                        .respond();
            }
        });

        tenacityApi.api.addSlashCommandCreateListener(event -> {
            SlashCommandInteraction slashCommandInteraction = event.getSlashCommandInteraction();
            if(slashCommandInteraction.getCommandName().equals("help"))
            {
                slashCommandInteraction.createImmediateResponder()
                        .setContent("Insert help here")
                        .addEmbed(embed)
                        .setFlags(InteractionCallbackDataFlag.EPHEMERAL)
                        .respond();
            }
        });



    }
}
