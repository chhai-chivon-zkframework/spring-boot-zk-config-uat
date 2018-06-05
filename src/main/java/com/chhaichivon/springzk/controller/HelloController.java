package com.chhaichivon.springzk.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class HelloController {


    @RequestMapping(value = "/list")
    public  Map<String,Object> tt(){
        List<String> list = new ArrayList<>();

        list.add("AA");
        list.add("BB");
        list.add("CC");

        Map<String,Object> map = new HashMap<>();
        map.put("data",list);
        map.put("message","success");
        map.put("code",200);

        return  map;
    }
}
