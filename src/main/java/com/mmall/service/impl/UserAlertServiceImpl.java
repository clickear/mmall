package com.mmall.service.impl;

import com.mmall.pojo.User;
import com.mmall.service.IUserAlertService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by Administrator on 2017/9/19.
 */

@Service("iUserAlertService")
public class UserAlertServiceImpl implements IUserAlertService {

    @Autowired
    private RabbitTemplate rabbit;

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Override
    public void sendEmailToUserQueue(User user) {
        //convertAndSend(String exchange, String routingKey, Object object), 将对象object封装成Message对象后, 发送给exchange
        this.rabbit.convertAndSend("user.alert.email.exchange", "user.alerts.email", user);
    }

    @Override
    public void sendEmailToUser(User user) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
        helper.setFrom("clickear@163.com");
        helper.setTo("chen.ruo.chen@163.com");
        helper.setSubject("请激活帐号,完成注册.");
        String text = "<html><body><h4>亲爱的" + user.getUsername() + ": </h4><br /><p>请点击下面的链接激活帐号: </p><br />"
                + "<a href=\"http://localhost:8989/register?confirm=" + user.getEmail() + "\">"
                + "http://localhost:8989/register?confirm=" + user.getEmail() + "</a><br /></body></html>";
        helper.setText(text, true);
        mailSender.send(message);
    }
}
