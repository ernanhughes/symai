package programmer.ie.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class LLMResponseConsumer {
    @KafkaListener(topics = "${llm.topic.response}", groupId = "my-llm-group")
    public void consumeResponse(String response) {
        System.out.println("Received response: " + response);
    }
}
