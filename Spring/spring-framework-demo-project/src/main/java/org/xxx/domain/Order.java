package org.xxx.domain;

public class Order {
    private Long id;
    private Long customerId;
    private Long goodsId;

    public Order() {
    }

    public Order(Long id, Long customerId, Long goodsId) {
        this.id = id;
        this.customerId = customerId;
        this.goodsId = goodsId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", goodsId=" + goodsId +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
}
