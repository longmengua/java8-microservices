package com.example.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.AbstractMap;
import java.util.HashMap;

@RestController
@RefreshScope
public class Home {
    @Value("${message:Hello default}")
    private String message;

    private HashMap<String, String> map;

    @RequestMapping("/")
    public AbstractMap<? extends String, ? extends String> getMessage() {
        if (map == null) {
            map = new HashMap<>();
            map.put("server-name", this.message);
            map.put("status", "ok");
        }
        return map;
    }
}
