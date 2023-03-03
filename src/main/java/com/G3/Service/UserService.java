package com.G3.Service;

import com.G3.Model.UserModel;
import com.G3.Repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepo  userRepo;
   public Mono<String> save( UserModel userModel){
//       log.info("noooo"+userModel.getId()+userModel.getUserName());
       return  userRepo.insert(userModel).map(u -> "User saved successfully with id: " + u)
                .onErrorResume(ex -> Mono.just("Failed to save user: " + ex.getMessage()));
    }
    public Flux<UserModel> getAll() {
        log.info(">>>>>>>>>>>>>>noo");
//        redisService.getValue("sample").subscribe(value -> log.info(">>>>>>>>>>>>>>redis"+value));
        log.info(">>>>>>>>>>>>>>redisService");
        return userRepo.findAll();
    }
}
