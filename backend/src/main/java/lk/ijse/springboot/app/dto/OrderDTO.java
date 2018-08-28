package lk.ijse.springboot.app.dto;

public class OrderDTO {

    private String oId;
    private String date;
    private double totalPric;
    private CustomerDTO customer;

    public OrderDTO() {
    }

    public OrderDTO(String oId, String date, double totalPric, CustomerDTO customer) {
        this.setoId(oId);
        this.setDate(date);
        this.setTotalPric(totalPric);
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

    public double getTotalPric() {
        return totalPric;
    }

    public void setTotalPric(double totalPric) {
        this.totalPric = totalPric;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "oId='" + oId + '\'' +
                ", date='" + date + '\'' +
                ", totalPric=" + totalPric +
                ", customer=" + customer +
                '}';
    }
}
