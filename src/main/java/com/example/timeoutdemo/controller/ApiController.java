package com.example.timeoutdemo.controller;

import com.example.timeoutdemo.dto.DelayRequest;
import com.example.timeoutdemo.dto.DoubleRequest;
import com.example.timeoutdemo.dto.DoubleResponse;
import com.example.timeoutdemo.dto.TimeoutRequest;
import com.example.timeoutdemo.exception.TimeoutException;
import com.example.timeoutdemo.service.CalculationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class ApiController {
    
    private final CalculationService calculationService;

    public ApiController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @PostMapping("/double")
    public ResponseEntity<DoubleResponse> doubleNumber(@Valid @RequestBody DoubleRequest request) {
        DoubleResponse response = calculationService.doubleNumber(request.getNumber());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/delay")
    public ResponseEntity<Map<String, Object>> setDelay(@Valid @RequestBody DelayRequest request) {
        calculationService.setDelay(request.getMilliseconds());
        
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Delay set successfully");
        response.put("delayMilliseconds", request.getMilliseconds());
        
        return ResponseEntity.ok(response);
    }

    @PutMapping("/timeout")
    public ResponseEntity<Map<String, Object>> setTimeout(@Valid @RequestBody TimeoutRequest request) {
        calculationService.setTimeout(request.getMilliseconds());
        
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Timeout set successfully");
        response.put("timeoutMilliseconds", request.getMilliseconds());
        
        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(TimeoutException.class)
    public ResponseEntity<Map<String, Object>> handleTimeoutException(TimeoutException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("error", "Timeout");
        error.put("message", ex.getMessage());
        error.put("status", 500);
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("error", "Internal Server Error");
        error.put("message", ex.getMessage());
        error.put("status", 500);
        
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
