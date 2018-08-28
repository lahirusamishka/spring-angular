package lk.ijse.springboot.app.dto;

import java.util.List;

public class PlaceOrderDTO {


    private ItemsDTO itemsDTO;
    private OrderDTO orderDTO;
    private List<OrderDetailDTO> orderDetailDTOS;

    public PlaceOrderDTO() {
    }

    public PlaceOrderDTO(ItemsDTO itemsDTO, OrderDTO orderDTO, List<OrderDetailDTO> orderDetailDTOS) {
        this.setItemsDTO(itemsDTO);
        this.setOrderDTO(orderDTO);
        this.setOrderDetailDTOS(orderDetailDTOS);
    }


    public ItemsDTO getItemsDTO() {
        return itemsDTO;
    }

    public void setItemsDTO(ItemsDTO itemsDTO) {
        this.itemsDTO = itemsDTO;
    }

    public OrderDTO getOrderDTO() {
        return orderDTO;
    }

    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }

    public List<OrderDetailDTO> getOrderDetailDTOS() {
        return orderDetailDTOS;
    }

    public void setOrderDetailDTOS(List<OrderDetailDTO> orderDetailDTOS) {
        this.orderDetailDTOS = orderDetailDTOS;
    }
}
