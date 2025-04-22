package org.example;

@ChannelHandler.Sharable
public class WebSocketServerHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private final WebSocketChannelManager channelManager;

    public WebSocketServerHandler(WebSocketChannelManager manager) {
        this.channelManager = manager;
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame frame) {
        String text = frame.text();
        System.out.println("收到消息：" + text);
        // 根据消息内容处理
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        // 连接建立后，可以通过 URI 或头部获取 userId 和 token
        String uri = ctx.channel().attr(AttributeKey.valueOf("uri")).get().toString();
        QueryStringDecoder decoder = new QueryStringDecoder(uri);
        String userId = decoder.parameters().get("userId").get(0);
        String token = decoder.parameters().get("token").get(0);

        // TODO: 鉴权逻辑
        if ("123456".equals(token)) {
            channelManager.add(userId, ctx.channel());
            System.out.println("绑定用户：" + userId);
        } else {
            ctx.close();
        }
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        channelManager.remove(ctx.channel());
    }
}
