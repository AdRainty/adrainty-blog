package com.adrainty.dao;

import com.adrainty.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>TODO</p>
 *
 * @author AdRainty
 * @version V1.0.0
 * @date 2022/12/10 23:19
 */
@Mapper
public interface CategoryDao extends BaseMapper<Category> {
}
