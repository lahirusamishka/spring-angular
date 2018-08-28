package lk.ijse.springboot.app.dto;

public class OrderDetailDTO {


    private double quantity;
    private double unitprice;
    private ItemsDTO item;
    private OrderDTO orders;
    private orderDetail_PKDTO orderDetail_PKDto;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(double quantity, double unitprice, ItemsDTO item, OrderDTO orders, orderDetail_PKDTO orderDetail_PKDto) {
        this.setQuantity(quantity);
        this.setUnitprice(unitprice);
        this.setItem(item);
        this.setOrders(orders);
        this.setOrderDetail_PKDto(orderDetail_PKDto);
    }


    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(double unitprice) {
        this.unitprice = unitprice;
    }

    public ItemsDTO getItem() {
        return item;
    }

    public void setItem(ItemsDTO item) {
        this.item = item;
    }

    public OrderDTO getOrders() {
        return orders;
    }

    public void setOrders(OrderDTO orders) {
        this.orders = orders;
    }

    public orderDetail_PKDTO getOrderDetail_PKDto() {
        return orderDetail_PKDto;
    }

    public void setOrderDetail_PKDto(orderDetail_PKDTO orderDetail_PKDto) {
        this.orderDetail_PKDto = orderDetail_PKDto;
    }
}
