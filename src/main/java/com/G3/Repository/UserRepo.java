package com.G3.Repository;

import com.G3.Model.UserModel;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  UserRepo extends ReactiveMongoRepository<UserModel, String> {

}
