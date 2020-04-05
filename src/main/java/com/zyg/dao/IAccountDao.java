package com.zyg.dao;

import com.zyg.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/3/25 16:08
 */
@Repository
public interface IAccountDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from account")
    public List<Account> findAll();

    /**
     * 保存
     * @param account
     */
    @Insert("insert into account (name,money) values (#{name},#{money})")
    public void save(Account account);
}
