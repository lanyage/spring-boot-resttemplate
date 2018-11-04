package com.lanyage.springbootgetstarted.service;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lanyage.springbootgetstarted.bean.User;
import com.lanyage.springbootgetstarted.service.RestTemplateService;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTemplateServiceTest {

    @Autowired
    private RestTemplateService templateService;

    @Test
    public void getUserList() throws IOException {
        ResponseEntity<String> entity = templateService.getUserList();
        System.out.println(entity.getStatusCode());
        System.out.println(entity.getStatusCodeValue());
        System.out.println(entity.getBody());
        System.out.println(entity.getHeaders());

        ObjectMapper om = new ObjectMapper();
        List<User> users = om.readValue(entity.getBody(), new TypeReference<List<User>>() {
        });

//        Object o = JSON.parseArray(entity.getBody(), User.class);
//        if(o instanceof List) {
//        List<User> users = (List<User>)o;
        for (User user : users) {
            System.out.println(user);
        }
//        }
    }

    @Test
    public void testPost() {
        Object o = templateService.postTest();
        System.out.println(o);
    }


}