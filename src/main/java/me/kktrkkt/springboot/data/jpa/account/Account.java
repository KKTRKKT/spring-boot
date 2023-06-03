package me.kktrkkt.springboot.data.jpa.account;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@ToString
@EqualsAndHashCode
public class Account {

    @Id @GeneratedValue
    private Long id;

    private String username;

    private String password;
}
