package com.kafka_demo.demo_kafka.service;

import com.kafka_demo.demo_kafka.dto.ResponseModel;
import com.kafka_demo.demo_kafka.dto.KafkaMessageDto;
import org.springframework.http.ResponseEntity;

public interface KafkaService {
    ResponseEntity<ResponseModel> sendKafka(KafkaMessageDto kafkaMessageDto);
}
