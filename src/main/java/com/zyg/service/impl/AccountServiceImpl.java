package com.zyg.service.impl;

import com.zyg.dao.IAccountDao;
import com.zyg.domain.Account;
import com.zyg.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/3/25 16:14
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService  {
    @Autowired
   private IAccountDao iAccountDao;
    @Override
    public List<Account> findAll() {
        System.out.println("业务层查询所有");

        return iAccountDao.findAll();
    }

    @Override
    public void save(Account account) {
        iAccountDao.save(account);

    }
}
