package com.lick.controller;

import com.lick.aspect.lang.annotation.Log;
import com.lick.aspect.lang.enums.BusinessType;
import com.lick.domain.User;
import com.lick.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/add")
    public String add() {
        return "addUser";
    }

    @Log(title="添加用户",businessType = BusinessType.INSERT)
    @PostMapping(value = "/add")
    public String add(User user) {
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());
        userService.insertUser(user);
        return "redirect:/user/list";
    }
    @Log(title="查询用户列表",businessType = BusinessType.LIST)
    @GetMapping(value = "/list")
    public String listUser(ModelMap map) {
        List<User> allUser = userService.findAllUser();
        map.put("userList",allUser);
        return "userList";
    }

}
