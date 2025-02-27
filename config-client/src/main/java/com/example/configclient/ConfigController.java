package com.example.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${my.config.message}")
    private String configMessage;

    @GetMapping("/message")
    public String getConfigMessage() {
        return "현재 설정 값: " + configMessage;
    }
}
