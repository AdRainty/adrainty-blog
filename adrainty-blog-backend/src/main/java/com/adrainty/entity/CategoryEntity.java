package com.adrainty.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * <p>TODO</p>
 *
 * @author AdRainty
 * @version V1.0.0
 * @date 2022/12/10 23:20
 */
@Data
@TableName("blog_category")
public class CategoryEntity {

    @TableId
    private Long catId;

    private String catName;

    private Integer catCount;


}
