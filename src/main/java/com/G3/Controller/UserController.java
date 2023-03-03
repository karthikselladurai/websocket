package com.G3.Controller;

import com.G3.Model.UserModel;

import com.G3.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/signup")
    public Mono<String> signup(@RequestBody UserModel userModel){
        return userService.save(userModel);
    }
    @GetMapping("/getall")
    public Flux<UserModel>read(){

        return userService.getAll();
    }



}
