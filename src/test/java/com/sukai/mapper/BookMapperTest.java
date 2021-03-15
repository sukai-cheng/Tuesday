package com.sukai.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sukai.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class BookMapperTest {

    @Autowired
    BookMapper bookMapper;

    @Test
    void xmlPage(){
        Map<Integer, Book> bookByCategory = bookMapper.getBookByCategory(1);
        System.out.println(bookByCategory);
    }

    @Test
    void testUpdate(Book book){
        bookMapper.update(book,new QueryWrapper<Book>().eq("id",book.getId()));
    }
}