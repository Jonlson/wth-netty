package org.example;

@Component
public class NettyWebSocketServer {

    private final WebSocketServerHandler handler;

    public NettyWebSocketServer(WebSocketServerHandler handler) {
        this.handler = handler;
    }

    @PostConstruct
    public void start() throws Exception {
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) {
                        ch.pipeline()
                                .addLast(new HttpServerCodec())
                                .addLast(new HttpObjectAggregator(65536))
                                .addLast(new WebSocketServerProtocolHandler("/ws"))
                                .addLast(handler);
                    }
                });

        ChannelFuture future = bootstrap.bind(8088).sync();
        System.out.println("WebSocket 启动成功，端口：8088");
    }
}
