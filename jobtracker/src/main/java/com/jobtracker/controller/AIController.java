package com.jobtracker.controller;

import com.jobtracker.dto.AIRequest;
import com.jobtracker.dto.AIResponse;
import com.jobtracker.service.AIService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
public class AIController {

    private final AIService aiService;

    public AIController(AIService aiService) {
        this.aiService = aiService;
    }

    // 🔹 Summarize Job
    @PostMapping("/summarize")
    public AIResponse summarize(@RequestBody AIRequest request) {
        return aiService.summarizeJob(request.getPrompt());
    }

    // 🔹 Generate Cover Letter
    @PostMapping("/cover-letter")
    public AIResponse coverLetter(@RequestParam String job,
                                 @RequestParam String profile) {
        return aiService.generateCoverLetter(job, profile);
    }
}