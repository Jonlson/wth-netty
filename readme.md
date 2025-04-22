

## 🚀 Netty WebSocket Server

基于 **Spring Boot + Netty** 构建的高性能 WebSocket 消息推送服务。适用于 IM 聊天、在线通知、实时数据推送等场景。

---

### 📦 项目结构

```
netty-websocket-server
├── pom.xml
├── src
│   └── main
│       ├── java
│       │   └── com.example.websocket
│       │       ├── NettyWebSocketServerApplication.java  // Spring Boot 启动类
│       │       ├── NettyServer.java                      // Netty 启动入口
│       │       ├── WebSocketChannelHandler.java          // WebSocket 处理器
│       │       └── ...（可添加业务层 Controller、Service）
│       └── resources
│           └── application.yml
```

---

### ⚙️ 技术栈

| 技术        | 说明                         |
|-------------|------------------------------|
| Spring Boot | 容器与依赖管理               |
| Netty       | 高性能网络通信框架           |
| WebSocket   | 实时通信协议                 |
| Maven       | 项目构建和依赖管理工具       |
| Lombok      | 简化 Java 代码（可选）       |

---

### 📥 安装与使用

#### 1. 克隆项目
```bash
git clone https://github.com/yourname/netty-websocket-server.git
cd netty-websocket-server
```

#### 2. 修改配置
在 `application.yml` 中配置端口等信息（如有必要）。

#### 3. 启动服务
```bash
mvn clean install
java -jar target/netty-websocket-server-0.0.1-SNAPSHOT.jar
```

或者直接在 IDE 中运行 `NettyWebSocketServerApplication.java`

---

### 🧪 WebSocket 连接测试

你可以使用以下方式连接：

#### JS 示例（浏览器控制台）

```javascript
const socket = new WebSocket("ws://localhost:8080/ws");
socket.onmessage = (msg) => console.log("收到消息：", msg.data);
socket.onopen = () => socket.send("Hello Server!");
```

#### Postman 或 WebSocket 客户端工具（如: [WebSocket King](https://chrome.google.com/webstore/detail/websocket-king-client/cbcbkhdmedgianpaifchdaddpnmgnknn)）

---

### 🧠 示例场景

- 实时聊天系统
- 实时通知中心（订单、告警等）
- 实时监控面板
- 游戏服务器通信

---

### 🧩 TODO（扩展方向）

- [ ] Token 鉴权 + 用户身份绑定
- [ ] 多客户端分布式部署（整合 Redis / RocketMQ）
- [ ] 与数据库数据联动
- [ ] 后端推送 REST API 接口

---

### 📄 License

[MIT License](LICENSE)

