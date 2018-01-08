package com.mmall.service.impl;

import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.com.mmall.service.impl.AbstractContextControllerTests;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.mmall.common.ServerResponse;
import com.mmall.service.IUserAlertService;
import com.mmall.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by Administrator on 2017/7/11.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServiceImplTest  extends AbstractJUnit4SpringContextTests {

    @Autowired
    private IUserService iUserService;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
    }

    @Test
    public void responseBody() throws Exception {

        ServerResponse userInfo  = iUserService.getInformation(1);
        System.out.printf(userInfo.toString());

//        this.mockMvc.perform(
//                post("/user/get_user_info.do")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{ \"foo\": \"bar\", \"fruit\": \"apple\" }".getBytes()))
//                .andExpect(content().string(startsWith("Mapped by path + method + consumable media type (javaBean")));
    }


}