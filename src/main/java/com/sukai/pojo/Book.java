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
@TableName(value = "book")
public class Book {

    int id;

    int cid;

    String cover;

    String title;

    String author;

    String date;

    String press;

    String abs;

}
