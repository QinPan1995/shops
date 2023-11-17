package com.project.shops;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShopsApplicationTests {
    @Autowired
    MailService mailService;
    @Test
    void contextLoads() {
        System.out.println("hellowrld");
    }
    @Test
    public void getSyS(){
        System.out.println("test");
        //mailService.sendAttachmentMail("1919796303@qq.com","测试邮件","20200331","D:/image/qqq.pdf");
    }

}
