package com.example.timeoutdemo.dto;

import jakarta.validation.constraints.NotNull;

public class DoubleRequest {
    
    @NotNull(message = "Number is required")
    private Integer number;

    public DoubleRequest() {
    }

    public DoubleRequest(Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
