package me.kktrkkt.springboot.spring_security;

import me.kktrkkt.springboot.spring_security.account.Account;
import me.kktrkkt.springboot.spring_security.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class DBRunner implements ApplicationRunner {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try(Connection connection = dataSource.getConnection()){
            System.out.println(connection.getMetaData().getDriverName());
            System.out.println(connection.getMetaData().getURL());
            System.out.println(connection.getMetaData().getUserName());
        }
        Account kktrkkt = accountService.createAccount("kktrkkt", "1234");
        System.out.println(kktrkkt);
    }
}
