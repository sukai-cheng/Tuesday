package com.sukai.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sukai.mapper.BookMapper;
import com.sukai.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * @author chengsukai
 */
@Service
public class BookService {

    @Autowired
    BookMapper bookMapper;

    @Autowired
    CategoryService categoryService;

    /**
     * 查出所有书籍
     *
     * @return
     */
    public List<Book> list() {

        return bookMapper.selectList(null);
    }

    /**
     * 新增书籍
     *
     * @param book 书
     */
    public void add(Book book) {
        bookMapper.insert(book);
    }

    /**
     * 更新书籍
     *
     * @param book 书
     */
    public void update(Book book) {
        bookMapper.update(book, new QueryWrapper<Book>().eq("id", book.getId()));
    }

    /**
     * 删除书籍
     *
     * @param id 书籍id
     */
    public void deleteById(int id) {

        bookMapper.deleteById(id);
    }

    /**
     * 通过分类查找书籍
     *
     * @param cid 外键
     * @return Map结果集
     */
    public Map<Integer, Book> listByCategory(int cid) {
        return bookMapper.getBookByCategory(cid);
    }

    /**
     * 模糊查询
     *
     * @param keywords 关键字
     * @return List<Book>
     */
    public List<Book> search(String keywords) {
        return bookMapper.searchByKeywords(keywords);
    }


}
