package programmer.ie.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class LLMRequestProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${llm.topic.request}")
    private String requestTopic;

    public LLMRequestProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendRequest(String request) {
        kafkaTemplate.send(requestTopic, request);
    }
}
