package com.ringo.mpdemo.conf;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author ringo
 * @version 1.0
 * @date 2020/8/19 15:40
 */
@Configuration
@MapperScan("com.ringo.mpdemo.mapper")
public class MpConfig {
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() { // 乐观锁插件
        return new OptimisticLockerInterceptor();
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() { // 分页插件
        return new PaginationInterceptor();
    }

    @Bean
    public ISqlInjector sqlInjector() { // 逻辑删除插件
        return new LogicSqlInjector();
    }

    @Bean
    @Profile({"dev","test"})// 设置 dev test 环境开启
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setMaxTime(200);//ms，超过此处设置的ms则sql不执行
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }
}
