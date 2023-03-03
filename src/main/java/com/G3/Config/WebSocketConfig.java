package com.G3.Config;


import com.G3.Model.Sample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpAttributesContextHolder;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.messaging.SessionConnectEvent;

@Slf4j
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    Sample sample = new Sample();

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat")
//                .setHandshakeHandler((HandshakeHandler) webSocketHandler)
//                .setHandshakeHandler(new UserHandshakeHandler())
                .setAllowedOrigins("http://localhost:4200/")
                .withSockJS();
    }
    @EventListener
    private void handleSessionConnected(SessionConnectEvent event ) {
        String sessionId = SimpAttributesContextHolder.currentAttributes().getSessionId();
        log.info(">>>>>>>>>>>>> new sessionid "+sessionId);
        sample.setSessionId(sessionId);

    }
}
