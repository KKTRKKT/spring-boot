package me.kktrkkt.springboot.data.mongo.account;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// collection는 db의 table과 비슷하다
@Document(collection = "accounts")
@Data
public class Account {

    @Id
    private String id;

    private String username;

    private String password;

    private String email;

    private boolean active;
}
