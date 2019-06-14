package com.lick.controller;

import com.lick.aspect.lang.annotation.Log;
import com.lick.domain.OperateLog;
import com.lick.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/oper/")
public class OperateLogController {

    @Autowired
    private OperateLogService operateLogService;

   @GetMapping(value = "/list")
    public String find(ModelMap map) {
       List<OperateLog> allOperateLog = operateLogService.findAllOperateLog();
       map.put("list",allOperateLog);
       return "operateLogList";
   }
}
