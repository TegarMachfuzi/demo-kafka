package com.kafka_demo.demo_kafka.service;

import com.kafka_demo.demo_kafka.dto.ResponseModel;
import com.kafka_demo.demo_kafka.dto.KafkaMessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaProducerService implements KafkaService{

    private final SendKafkaService sendKafkaService;

    public KafkaProducerService(SendKafkaService sendKafkaService) {
        this.sendKafkaService = sendKafkaService;
    }

    @Override
    public ResponseEntity<ResponseModel> sendKafka(KafkaMessageDto sec) {
        ResponseModel res = new ResponseModel();
        try {
            KafkaMessageDto kafkaMessageDto = new KafkaMessageDto();
            kafkaMessageDto.setMessage(sec.getMessage());
            sendKafkaService.pubCreateOrderSendKafka(kafkaMessageDto);
            res.setResponseCode("00");
            res.setResponseMessage("success");
            res.setData(sec.getMessage());
            return ResponseEntity.ok(res);
        }catch (Exception e){
            System.out.println("gagal kirim");
        }
        return null;
    }
}
