package com.sukai.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Param;

/**
 * @author chengsukai
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookVO {

    int id;

    int cid;

    String cover;

    String title;

    String author;

    String date;

    String press;

    String abs;

    String category;
}
