package com.ringo.mpdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ringo.mpdemo.entity.User;
import com.ringo.mpdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.jws.soap.SOAPBinding;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class MpdemoApplicationTests {

    // 引入Mapper
    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setName("sam");
        user.setAge(25);
        user.setEmail("sam@gamil.com");

        int insert = userMapper.insert(user);
        System.out.println("插入了[" + insert + "]条记录");
    }

    @Test
    public void updateUser(){
        Long id = 1295948336527335428L;

        User user = new User();
        user.setId(id);

        int updateNum = userMapper.updateById(user);
        System.out.println("更新了[" +updateNum+"]条记录");

    }

    @Test
    public void selectAndUpdateUser(){
        User user = userMapper.selectById(1295948336527335428L);
        user.setAge(110);

        int updateNum = userMapper.updateById(user);
        System.out.println("更新了[" +updateNum+"]条记录");

    }

    @Test
    public void testSelectPage(){
        // 创建page对象
        Page<User> page = new Page<>(1, 3);
        // 调用Mp的分页查询方法，把分页所有数据封装到page对象里面
        userMapper.selectPage(page, null);

        //通过page对象获取分页数据
        System.out.println(page.getCurrent());//当前页
        System.out.println(page.getRecords());//每页数据list集合
        System.out.println(page.getSize());//每页显示记录数
        System.out.println(page.getTotal()); //总记录数
        System.out.println(page.getPages()); //总页数

        System.out.println(page.hasNext()); //下一页
        System.out.println(page.hasPrevious()); //上一页
    }

    @Test
    public void testDeleteUser(){
        userMapper.deleteById(4L);
    }

    @Test
    public void testSelectAllUsers(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void testQueryWrapper(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
//        userQueryWrapper.le("id",3L);
        userQueryWrapper.between("age", 20, 30);
        List<User> users = userMapper.selectList(userQueryWrapper);
        System.out.println(users);
    }

}
