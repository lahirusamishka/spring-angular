package lk.ijse.springboot.app.service;


import lk.ijse.springboot.app.dto.OrderDTO;
import lk.ijse.springboot.app.dto.PlaceOrderDTO;

import java.util.ArrayList;

public interface PlaceOrderService {

    public boolean placeOrder(PlaceOrderDTO placeOrderDTO);

    public ArrayList<OrderDTO> getAllOders() ;

    public long getTotalOrders();
}
