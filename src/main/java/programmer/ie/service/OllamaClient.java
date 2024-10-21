package programmer.ie.service;

import org.springframework.stereotype.Service;
import programmer.ie.factory.LLMProvider;

@Service
public class OllamaClient implements LLMProvider {
    @Override
    public String callModel(String prompt) {
        // Code to make HTTP request to OpenAI's API
        return "OpenAI response for: " + prompt;
    }
}
