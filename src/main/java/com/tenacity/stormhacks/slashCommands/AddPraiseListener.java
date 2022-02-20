package com.tenacity.stormhacks.slashCommands;

import com.tenacity.stormhacks.DataMap;
import com.tenacity.stormhacks.TenacityApi;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.user.User;
import org.javacord.api.interaction.SlashCommandInteraction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddPraiseListener {
    DiscordApi api = TenacityApi.getInstance().api;
    HashMap<User, List<String>> hashMap = DataMap.getInstance().hashMap;

    public AddPraiseListener()
    {
        api.addSlashCommandCreateListener(event -> {
            SlashCommandInteraction slashCommandInteraction = event.getSlashCommandInteraction();
            if (slashCommandInteraction.getCommandName().equals("addpraise")) {
                User user = slashCommandInteraction.requestOptionUserValueByIndex(0).orElse(null).join();
                String acc = slashCommandInteraction.getOptionStringValueByIndex(1).orElse(null);

                if(user ==null || acc==null)
                {
                    slashCommandInteraction.createImmediateResponder()
                            .setContent("Something went wrong, please try again!")
                            .respond();
                    return;
                }

                if(!hashMap.containsKey(user))
                {
                    hashMap.put(user, new ArrayList<String>());
                }

                List<String> list = hashMap.get(user);
                list.add(acc);

                slashCommandInteraction.createImmediateResponder()
                        .setContent("Successfully added the accomplishment to the user's list.")
                        .respond();
            }
        });
    }
}
