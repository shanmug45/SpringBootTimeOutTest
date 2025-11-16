package com.example.timeoutdemo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class TimeoutRequest {
    
    @NotNull(message = "Milliseconds is required")
    @Min(value = 0, message = "Milliseconds must be non-negative")
    private Long milliseconds;

    public TimeoutRequest() {
    }

    public TimeoutRequest(Long milliseconds) {
        this.milliseconds = milliseconds;
    }

    public Long getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(Long milliseconds) {
        this.milliseconds = milliseconds;
    }
}
