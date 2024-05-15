package com.kyljmeeski.voicecallapplication.service;

public interface TwilioService {
    void makeCall(String toPhoneNumber, String messageUrl);
}
