package com.tenacity.stormhacks.slashCommands;

import com.tenacity.stormhacks.DataMap;
import com.tenacity.stormhacks.TenacityApi;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.user.User;
import org.javacord.api.interaction.SlashCommandInteraction;

import java.util.HashMap;
import java.util.List;

public class RemovePraiseListener {
    DiscordApi api = TenacityApi.getInstance().api;
    HashMap<User, List<String>> hashMap = DataMap.getInstance().hashMap;

    public RemovePraiseListener()
    {
        api.addSlashCommandCreateListener(event -> {
            SlashCommandInteraction slashCommandInteraction = event.getSlashCommandInteraction();
            if (slashCommandInteraction.getCommandName().equals("rmpraise")) {
                Double doub = slashCommandInteraction.getOptionDecimalValueByIndex(0).orElse(null);
                int index;

                if(doub!=null)
                {
                    index = doub.intValue();
                }
                else
                {
                    slashCommandInteraction.createImmediateResponder()
                            .setContent("Something went wrong, please try again!")
                            .respond();
                    return;
                }

                List<String> list = hashMap.get(slashCommandInteraction.getUser());
                if(index<=0 || index > list.size())
                {
                    list.remove(index-1);
                }
                else
                {
                    slashCommandInteraction.createImmediateResponder()
                            .setContent("ERROR: Invalid index number. Praise not removed, please insert a valid index number!")
                            .respond();
                    return;
                }


                slashCommandInteraction.createImmediateResponder()
                        .setContent("")
                        .respond();
            }
        });
    }
}
