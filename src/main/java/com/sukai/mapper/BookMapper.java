package com.sukai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
     * @param cid 分类ID
     * @return 返回一个map集合类
     */
    @MapKey("id")
    Map<Integer, Book> getBookByCategory(int cid);

    List<Book> searchByKeywords(@Param("keywords") String keywords);
}
