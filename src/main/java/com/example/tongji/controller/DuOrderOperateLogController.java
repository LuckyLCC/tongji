package com.example.tongji.controller;

import com.example.tongji.domain.DuOrderOperateLog;
import com.example.tongji.service.DuOrderOperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-08-11  17:14
 */

@RestController
@RequestMapping("/getdata")
public class DuOrderOperateLogController {

    @Autowired
    private DuOrderOperateLogService duOrderOperateLogService;


    @GetMapping("/createNewTable")
    public HashMap<Object, Integer> createNewTable(String[] date){
        HashMap<Object, Integer> newTable = duOrderOperateLogService.createNewTable(date);
        return newTable;
    }
}
