package org.demo.brower.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageControl {

    @GetMapping(value = "/home")
    public String getHomePage(HttpServletRequest request) {
        return "home";
    }

}
