package me.kktrkkt.springboot.data.mongo.account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class AccountRepositoryTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void template() {
        Account account = new Account();
        account.setUsername("kktrkkt");
        account.setPassword("pass");

        Account saveAccount = mongoTemplate.insert(account);
        System.out.println(saveAccount);
    }

    @Test
    public void repository() {
        Account account = new Account();
        account.setUsername("kktrkkt");
        account.setPassword("pass");
        account.setActive(true);
        account.setEmail("kktrkkt@email.com");

        Account newAccount = accountRepository.save(account);
        assertNotNull(newAccount);

        Optional<Account> existingAccount = accountRepository.findByUsername(account.getUsername());
        assertTrue(existingAccount.isPresent());
        System.out.println(existingAccount.get());
    }
}