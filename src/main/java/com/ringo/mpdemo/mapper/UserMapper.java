package com.ringo.mpdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ringo.mpdemo.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author ringo
 * @version 1.0
 * @date 2020/8/19 11:12
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
