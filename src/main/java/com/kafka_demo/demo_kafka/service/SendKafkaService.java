package com.kafka_demo.demo_kafka.service;
import com.kafka_demo.demo_kafka.dto.KafkaMessageDto;
import com.kafka_demo.demo_kafka.utils.JsonUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class SendKafkaService {
    private final Logger logger = LogManager.getLogger(SendKafkaService.class);

    private final KafkaTemplate<String, KafkaMessageDto> createOrderSendKafka;

    @Value("${kafka.topic}")
    private String kafkaTopic;

    @Autowired
    public SendKafkaService(KafkaTemplate<String, KafkaMessageDto> createOrderSendKafka) {
        this.createOrderSendKafka = createOrderSendKafka;
    }

    public void pubCreateOrderSendKafka(KafkaMessageDto secretMessageDto) {
        try {
            SendResult<String, KafkaMessageDto> sendResult = createOrderSendKafka.send(kafkaTopic, secretMessageDto).get();
            logger.info("success send message topic: {} -> result: {}", JsonUtils.toJson(secretMessageDto), sendResult.toString());

        }catch (Exception e){

        }
    }
}
