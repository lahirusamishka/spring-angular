package lk.ijse.springboot.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Items {

    @Id
    private String code;
    private String discription;
    private Double unicPrice;
    private int QtyOnHand;

    public Items() {
    }

    public Items(String code, String discription, Double unicPrice, int qtyOnHand) {
        this.setCode(code);
        this.setDiscription(discription);
        this.setUnicPrice(unicPrice);
        setQtyOnHand(qtyOnHand);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Double getUnicPrice() {
        return unicPrice;
    }

    public void setUnicPrice(Double unicPrice) {
        this.unicPrice = unicPrice;
    }

    public int getQtyOnHand() {
        return QtyOnHand;
    }

    public void setQtyOnHand(int qtyOnHand) {
        QtyOnHand = qtyOnHand;
    }

    @Override
    public String toString() {
        return "Items{" +
                "code='" + code + '\'' +
                ", discription='" + discription + '\'' +
                ", unicPrice=" + unicPrice +
                ", QtyOnHand=" + QtyOnHand +
                '}';
    }
}
