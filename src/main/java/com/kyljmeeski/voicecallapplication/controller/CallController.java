package com.kyljmeeski.voicecallapplication.controller;

import com.kyljmeeski.voicecallapplication.service.TwilioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/call")
public class CallController {
    private final TwilioService twilioService;

    public CallController(TwilioService twilioService) {
        this.twilioService = twilioService;
    }

    @PostMapping
    public String makeCall(@RequestParam String to, @RequestParam String message) {
        twilioService.makeCall(to, message);
        return "Call initiated";
    }
}
