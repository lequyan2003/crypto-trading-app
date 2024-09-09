package com.mcb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcb.response.ApiResponse;


@RestController
public class HomeController {
    @GetMapping()
    public ResponseEntity<ApiResponse>Home() {
        ApiResponse response = new ApiResponse();
        response.setMessage("Welcome to AI Chatbot");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
