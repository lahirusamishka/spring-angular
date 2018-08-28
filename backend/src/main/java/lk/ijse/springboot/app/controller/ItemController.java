package lk.ijse.springboot.app.controller;



import lk.ijse.springboot.app.dto.ItemsDTO;
import lk.ijse.springboot.app.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ItemsDTO> getAllItems() {

        return itemService.getItems();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveCustomer(@RequestBody ItemsDTO itemsDTO){
        return itemService.saveItems(itemsDTO);
    }

    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deletCustomer(@PathVariable("id") String id){
        return itemService.deleteItem(id);
    }

    @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public long getItemsCount(){

        return itemService.getTotalItems();
    }

    @GetMapping(value = "/{code}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemsDTO serchItems(@PathVariable("code") String code){
        System.out.println(code);
        return itemService.serchItem(code);

    }

}
