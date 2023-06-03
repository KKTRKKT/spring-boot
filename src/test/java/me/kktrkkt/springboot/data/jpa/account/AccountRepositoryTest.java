package me.kktrkkt.springboot.data.jpa.account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;

import javax.sql.DataSource;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@TestPropertySource("classpath:/data/jpa/application.properties")
class AccountRepositoryTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void test() {
        Account account = new Account();
        account.setUsername("kktrkkt");
        account.setPassword("pass");

        Account newAccount = accountRepository.save(account);
        assertNotNull(newAccount);

        Optional<Account> existingAccount = accountRepository.findByUsername("kktrkkt");
        assertTrue(existingAccount.isPresent());
    }
}