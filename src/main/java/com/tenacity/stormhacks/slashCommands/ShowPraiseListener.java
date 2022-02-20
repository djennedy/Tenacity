package com.tenacity.stormhacks.slashCommands;

import com.tenacity.stormhacks.DataMap;
import com.tenacity.stormhacks.TenacityApi;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.MessageDecoration;
import org.javacord.api.entity.user.User;
import org.javacord.api.interaction.*;
import org.javacord.api.interaction.SlashCommandInteraction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ShowPraiseListener {
    DiscordApi api = TenacityApi.getInstance().api;
    HashMap<User, List<String>> hashMap = DataMap.getInstance().hashMap;

//    public ShowPraiseListener(){
//        api.addSlashCommandCreateListener(event -> {
//            SlashCommandInteraction slashCommandInteraction = event.getSlashCommandInteraction();
//            if(slashCommandInteraction.getCommandName().equals("showpraise")){
//
//            }
//        })
//    }
//

//    Message personalPraise = new MessageBuilder()
//            .append("Hi")
//            .append(praise.getUser().getMentionTag())
//            .append("!\n")
//            .append("Here are all the great things people are saying about you today! \uD83D\uDE03")
//            .append(userTest.forEach())


}
