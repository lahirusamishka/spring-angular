package lk.ijse.springboot.app.dto;

public class ItemsDTO {

    private String code;
    private String discription;
    private Double unicPrice;
    private int QtyOnHand;

    public ItemsDTO() {
    }

    public ItemsDTO(String code, String discription, Double unicPrice, int qtyOnHand) {
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
        return "ItemsDTO{" +
                "code='" + code + '\'' +
                ", discription='" + discription + '\'' +
                ", unicPrice=" + unicPrice +
                ", QtyOnHand=" + QtyOnHand +
                '}';
    }
}
