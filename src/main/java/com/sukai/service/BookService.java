package com.sukai.service;

import com.sukai.VO.BookVO;
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
     * @return Book的集合
     */
    public List<Book> list() {

        return bookMapper.selectList(null);
    }

    /**
     * 找到对应ID的书籍
     *
     * @param id 书籍编号
     * @return Book
     */
    public BookVO get(int id) {

        return bookMapper.getBookById(id);
    }

    /**
     * 更新书籍
     *
     * @param bookVO 书
     */
    public void update(BookVO bookVO) {
        Book book1 = bookMapper.selectById(bookVO.getId());
        if (book1 == null) {
            Book book = new Book();

            book.setCid(bookVO.getCid());

            book.setTitle(bookVO.getTitle());

            book.setAuthor(bookVO.getAuthor());

            book.setAbs(bookVO.getAbs());

            book.setAuthor(bookVO.getAuthor());

            book.setDate(bookVO.getDate());

            book.setPress(bookVO.getPress());

            bookMapper.insert(book);
        } else {
            bookMapper.updateBookVO(bookVO);
        }

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
