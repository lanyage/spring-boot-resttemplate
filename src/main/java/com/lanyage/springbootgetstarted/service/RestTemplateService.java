package com.lanyage.springbootgetstarted.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lanyage.springbootgetstarted.bean.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class RestTemplateService {

    // GET
    public ResponseEntity<String> getUserList() {
        RestTemplate restTemplate = new RestTemplate();
        String requestUrl = "http://localhost:8080/users";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(requestUrl, String.class);
        return responseEntity;
    }

    // POST
    public Object postTest() {
        RestTemplate restTemplate = new RestTemplate();
        String requestUrl = "http://localhost:8080/users";

        User user = new User();
        user.setUsername("lisi");
        user.setPassword("lisi");

        HttpEntity<User> request = new HttpEntity<>(user);
//        Object o = restTemplate.postForObject(requestUrl,request,User.class);
          URI uri = restTemplate.postForLocation(requestUrl, request);
//        return o;
        return uri;
    }
}
