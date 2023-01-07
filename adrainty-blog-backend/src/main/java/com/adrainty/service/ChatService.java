package com.adrainty.service;

import com.adrainty.entity.ChatEntity;
import com.adrainty.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>TODO</p>
 *
 * @author AdRainty
 * @version V1.0.0
 * @date 2023/1/7 22:07
 */
public interface ChatService extends IService<ChatEntity> {
    PageUtils queryPage(Map<String, Object> params);

    PageUtils getChatTo(Map<String, Object> params);
}
