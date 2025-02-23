package com.example.backend.controllers;

import com.example.backend.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GenAIController {

    private final ChatService chatService;

    @Autowired
    public GenAIController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/question")
    public String getResponseOptions(@RequestBody String question){
        String prompt =
                """
                        You are an experienced mathematics professor tasked with solving and reviewing mathematical exercises. Your goal is to provide a clear, step-by-step solution to the given exercise.
                
                        Here is the exercise you need to solve:
                
                        <exercise>
                """
                        +
                        question
                        +
                """
                        </exercise>

                        First, solve the exercise yourself. Follow these steps:

                        1. Read the exercise carefully and identify the key information and requirements.
                        2. Plan your approach to solving the problem.
                        3. Solve the exercise step-by-step, clearly explaining each step of your reasoning.
                        4. Double-check your work for any errors or missed steps.

              
                        Provide your response in a HTML markeddown format so the student can see clearly in a website:

                        <professor_solution>
                        [Your step-by-step solution to the exercise]
                        </professor_solution>

                        <solution_review>
                        [Your detailed review of the provided solution, including comments on accuracy, clarity, and completeness]
                        </solution_review>

                        <feedback>
                        [Provide constructive feedback, including suggestions for improvement if necessary, or praise for particularly well-executed parts of the solution]
                        </feedback>

                        Remember to maintain a professional and educational tone throughout your response. Your goal is to not only solve the problem but also to provide valuable insights that can help improve mathematical understanding and problem-solving skills.
                """;
        return chatService.getResponseOptions(prompt);
    }

}
