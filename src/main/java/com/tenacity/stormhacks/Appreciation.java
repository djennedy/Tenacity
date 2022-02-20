package com.tenacity.stormhacks;

import org.javacord.api.entity.user.User;

import java.util.ArrayList;
import java.util.LinkedList;

public class Appreciation {
    User user;
    ArrayList<String> appreciations;

    Appreciation(User user){
        this.user = user;
        this.appreciations = new ArrayList<String>();
    }

        User getUser(){
            return user;
        }

        ArrayList<String> getAppreciations() {
            return appreciations;
        }

        void addAppreciation(String appraisals){
            appreciations.add(appraisals);
        }

        String getRecentAppraisal(){
            return appreciations.get(appreciations.size()-1);
        }

}
