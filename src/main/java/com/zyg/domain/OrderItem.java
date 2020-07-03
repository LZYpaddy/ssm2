package com.zyg.domain;

/**
 * @author LZY
 * @version 1.0
 * @date 2020/6/10 12:43
 */
public class OrderItem {
    private long itemId;
    private long courseId;
    private long orderId;

    @Override
    public String toString() {
        return "OrderItem{" +
                "itemId=" + itemId +
                ", courseId=" + courseId +
                ", orderId=" + orderId +
                '}';
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
}
