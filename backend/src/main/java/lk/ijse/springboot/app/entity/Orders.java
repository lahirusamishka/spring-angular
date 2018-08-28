package lk.ijse.springboot.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Orders {

    @Id
    private String oId;
    private String date;
    private double totalPrice;
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

    public Orders() {
    }

    public Orders(String oId, String date, double totalPrice, Customer customer) {
        this.setoId(oId);
        this.setDate(date);
        this.setTotalPrice(totalPrice);
        this.setCustomer(customer);
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oId='" + oId + '\'' +
                ", date='" + date + '\'' +
                ", totalPrice=" + totalPrice +
                ", customer=" + customer +
                '}';
    }
}
