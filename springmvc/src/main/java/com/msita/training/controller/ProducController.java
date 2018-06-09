package com.msita.training.controller;

import com.msita.training.entity.Product;
import com.msita.training.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/productDetail")
public class ProducController {

    @Autowired
    private HomeService homeService;

    @RequestMapping(method = RequestMethod.GET)
    public String product(@RequestParam("id") int id, ModelMap model,HttpServletRequest request)
        {
            model.addAttribute("product",homeService.getProduct(id));
            String username = (String) request.getSession().getAttribute("username");
            if(username!=null) {
                return "productDetail";
            }
            else {
                return "login";
            }

        }
    }

