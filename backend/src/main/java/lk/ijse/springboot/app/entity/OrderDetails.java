package lk.ijse.springboot.app.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OrderDetails implements Serializable {



    private int quantity;
    private double unitprice;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "code",referencedColumnName = "code",insertable = false,updatable = false)
    private Items item;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "oId",referencedColumnName = "oId",insertable = false,updatable = false)
    private Orders orders;
    @EmbeddedId
    private OrderDetails_PK orderDetail_PK;

    public OrderDetails() {
    }

    public OrderDetails(int quantity, double unitprice, Items item, Orders orders, OrderDetails_PK orderDetail_PK) {
        this.setQuantity(quantity);
        this.setUnitprice(unitprice);
        this.setItem(item);
        this.setOrders(orders);
        this.setOrderDetail_PK(orderDetail_PK);
    }



    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public OrderDetails_PK getOrderDetail_PK() {
        return orderDetail_PK;
    }

    public void setOrderDetail_PK(OrderDetails_PK orderDetail_PK) {
        this.orderDetail_PK = orderDetail_PK;
    }
}
