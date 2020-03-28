package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {

    private static final Pattern PHONE_NUMBER_PATERN = Pattern.compile("^\\+(?:[0-9] ?){6,14}[0-9]$");

    public boolean numberCheck(String phoneNumber) {

        Matcher phoneNumberToMatch = PHONE_NUMBER_PATERN.matcher(phoneNumber);

        return (phoneNumberToMatch.find() && phoneNumberToMatch.group().equals(phoneNumber));
    }
}