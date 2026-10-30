package com.hello.service;

import java.util.List;
import java.util.Random;

public class GreetingService {
    private static final List<String> greetings = List.of("Hello", "Salam", "Saghol");
    private final Random rnd = new Random();

    public GreetingService() {
        System.out.println("[ROOT] GreetingService created");
    }

    public String getGreeting() {
        return greetings.get(rnd.nextInt(greetings.size()));
    }
}
