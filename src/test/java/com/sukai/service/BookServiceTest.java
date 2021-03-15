package com.sukai.service;

import com.sukai.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {
    @Autowired
    BookService bookService;

    @Test
    void testAPI(){
        Map<Integer, Book> integerBookMap = bookService.listByCategory(1);
        for(Book book : integerBookMap.values()){
            System.out.println(book);
        }
    }

    @Test
    void testSearch(){
        List<Book> list = bookService.search("承苏凯");
        for(Book book : list){
            System.out.println(book);
        }
    }
}