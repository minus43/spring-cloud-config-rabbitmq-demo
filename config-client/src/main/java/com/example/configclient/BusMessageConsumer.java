package com.example.configclient;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BusMessageConsumer {

    @Value("${my.config.message}")
    private String configMessage;

    @RabbitListener(queues = "#{autoDeleteQueue.name}") // Spring Cloud Bus의 기본 Queue를 구독
    public void listenBusMessages(String message) {
        System.out.println("RabbitMQ에서 설정 변경 메시지 수신: " + message);
        System.out.println("현재 설정 값: " + configMessage);
    }
}
