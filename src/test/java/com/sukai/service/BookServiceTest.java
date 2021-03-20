package com.sukai.service;

import com.sukai.VO.BookVO;
import com.sukai.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

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
    void testGet(){
        BookVO book = bookService.get(1);
        System.out.println(book);
    }

    @Test
    void testAdd(){
        BookVO bookVO = new BookVO();
        bookVO.setAbs("xxx");
        bookVO.setAuthor("csk");
        bookVO.setCategory("文秀");
        bookVO.setCid(2);
        bookVO.setId(1);
        bookVO.setDate("2019-2-3");
        bookVO.setCover("test");
        bookVO.setPress("press");
        bookVO.setTitle("title");
    }
    @Test
    void testUpdate(){
        BookVO bookVO = new BookVO();
        bookVO.setAbs("xxx");
        bookVO.setAuthor("csk");
        bookVO.setCategory("文秀");
        bookVO.setCid(2);
        bookVO.setId(1);
        bookVO.setDate("2019-2-3");
        bookVO.setCover("test");
        bookVO.setPress("press");
        bookVO.setTitle("title");
        bookService.update(bookVO);
    }
    @Test
    void testSearch(){
        List<Book> list = bookService.search("承苏凯");
        for(Book book : list){
            System.out.println(book);
        }
    }
}