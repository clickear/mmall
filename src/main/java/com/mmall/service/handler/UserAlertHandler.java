package com.mmall.service.handler;

import com.mmall.pojo.User;
import com.mmall.service.IUserAlertService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.MessagingException;

/**
 * Created by Administrator on 2017/9/19.
 */
public class UserAlertHandler {

    @Autowired
    private IUserAlertService iUserAlertService;

    public void handleUserAlertToEmail(User user) {
        System.out.println(user);
        try {
            iUserAlertService.sendEmailToUser(user);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
