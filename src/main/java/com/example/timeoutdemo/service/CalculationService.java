package com.example.timeoutdemo.service;

import com.example.timeoutdemo.dto.DoubleResponse;
import com.example.timeoutdemo.exception.TimeoutException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class CalculationService {
    
    private long delayMilliseconds = 0;
    private long timeoutMilliseconds = 5000; // Default 5 seconds
    
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSS");

    public DoubleResponse doubleNumber(Integer number) {
        long startTime = System.currentTimeMillis();
        
        // Check if operation will timeout
        if (delayMilliseconds > timeoutMilliseconds) {
            throw new TimeoutException("Operation timed out after " + timeoutMilliseconds + " milliseconds");
        }
        
        // Simulate delay
        if (delayMilliseconds > 0) {
            try {
                Thread.sleep(delayMilliseconds);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Operation interrupted", e);
            }
        }
        
        long endTime = System.currentTimeMillis();
        long actualDuration = endTime - startTime;
        
        // Calculate result
        Integer result = number * 2;
        
        // Create response
        String timestamp = LocalDateTime.now().format(FORMATTER);
        
        return new DoubleResponse(
            number,
            result,
            delayMilliseconds,
            timeoutMilliseconds,
            actualDuration,
            timestamp
        );
    }

    public void setDelay(Long milliseconds) {
        this.delayMilliseconds = milliseconds;
    }

    public void setTimeout(Long milliseconds) {
        this.timeoutMilliseconds = milliseconds;
    }

    public long getDelay() {
        return delayMilliseconds;
    }

    public long getTimeout() {
        return timeoutMilliseconds;
    }
}
