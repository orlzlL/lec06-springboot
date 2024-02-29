package com.ohgiraffers.restapi.section02.responseentity;

import org.apache.catalina.User;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/entity")
public class ResponseEntityTestController {

    private List<UserDTO> users;

    public ResponseEntityTestController(List<UserDTO> users){
        this.users = new ArrayList<>();

        users.add(new UserDTO(1, "user01", "pass01", "홍길동", new java.util.Date()));
        users.add(new UserDTO(2, "user02", "pass02", "유관순", new java.util.Date()));
        users.add(new UserDTO(3, "user03", "pass03", "이순신", new java.util.Date()));
    }


    /* 설명. 1. 직접 ResponseEntity 객체 만들기 */
    @GetMapping("/users")
    public ResponseEntity<ResponseMessage> findAllUsers() {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("users", users);

        ResponseMessage responseMessage = new ResponseMessage(200, "조회 성공!" ,responseMap);

        return new ResponseEntity<>(responseMessage, headers, HttpStatus.CREATED);
    }

    /* 설명. 2. 빌더를 활용한 메소드 체이닝 방식으로 ResponseEntity 객체 만들기 (요즘 유행) */
    @GetMapping("/users/{userNo}")
    public ResponseEntity<ResponseMessage> findUserByNo(@PathVariable int userNo){
        
        return ResponseEntity.ok();
    }

}
