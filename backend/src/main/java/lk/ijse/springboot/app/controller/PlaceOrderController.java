package lk.ijse.springboot.app.controller;


import lk.ijse.springboot.app.dto.OrderDTO;
import lk.ijse.springboot.app.dto.PlaceOrderDTO;
import lk.ijse.springboot.app.service.PlaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/placeorder")
public class PlaceOrderController {

    @Autowired
    private PlaceOrderService placeOrderService;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean placeOrder(@RequestBody PlaceOrderDTO placeOrderDTO) {
        return placeOrderService.placeOrder(placeOrderDTO);
        }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<OrderDTO> getAllOrders() {
        return placeOrderService.getAllOders();
    }

    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getOrdersCount(){

        return placeOrderService.getTotalOrders();
    }

}
