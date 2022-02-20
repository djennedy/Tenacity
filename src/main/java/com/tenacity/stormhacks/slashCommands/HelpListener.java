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

        api.addSlashCommandCreateListener(event -> {
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
