package com.tenacity.stormhacks.slashCommands;

import com.tenacity.stormhacks.DataMap;
import com.tenacity.stormhacks.TenacityApi;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.user.User;
import org.javacord.api.interaction.SlashCommandInteraction;
import org.javacord.api.interaction.SlashCommandInteractionOption;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ShowPraiseListener {
    DiscordApi api = TenacityApi.getInstance().api;
    HashMap<User, List<String>> hashMap = DataMap.getInstance().hashMap;

    public ShowPraiseListener(){
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


                if(!hashMap.containsKey(user)){
                    slashCommandInteraction.createImmediateResponder()
                            .setContent("You are a wonderful person!!")
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

                    slashCommandInteraction.createImmediateResponder()
                            .setContent(String.valueOf(praises))
                            .respond();
                }

            }
        });
    }



}
