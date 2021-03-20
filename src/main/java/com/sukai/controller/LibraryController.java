package com.sukai.controller;

import com.sukai.VO.BookVO;
import com.sukai.pojo.Book;
import com.sukai.service.BookService;
import com.sukai.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author chengsukai
 */
@RestController
@CrossOrigin
public class LibraryController {

    @Autowired
    BookService bookService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/api/books")
    public List<Book> list() {
        return bookService.list();
    }

    @GetMapping("/api/book/{id}")
    public BookVO getBook(@PathVariable(value = "id") int id) {
        return bookService.get(id);
    }

    @PostMapping("/api/books")
    public void addOrUpdate(@RequestBody BookVO book) {
        bookService.update(book);
    }

    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book) {
        bookService.deleteById(book.getId());
    }

    @GetMapping("/api/categories/{cid}/books")
    public Map<Integer, Book> listByCategory(@PathVariable("cid") int cid) {
        if (0 != cid) {
            return bookService.listByCategory(cid);
        } else {
            return null;
        }
    }

    @GetMapping("/api/search")
    public List<Book> searchBook(@RequestParam("keywords") String keywords) {
        return bookService.search(keywords);
    }


}
