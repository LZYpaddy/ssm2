package com.zyg.service.impl;

import com.zyg.dao.IOrderDao;
import com.zyg.domain.Order;
import com.zyg.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/5/30 23:41
 */
@Service("orderService")
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderDao iOrderDao;
    @Override
    public List<Order> findAllOrder() {
        System.out.println("业务层查询所有订单");

        return iOrderDao.findAllOrder();
    }

    @Override
    public Order findOrderById(Integer order) {
        System.out.println("业务层查询所有订单");

        return iOrderDao.findOrderById(order);
    }

    @Override
    public int updateOrder(Order order) {
        System.out.println("业务层更改订单信息");
        System.out.println(order.toString());
        return iOrderDao.updateOrder(order);
    }

    @Override
    public int deleteOrder(Integer order) {
        System.out.println("业务层删除订单");

        return iOrderDao.deleteOrder(order);
    }

    @Override
    public int addOrder(Order order) {
        System.out.println("业务层增加订单");

        return iOrderDao.addOrder(order);
    }
}
