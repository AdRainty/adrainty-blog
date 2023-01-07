package com.adrainty.controller;

import com.adrainty.service.ChatService;
import com.adrainty.utils.PageUtils;
import com.adrainty.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>TODO</p>
 *
 * @author AdRainty
 * @version V1.0.0
 * @date 2023/1/7 22:03
 */
@RestController
@RequestMapping("/api/chat")
public class ApiChatController {
    @Autowired
    ChatService chatService;

    @GetMapping("/page")
    public R page(@RequestParam Map<String, Object> params) {
        PageUtils page = chatService.queryPage(params);
        return R.ok().put("page", page);
    }

    @GetMapping("/getChatTo")
    public R getChatTo(@RequestParam Map<String, Object> params) {
        PageUtils page = chatService.getChatTo(params);
        return R.ok().put("page", page);
    }
}
