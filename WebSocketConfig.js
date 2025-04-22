public class WebSocketConfig {
    // 客户端 JavaScript 示例
const userId = "user_001";
const token = "123456";
const socket = new WebSocket(`ws://localhost:8088/ws?userId=${userId}&token=${token}`);

            socket.onmessage = function (e) {
        console.log("收到消息:", e.data);
    };

    socket.onopen = function () {
        console.log("连接成功");
    };

}
