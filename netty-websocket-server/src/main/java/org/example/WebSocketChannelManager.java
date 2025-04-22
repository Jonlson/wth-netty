package org.example;

import java.nio.channels.Channel;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class WebSocketChannelManager {
    private final Map<String, Channel> userChannelMap = new ConcurrentHashMap<>();

    public void add(String userId, Channel channel) {
        userChannelMap.put(userId, channel);
    }

    public void remove(Channel channel) {
        userChannelMap.values().removeIf(c -> c.id().equals(channel.id()));
    }

    public Channel getChannel(String userId) {
        return userChannelMap.get(userId);
    }

    public void sendMessage(String userId, String message) {
        Channel channel = userChannelMap.get(userId);
        if (channel != null && channel.isActive()) {
            channel.writeAndFlush(new TextWebSocketFrame(message));
        }
    }
}
