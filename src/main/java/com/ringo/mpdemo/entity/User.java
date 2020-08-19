package com.ringo.mpdemo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.sun.deploy.security.ValidationState;
import lombok.Data;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * @author ringo
 * @version 1.0
 * @date 2020/8/19 11:03
 */
@Data
public class User {
    @TableId(type= IdType.AUTO) // 主键自增
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    @TableField(fill = FieldFill.INSERT)
    private int version;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private int deleted;
}
