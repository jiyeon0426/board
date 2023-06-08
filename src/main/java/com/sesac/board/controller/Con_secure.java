package com.sesac.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/secure")
public class Con_secure {

    @GetMapping("/login")
    public String doSecureLogin(@RequestParam(value="message", defaultValue = "default", required = false) String strMsg, Model model) {
        System.out.println("doSecureLogin : " +strMsg);
        model.addAttribute("message", strMsg);

        return "/secure/loginSecure";
    }
}
