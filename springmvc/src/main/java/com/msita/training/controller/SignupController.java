package com.msita.training.controller;

import com.msita.training.dao.LoginDAO;
import com.msita.training.entity.User;
import com.msita.training.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(method = RequestMethod.GET)
    public String goToFormLogin() {
        return "signup";
    }

    @RequestMapping(value="/authenticate",method=RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam("fullname") String fullname,
                        @RequestParam("confirm_password")String c_pass)  {
        String page= "changePassword-page";
        if (password.equals(c_pass)) {
                loginService.save(username, c_pass, fullname);
                page = "login";
            }
             else {
                page = "error";
            }
        return "redirect:/"+page;
    }
}
