package com.hello.controller;

import com.hello.service.AboutService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import java.util.Optional;

public class AboutController implements Controller {
    private final AboutService aboutService;

    public AboutController(AboutService aboutService) {
        this.aboutService = aboutService;
        System.out.println("[CHILD] AboutController created");
    }

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
        ModelAndView modelAndView = new ModelAndView("about");
        modelAndView.addObject("aboutText", aboutService.aboutText());
        modelAndView.addObject("visits", visits);
        return modelAndView;
    }
}
