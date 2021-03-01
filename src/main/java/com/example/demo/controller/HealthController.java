package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Saurabh
 * @version 1.0, 28/02/21
 */
@RestController
public class HealthController {

    @GetMapping("/health")
    public String health() {
        return "success";
    }
}
