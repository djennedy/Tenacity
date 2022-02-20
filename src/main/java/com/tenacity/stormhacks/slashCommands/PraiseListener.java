package com.tenacity.stormhacks.slashCommands;

import com.tenacity.stormhacks.DataMap;
import com.tenacity.stormhacks.TenacityApi;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.user.User;
import org.javacord.api.interaction.SlashCommandInteraction;
import org.javacord.api.interaction.callback.InteractionCallbackDataFlag;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PraiseListener {
    DiscordApi api = TenacityApi.getInstance().api;
    HashMap<User, List<String>> hashMap = DataMap.getInstance().hashMap;

    public PraiseListener(){
        api.addSlashCommandCreateListener(event -> {
            SlashCommandInteraction slashCommandInteraction = event.getSlashCommandInteraction();
            if(slashCommandInteraction.getCommandName().equals("praise")){
                User user;
                if (slashCommandInteraction.getArguments().isEmpty())
                {
                    user =  slashCommandInteraction.getUser();
                }
                else {
                    user = slashCommandInteraction.requestOptionUserValueByIndex(0).orElse(null).join();
                }

                if(!hashMap.containsKey(user) || hashMap.get(user).isEmpty()){

                    slashCommandInteraction.createImmediateResponder()
                            .setContent("Hi there! " + user.getDiscriminatedName() +
                                    " currently does not have any accomplishment added in our system." + "\n"+
                                    "But this doesn't mean that they're any less of an accomplished human being!"+ "\n" +
                                    "Why not you go ahead and add some of their accomplishments to our system, " +
                                    "and issue this command again to remind them of how wonderful they are!")
                            .setFlags(InteractionCallbackDataFlag.EPHEMERAL)
                            .respond();
                } else{
                    StringBuilder praises = new StringBuilder();
                    AtomicInteger i = new AtomicInteger(1);
                    List<String> praiseList = hashMap.get(user);
                    praiseList.forEach((praise) -> {
                        praises.append(i.getAndIncrement());
                        praises.append(". ");
                        praises.append(praise);
                        praises.append("\n");
                    });

                    EmbedBuilder goodJobGif = new EmbedBuilder().setImage("https://media.giphy.com/media/JLFq4Jh5bSJEDHZjSB/giphy.gif");
                    EmbedBuilder thankYouGif = new EmbedBuilder().setImage("https://media.giphy.com/media/osjgQPWRx3cac/giphy.gif");

                    new MessageBuilder()
                            .append("Hi there!")
                            .appendNewLine()
                            .append(slashCommandInteraction.getUser().getDiscriminatedName())
                            .append(" would like to remind you of how wonderful and accomplished you are!")
                            .appendNewLine()
                            .append("Here's a list of your accomplishments that you or your friends have added to remind you of your awesome-ness!")
                            .appendNewLine()
                            .appendNewLine()
                            .append(String.valueOf(praises))
                            .appendNewLine()
                            .append("Keep up the good work! Remember, we're a lot more accomplished than we think we are!")
                            .addEmbed(goodJobGif)
                            .send(user);

                    slashCommandInteraction.createImmediateResponder()
                            .setContent("Successfully sent "+ user.getDiscriminatedName() +" a list of their accomplishments! " +
                                    "\nThank you for reminding them how amazing and accomplished they are!")
                            .addEmbed(thankYouGif)
                            .setFlags(InteractionCallbackDataFlag.EPHEMERAL)
                            .respond();
                }

            }
        });
    }



}
