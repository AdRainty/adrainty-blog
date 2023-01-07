package com.adrainty.dao;

import com.adrainty.entity.ChatEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>TODO</p>
 *
 * @author AdRainty
 * @version V1.0.0
 * @date 2023/1/7 22:10
 */
@Mapper
public interface ChatDao extends BaseMapper<ChatEntity> {
}
