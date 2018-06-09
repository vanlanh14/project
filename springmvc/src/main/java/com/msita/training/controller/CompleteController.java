package com.msita.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/complete")
public class CompleteController {
    @RequestMapping(method = RequestMethod.GET)
    public String gotoComplete(){
        return "complete";
    }
}
