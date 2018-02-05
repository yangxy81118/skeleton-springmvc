package com.yxy.startup.javaspringmybatisredis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.yxy.startup.javaspringmybatisredis.controller.SocketController;

@Configuration
@EnableWebSocket
public class WebsocketConfig implements WebSocketConfigurer {

	@Bean
	public WebSocketHandler myMessageHandler() {
		return new SocketController();
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(myMessageHandler(), "/socket").setAllowedOrigins("*");
	}

}
