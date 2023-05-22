package me.kktrkkt.springboot;

import me.kktrkkt.springbootstarter.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class BookRunner implements ApplicationRunner {

    @Autowired
    private Book book;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(book);
    }
}
