package com.project.shops;

import com.project.shops.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

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
