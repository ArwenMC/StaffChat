package com.arwenmc.util;

public enum ChannelType {

    ADMIN("admin"),
    STAFF("staff"),
    REGULAR("regular");

    private String channel;
    ChannelType(String channel) {
        this.channel = channel;
    }

    public String getChannel() {
        return this.channel;
    }
}
