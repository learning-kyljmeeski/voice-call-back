package com.kyljmeeski.voicecallapplication.service.impl;

import com.kyljmeeski.voicecallapplication.service.TwilioService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
import com.twilio.type.Twiml;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioServiceImpl implements TwilioService {
    private String accountSid;
    private String authToken;
    private String fromPhoneNumber;

    public TwilioServiceImpl(
            @Value("${twilio.account.sid}") String accountSid,
            @Value("${twilio.auth.token}") String authToken,
            @Value("${twilio.phone.number}") String fromPhoneNumber
    ) {
        Twilio.init(accountSid, authToken);
    }

    @Override
    public void makeCall(String toPhoneNumber, String messageUrl) {
        Call call = Call.creator(
                new PhoneNumber(toPhoneNumber),
                new PhoneNumber(fromPhoneNumber),
                new Twiml("<Response><Say>" + messageUrl + "</Say></Response>")
        ).create();
    }
}
