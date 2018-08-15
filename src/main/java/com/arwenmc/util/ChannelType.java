package com.arwenmc.util;

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
}