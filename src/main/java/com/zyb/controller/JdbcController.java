package com.zyb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("/list")
    public List<Map<String,Object>> userList(){
        String sql = "select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @GetMapping("/add")
    public String addUser(){
        String sql = "insert into mybatis.user(id,name,psw) values (6,'kk','123456')";
        jdbcTemplate.update(sql);
        return "adduser";
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Integer id){
        String sql = "update mybatis.user set name = ?,psw = ? where id = "+id;
        Object[] objects = new Object[2];
        objects[0] = "mm";
        objects[1] = "a12345";
        jdbcTemplate.update(sql,objects);
        return "updateUser";
    }
    @GetMapping("/del/{id}")
    public String delUser(@PathVariable("id") Integer id){
        String sql = "delete from user where id = "+id;
        jdbcTemplate.update(sql);
        return "delUser";
    }
}
