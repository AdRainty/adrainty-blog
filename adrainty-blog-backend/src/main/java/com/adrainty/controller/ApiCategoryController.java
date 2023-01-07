package com.adrainty.controller;

import com.adrainty.entity.CategoryEntity;
import com.adrainty.service.CategoryService;
import com.adrainty.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author AdRainty
 * @version V1.0.0
 * @date 2022/12/10 23:21
 */
@RestController
@RequestMapping("/api/category")
public class ApiCategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    public R getCategory(){
        List<CategoryEntity> list = categoryService.list();
        return R.ok().put("categories", list);
    }
}
