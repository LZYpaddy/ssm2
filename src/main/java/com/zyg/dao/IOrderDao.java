package com.zyg.dao;

import com.zyg.domain.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/5/30 23:43
 */
@Repository
public interface IOrderDao {

    /**
     * 查询所有
     * @return
     * */
    //    @Select("select * from `order`")
    @Select("select * from `order` left join order_item on order.order_id=order_item.order_id")
    List<Order> findAllOrder();
    /**
     * 根据ID查询订单
     * @return
     */
    @Select("select * from `order` where order_id=#{orderId}")
    Order findOrderById(Integer orderId);
    /**
     * 更改订单信息
     * @return
     */
    @Update("UPDATE `order` SET user_id=#{userId},down_time=#{downTime},pay_time=#{payTime},amount=#{amount} where order_id=#{orderId}")
    int updateOrder(Order order);
    /**
     * 删除订单
     * @return
     */
    @Delete("delete from `order` where order_id = #{orderId}")
    int deleteOrder(Integer id);
    /**
     * 增加订单
     * @return
     */
    @Insert("INSERT INTO `order` (user_id,down_time,pay_time,amount) VALUES (#{userId},#{downTime},#{payTime},#{amount})")
    int addOrder(Order order);

}
