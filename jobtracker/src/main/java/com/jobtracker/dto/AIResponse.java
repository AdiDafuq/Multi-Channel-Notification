package com.jobtracker.dto;

public class AIResponse {

    private String result;

    // ✅ No-arg constructor (needed by Spring)
    public AIResponse() {}

    // ✅ THIS is what you're missing
    public AIResponse(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}