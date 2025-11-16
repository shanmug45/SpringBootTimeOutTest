package com.example.timeoutdemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DoubleResponse {
    
    @JsonProperty("Input")
    private Integer input;
    
    @JsonProperty("result")
    private Integer result;
    
    @JsonProperty("delay")
    private Long delay;
    
    @JsonProperty("timeout")
    private Long timeout;
    
    @JsonProperty("actualDuration")
    private Long actualDuration;
    
    @JsonProperty("timestamp")
    private String timestamp;

    public DoubleResponse() {
    }

    public DoubleResponse(Integer input, Integer result, Long delay, Long timeout, Long actualDuration, String timestamp) {
        this.input = input;
        this.result = result;
        this.delay = delay;
        this.timeout = timeout;
        this.actualDuration = actualDuration;
        this.timestamp = timestamp;
    }

    public Integer getInput() {
        return input;
    }

    public void setInput(Integer input) {
        this.input = input;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Long getDelay() {
        return delay;
    }

    public void setDelay(Long delay) {
        this.delay = delay;
    }

    public Long getTimeout() {
        return timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    public Long getActualDuration() {
        return actualDuration;
    }

    public void setActualDuration(Long actualDuration) {
        this.actualDuration = actualDuration;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
