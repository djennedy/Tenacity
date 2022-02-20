package com.tenacity.stormhacks.slashCommands;

import com.tenacity.stormhacks.DataMap;
import com.tenacity.stormhacks.TenacityApi;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.user.User;
import org.javacord.api.interaction.SlashCommandInteraction;
import org.javacord.api.interaction.callback.InteractionCallbackDataFlag;

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
                List<String> list = hashMap.get(slashCommandInteraction.getUser());

                if(list==null)
                {
                    slashCommandInteraction.createImmediateResponder()
                            .setContent("ERROR: Attempting to remove from an empty list!")
                            .setFlags(InteractionCallbackDataFlag.EPHEMERAL)
                            .respond();
                    return;
                }

                if(list.isEmpty())
                {
                    slashCommandInteraction.createImmediateResponder()
                            .setContent("ERROR: Attempting to remove from an empty list!")
                            .setFlags(InteractionCallbackDataFlag.EPHEMERAL)
                            .respond();
                    return;
                }

                if(slashCommandInteraction.getArguments().isEmpty())
                {
                    String toBeRemoved = list.remove(list.size()-1);
                    slashCommandInteraction.createImmediateResponder()
                            .setContent("Successfully removed your most recent accomplishment added: "+ toBeRemoved)
                            .setFlags(InteractionCallbackDataFlag.EPHEMERAL)
                            .respond();
                }

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
                            .setFlags(InteractionCallbackDataFlag.EPHEMERAL)
                            .respond();
                    return;
                }

                if(index>=0 || index < list.size())
                {
                    String toBeRemoved = list.remove(index-1);
                    slashCommandInteraction.createImmediateResponder()
                            .setContent("Successfully removed accomplishment number "+ Integer.toString(index)+". : "+ toBeRemoved)
                            .setFlags(InteractionCallbackDataFlag.EPHEMERAL)
                            .respond();
                }
                else
                {
                    slashCommandInteraction.createImmediateResponder()
                            .setContent("ERROR: Invalid index number. Accomplishment not removed, please insert a valid index number!")
                            .setFlags(InteractionCallbackDataFlag.EPHEMERAL)
                            .respond();
                    return;
                }
            }
        });
    }
}
