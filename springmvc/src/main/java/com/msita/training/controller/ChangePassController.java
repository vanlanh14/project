package com.msita.training.controller;

import com.msita.training.entity.User;
import com.msita.training.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/changepass")
public class ChangePassController extends javax.servlet.http.HttpServlet{

    @Autowired
    private LoginService loginService;


    @RequestMapping(method = RequestMethod.GET)
    public String goToFormupdate() {

        return "changepass";
    }

    @RequestMapping(value="/authenticate",method=RequestMethod.POST)
    public String updates(@RequestParam("curent_password")String pass,
                            @RequestParam("new_password") String n_pass,
                          @RequestParam("confirm_password") String c_pass,HttpServletRequest request) throws ServletException, IOException {

        String username = (String) request.getSession().getAttribute("username");
        String password = (String) request.getSession().getAttribute("pass");
        String page = "home-page";
        if (password == pass) {
            if (n_pass.equals(c_pass)) {

                loginService.updates(n_pass, username);
                page = "home";
            } else {
                page = "changepass";
            }
        }
        else{
            page = "changepass";
        }
        return "redirect:/" + page;
    }

}