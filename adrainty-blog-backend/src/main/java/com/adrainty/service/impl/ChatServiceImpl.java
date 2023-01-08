package com.adrainty.service.impl;

import com.adrainty.dao.ChatDao;
import com.adrainty.entity.ChatEntity;
import com.adrainty.service.ChatService;
import com.adrainty.utils.PageUtils;
import com.adrainty.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>TODO</p>
 *
 * @author AdRainty
 * @version V1.0.0
 * @date 2023/1/7 22:10
 */
@Service
public class ChatServiceImpl extends ServiceImpl<ChatDao, ChatEntity> implements ChatService {
    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        String key = (String)params.get("key");

        IPage<ChatEntity> page = this.page(
                new Query<ChatEntity>().getPage(params),
                new QueryWrapper<ChatEntity>().eq("chat_to", 0)
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils getChatTo(Map<String, Object> params) {
        IPage<ChatEntity> page = this.page(
                new Query<ChatEntity>().getPage(params),
                new QueryWrapper<ChatEntity>().eq("chat_to", params.get("chatTo"))
        );

        return new PageUtils(page);
    }
}
