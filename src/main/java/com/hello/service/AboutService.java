package com.hello.service;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AboutService {
    private final GreetingService greetingService;
    private String prefix;

    public AboutService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String aboutText() {
        return prefix + "Today's greeting is: " + greetingService.getGreeting();
    }
}
