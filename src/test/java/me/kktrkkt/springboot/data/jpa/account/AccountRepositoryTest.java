package me.kktrkkt.springboot.data.jpa.account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest // dataJpaTest 설정에 의해 h2를 사용한다.
class AccountRepositoryTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void dataSource() throws SQLException {
        try(Connection connection = dataSource.getConnection()){
            System.out.println(dataSource.getClass());
            System.out.println(connection.getMetaData().getDriverName());
            System.out.println(connection.getMetaData().getURL());
            System.out.println(connection.getMetaData().getUserName());
        }
    }

    @Test
    public void accountRepository() {
        Account account = new Account();
        account.setUsername("kktrkkt");
        account.setPassword("pass");

        Account newAccount = accountRepository.save(account);
        assertNotNull(newAccount);

        Optional<Account> existingAccount = accountRepository.findByUsername("kktrkkt");
        assertTrue(existingAccount.isPresent());
    }
}