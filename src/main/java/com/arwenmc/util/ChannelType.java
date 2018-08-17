package com.arwenmc.util;

import java.util.HashMap;
import java.util.UUID;

public enum ChannelType {
    ADMIN("admin"),
    DEFAULT("default"),
    STAFF("staff");

    private String channel;

    ChannelType(String channel) {
        this.channel = channel;
    }

    public String getChannel() {
        return this.channel;
    }

    // TODO add method to get ChannelType and therefor channel from hashmap
    public ChannelType getChannelHashMap(HashMap<UUID, ChannelType> hashMap, UUID uuid) {
        return hashMap.get(uuid);
    }

    public String getChannel(ChannelType channelType) {
        return channelType.getChannel();
    }
}
