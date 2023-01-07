package com.adrainty.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author AdRainty
 * @version V1.0.0
 * @date 2023/1/7 22:08
 */
@TableName("blog_chat")
@Data
public class ChatEntity {
    @TableId
    private Long chatId;

    private String chatName;

    private Long chatTo;

    private Date chatTime;

    private String chatMessage;

    private Long chatComment;

    private Long chatAgree;
}
