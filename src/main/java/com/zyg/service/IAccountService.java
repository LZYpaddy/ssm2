package com.zyg.service;

import com.zyg.domain.Account;

import java.util.List;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/3/25 16:12
 */
public interface IAccountService {
    /**
     * 查询所有
     * @return
     */
    public List<Account> findAll();

    /**
     * 保存
     * @param account
     */
    public void save(Account account);
}
