package com.zyg.controller;

import com.zyg.domain.Account;
import com.zyg.service.IAccountService;
import com.zyg.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/3/25 16:15
 * web层
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;
    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("表现层查询信息");
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "list";

    }
    @RequestMapping("/save")
    public String save(Account account){
        accountService.save(account);
        return "list";
    }

}
