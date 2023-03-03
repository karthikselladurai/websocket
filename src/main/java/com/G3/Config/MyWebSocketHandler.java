package com.G3.Config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;
@Slf4j
@Component
public abstract class MyWebSocketHandler implements WebSocketHandler {

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>",session.getId());

        // Handle WebSocket session
        return Mono.empty();
    }
}
