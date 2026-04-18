package com.jobtracker.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.jobtracker.dto.AIResponse;

@Service
public class AIService 
{

    private final WebClient webClient;

@Value("${openai.api.key}")
private String API_KEY;
    public AIService(WebClient.Builder builder) {
        this.webClient = builder
                .baseUrl("https://api.openai.com/v1")
                .build();
    }

    // 🔹 Summarize Job Description
    public AIResponse summarizeJob(String jobDescription) {

        String prompt = "Summarize this job description in 5 bullet points:\n" + jobDescription;

        String response = callAI(prompt);

        return new AIResponse(response);
    }

    // 🔹 Generate Cover Letter
    public AIResponse generateCoverLetter(String jobDescription, String userProfile) {

        String prompt = "Write a professional cover letter based on:\n"
                + "Job:\n" + jobDescription + "\n\n"
                + "Candidate:\n" + userProfile;

        String response = callAI(prompt);

        return new AIResponse(response);
    }

    // 🔥 Core API Call
    private String callAI(String prompt) 
    {

        Map<String, Object> requestBody = Map.of(
                "model", "gpt-4o-mini",
                "messages", new Object[]
                {
                        Map.of("role", "user", "content", prompt)
                }
        );

        Map response = webClient.post()
                .uri("/chat/completions")
                .header("Authorization", "Bearer " + API_KEY)
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        // extract text
        try {
    return (String) ((Map)((Map)((java.util.List)response.get("choices")).get(0))
            .get("message")).get("content");
} catch (Exception e) {
    e.printStackTrace();
    return "Error: Unable to parse AI response";
}
    }
}