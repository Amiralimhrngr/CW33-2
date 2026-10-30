package com.hello.controller;

import com.hello.service.GreetingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import java.util.Optional;

public class GreetingController implements Controller {
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
        System.out.println("[CHILD] GreetingController created");
    }
//    Puts the greeting in the model under "message"
//    o
//    Puts the visit count in the model under "visits"
//    o
//    Returns ModelAndView("greeting")
    @Override
    public @Nullable ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        Integer visits = (Integer) session.getAttribute("visits");

        if (Optional.ofNullable(visits).isEmpty()) {
            visits = 1;
        } else {
            visits ++;
        }
        session.setAttribute("visits", visits);
        ModelAndView modelAndView = new ModelAndView("greeting");
        modelAndView.addObject("message", greetingService.getGreeting());
        modelAndView.addObject("visits", visits);
        return modelAndView;
    }
}
