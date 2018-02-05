package com.yxy.startup.javaspringmybatisredis.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class SocketController extends TextWebSocketHandler {

//	 @Autowired
//	 private SimpMessagingTemplate brokerMessagingTemplate;    
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		super.handleTextMessage(session, message);
		System.out.println("Message:"+message.getPayload());
		System.out.println("Message:"+message);
//		session.sendMessage(response);
//		brokerMessagingTemplate.convertAndSend("/topic", "hahahhaha");
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
	}
	
	
	
	
}
