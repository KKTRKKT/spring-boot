package me.kktrkkt.springboot.data.redis.account;

import me.kktrkkt.springboot.data.redis.Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = Application.class)
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void accountRepository() {
        Account account = new Account();
        account.setUsername("kktrkkt");
        account.setPassword("pass");
        account.setActive(true);
        account.setEmail("kktrkkt@email.com");

        Account newAccount = accountRepository.save(account);
        assertNotNull(newAccount);

        Optional<Account> existingAccount = accountRepository.findById(account.getId());
        assertTrue(existingAccount.isPresent());
        System.out.println(existingAccount.get());
    }
}