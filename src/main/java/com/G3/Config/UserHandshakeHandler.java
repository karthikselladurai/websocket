package com.G3.Config;

import com.G3.Model.Sample;
import com.sun.security.auth.UserPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;

@Slf4j
public class UserHandshakeHandler extends DefaultHandshakeHandler {

    Sample sample= new Sample();


    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler wsHandler, Map<String, Object> attributes) {
//        final String randomId = UUID.randomUUID().toString();
        final String randomId ="123456789";

//        sample.setSessionId(randomId);
//        log.info(randomId);
//        log.info(">>>>>>>>>>>>>>>>>> sample"+sample.getSessionId());



        return new UserPrincipal(randomId);
    }
}
