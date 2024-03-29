package me.kktrkkt.springboot.data.mongo.account;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccountRepository extends MongoRepository<Account, String> {
    Optional<Account> findByUsername(String id);
}
