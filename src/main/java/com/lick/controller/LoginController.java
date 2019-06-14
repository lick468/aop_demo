package com.lick.controller;

import com.lick.domain.User;
import com.lick.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }
    @PostMapping(value = "/login")
    public String login(User user, HttpSession session, RedirectAttributes redirectAttributes) {
        User currentUser = userService.findUserByUsername(user.getUsername());
        if(currentUser.getPassword().equals(user.getPassword())) {
            session.setAttribute("currentUser",currentUser);
             return "index";
        }
        redirectAttributes.addFlashAttribute("message","用户名或密码错误");
        return "redirect:/login";

    }
}
