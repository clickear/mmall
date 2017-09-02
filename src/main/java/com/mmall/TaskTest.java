package com.mmall;

import com.mmall.service.impl.JobTaskServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.Date;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/2.
 */
@Component
public class TaskTest {
    private org.slf4j.Logger log = LoggerFactory.getLogger(TaskTest.class);

    public void run() {
        for (int i = 0; i < 1; i++) {
            log.debug(i+" run......................................" + (new Date()));
            System.out.println(i+" run......................................" + (new Date()));
        }

    }

    public void run1() {
        for (int i = 0; i < 1; i++) {
            log.debug(i+" run1......................................" + (new Date()));
            System.out.println(i+" run1......................................" + (new Date()));
        }
    }

    public static void main(String[] args) {
        String c=null;
        Map<String, Charset> charsets = Charset.availableCharsets();
        for (Map.Entry<String, Charset> entry : charsets.entrySet()) {
            System.out.println(entry.getKey());
        }

    }
}