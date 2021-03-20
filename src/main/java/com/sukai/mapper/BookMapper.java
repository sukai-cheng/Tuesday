package com.sukai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sukai.VO.BookVO;
import com.sukai.pojo.Book;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author chengsukai
 */
public interface BookMapper extends BaseMapper<Book> {
    /**
     * 通过分类查询找到
     *
     * @param cid 分类ID
     * @return 返回一个map集合类
     */
    @MapKey("id")
    Map<Integer, Book> getBookByCategory(int cid);

    /**
     * 通过关键字查询
     *
     * @param keywords 关键字
     * @return Book
     */
    List<Book> searchByKeywords(@Param("keywords") String keywords);

    /**
     * 通过Id查询
     *
     * @param id id
     * @return BookVO
     */
    BookVO getBookById(int id);

    /**
     *
     * 更新
     * @param bookVO 一个包含书籍以及分类的对象
     *
     */
    void updateBookVO(BookVO bookVO);

}
