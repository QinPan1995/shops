package com.project.shops;

import com.project.shops.service.IUserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ：luke
 * @date ：Created in 2023/11/28 10:37 AM
 * @description：
 * @modified By：
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShopsApplication.class)
public class ShopsApplicationTest {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private IUserService iUserService;

    //测试方法
}
