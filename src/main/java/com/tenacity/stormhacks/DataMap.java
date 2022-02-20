package com.tenacity.stormhacks;

import org.javacord.api.entity.user.User;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DataMap {
    private static DataMap dataMap = null;
    public HashMap<User, List<String>> hashMap;

    private DataMap()
    {
        hashMap = new HashMap<>();
    }

    public static DataMap getInstance()
    {
        if (dataMap ==null)
            dataMap = new DataMap();
        return dataMap;
    }
}
