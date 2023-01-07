package com.adrainty.service.impl;

import com.adrainty.dao.CategoryDao;
import com.adrainty.entity.CategoryEntity;
import com.adrainty.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>TODO</p>
 *
 * @author AdRainty
 * @version V1.0.0
 * @date 2022/12/10 23:23
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {
}
