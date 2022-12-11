package com.adrainty.controller;

import com.adrainty.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>TODO</p>
 *
 * @author AdRainty
 * @version V1.0.0
 * @date 2022/12/10 23:21
 */
@RestController
@RequestMapping("category")
public class CategoryController {
    @GetMapping("")
    public R getCategory(){
        return R.ok().put("hello", "hello");
    }
}
