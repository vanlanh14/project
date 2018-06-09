package com.msita.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/logout")
public class LogoutController {
    @RequestMapping(method=RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse repo) {
        String page= "changePassword-page";

        request.getSession().removeAttribute("username");
        request.getSession().removeAttribute("cart");
        page = "choses";

        return "redirect:/"+page;
    }
}
