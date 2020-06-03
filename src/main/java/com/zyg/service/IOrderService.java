package com.zyg.service;

import com.zyg.domain.Order;

import java.util.List;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/5/30 23:39
 */
public interface IOrderService {
    /**
     * 查询所有
     *
     * @return
     */
    public List<Order> findAllOrder();
    /**
     * 根据ID查询订单
     *
     * @return
     */
    public Order findOrderById(Integer id);
    /**
     * 更改订单信息
     *
     * @return
     */
    public int updateOrder(Order order);

    /**
     * 根据ID删除订单
     *
     * @return
     */
    public int deleteOrder(Integer id);

    /**
     * 增加订单
     *
     * @return
     */
    public int addOrder(Order order);
}
