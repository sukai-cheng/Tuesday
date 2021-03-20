package com.sukai.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chengsukai
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "category")
public class Category {

    Integer id;

    String name;
}
