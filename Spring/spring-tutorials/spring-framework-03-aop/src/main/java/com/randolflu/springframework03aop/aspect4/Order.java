package com.randolflu.springframework03aop.aspect4;

public class Order {
    private Long id;
    private Long CustomerId;
    private Long GoodsId;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", CustomerId=" + CustomerId +
                ", GoodsId=" + GoodsId +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(Long customerId) {
        CustomerId = customerId;
    }

    public Long getGoodsId() {
        return GoodsId;
    }

    public void setGoodsId(Long goodsId) {
        GoodsId = goodsId;
    }

    public Order(Long id, Long customerId, Long goodsId) {
        this.id = id;
        CustomerId = customerId;
        GoodsId = goodsId;
    }

    public Order() {
    }

    public void genAnException() {
        throw new RuntimeException("手动触发异常");
    }

}
