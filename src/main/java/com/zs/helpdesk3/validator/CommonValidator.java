package com.zs.helpdesk3.validator;

import org.springframework.stereotype.Component;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

@Component
public class CommonValidator {

    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
}
