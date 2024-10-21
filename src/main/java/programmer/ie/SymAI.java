package programmer.ie;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import programmer.ie.service.LLMCoordinatorService;

import java.util.Scanner;

@SpringBootApplication
@ComponentScan("programmer.ie")
public class SymAI implements CommandLineRunner {

    private final LLMCoordinatorService llmCoordinatorService;

    public SymAI(LLMCoordinatorService llmCoordinatorService) {
        this.llmCoordinatorService = llmCoordinatorService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SymAI.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter prompt (or type 'exit' to quit):");

        while (true) {
            String prompt = scanner.nextLine();
            if (prompt.equalsIgnoreCase("exit")) {
                break;
            }
            llmCoordinatorService.processRequest(prompt);
        }

        System.out.println("Application exited.");
    }
}