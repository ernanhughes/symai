package programmer.ie.service;

import org.springframework.stereotype.Service;
import programmer.ie.factory.LLMProvider;
import programmer.ie.producer.LLMRequestProducer;

import java.util.List;

@Service
public class LLMCoordinatorService {
    private final LLMRequestProducer producer;
    private final List<LLMProvider> providers;

    public LLMCoordinatorService(LLMRequestProducer producer, List<LLMProvider> providers) {
        this.producer = producer;
        this.providers = providers;
    }

    public void processRequest(String prompt) {
        for (LLMProvider provider : providers) {
            String response = provider.callModel(prompt);
            producer.sendRequest(response);
        }
    }
}
