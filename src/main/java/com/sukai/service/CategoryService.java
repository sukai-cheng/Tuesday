package com.sukai.service;

import com.sukai.mapper.CategoryMapper;
import com.sukai.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chengsukai
 */
@Service
public class CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    public List<Category> list() {
        return categoryMapper.selectList(null);
    }


}
