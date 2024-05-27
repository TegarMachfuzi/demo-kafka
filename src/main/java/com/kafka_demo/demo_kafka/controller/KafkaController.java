package com.kafka_demo.demo_kafka.controller;

import com.kafka_demo.demo_kafka.dto.ResponseModel;
import com.kafka_demo.demo_kafka.dto.KafkaMessageDto;
import com.kafka_demo.demo_kafka.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/kafka")
    public ResponseEntity<ResponseModel> sendKafka(@RequestBody KafkaMessageDto kafkaMessageDto) {
        return kafkaService.sendKafka(kafkaMessageDto);
    }

}
