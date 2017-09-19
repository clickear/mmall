package com.mmall.util;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

/**
 * Created by Administrator on 2017/9/19.
 */
public class MailUtil {

    public static void main(String[] args) throws MessagingException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取JavaMailSender bean
        JavaMailSenderImpl sender = (JavaMailSenderImpl) ctx.getBean("mailSender");
        VelocityEngine velocityEngine = (VelocityEngine) ctx.getBean("velocityEngine");

        MimeMessage mailMessage = sender.createMimeMessage();
        //设置utf-8或GBK编码，否则邮件会有乱码
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");
        try {
            messageHelper.setTo("chen.ruo.chen@163.com");//接受者
            messageHelper.setFrom(sender.getUsername());//发送者
            messageHelper.setSubject("测试邮件");//主题
            //邮件内容，注意加参数true

            String text = VelocityEngineUtils.mergeTemplateIntoString(
                    velocityEngine, "template/post.vm", "UTF-8", null);

            messageHelper.setText(text, true);
            //附件内容
//            messageHelper.addInline("a", new File("E:/xiezi.jpg"));
//            messageHelper.addInline("b", new File("E:/logo.png"));
          //  File file = new File("E:/测试中文文件.rar");
            // 这里的方法调用和插入图片是不同的，使用MimeUtility.encodeWord()来解决附件名称的中文问题
//            messageHelper.addAttachment(MimeUtility.encodeWord(file.getName()), file);
            sender.send(mailMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
