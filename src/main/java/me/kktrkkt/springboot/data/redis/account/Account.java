package me.kktrkkt.springboot.data.redis.account;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("accounts")
@Data
@ToString
@EqualsAndHashCode
public class Account {

    @Id
    private Long id;

    private String username;

    private String password;

    private String email;

    private boolean active;
}
