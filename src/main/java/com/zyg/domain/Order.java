package com.zyg.domain;

import java.util.Date;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/5/30 23:28
 */
public class Order {
    private Integer orderId;
    private Integer userId;
    private Integer courseId;
    private Date downTime;
    private Date payTime;
    private double amount;

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", courseId=" + courseId +
                ", downTime=" + downTime +
                ", payTime=" + payTime +
                ", amount=" + amount +
                '}';
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getDownTime() {
        return downTime;
    }

    public void setDownTime(Date downTime) {
        this.downTime = downTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
