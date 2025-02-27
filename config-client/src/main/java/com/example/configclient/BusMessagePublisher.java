package com.example.configclient;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bus")
public class BusMessagePublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static final String EXCHANGE_NAME = "springCloudBus"; // Spring Cloud Bus 기본 Exchange

    @PostMapping("/manual-refresh")
    public String sendManualRefresh(@RequestParam String originService) {
        String routingKey = "springCloudBus";  // Spring Cloud Bus 기본 라우팅 키
        String message = "{\"type\":\"RefreshRemoteApplicationEvent\",\"originService\":\"" + originService + "\"}";

        System.out.println("설정 변경 메시지 발행: " + message);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, routingKey, message);  // 메시지 전송

        return "RabbitMQ 메시지 발행 완료: " + message;
    }
}
