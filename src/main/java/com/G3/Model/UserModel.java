package com.G3.Model;

import lombok.*;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection  = "users")
public class UserModel {

    @Id
    @Field("_id")
    private String id;

    private  String userName ;
    private String password;

}
