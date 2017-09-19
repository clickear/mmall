package com.mmall.service;

import com.mmall.pojo.User;

import javax.mail.MessagingException;

/**
 * Created by Administrator on 2017/9/19.
 */
public interface IUserAlertService {
    void sendEmailToUserQueue(User user);

    void sendEmailToUser(User user) throws MessagingException;

}
