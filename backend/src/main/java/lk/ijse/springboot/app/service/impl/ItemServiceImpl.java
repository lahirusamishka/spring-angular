package lk.ijse.springboot.app.service.impl;


import lk.ijse.springboot.app.dto.ItemsDTO;
import lk.ijse.springboot.app.entity.Items;
import lk.ijse.springboot.app.repository.ItemRepositry;
import lk.ijse.springboot.app.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepositry itemRepositry;

    @Override
    public ArrayList<ItemsDTO> getItems() {
        List<Items> itemsList = itemRepositry.findAll();

        ArrayList<ItemsDTO> allItems = new ArrayList<>();

        for (Items items : itemsList){
            ItemsDTO itemsDTO=new ItemsDTO(items.getCode(),items.getDiscription(),items.getUnicPrice(),items.getQtyOnHand());

            allItems.add(itemsDTO);
        }

        return allItems;
    }

    @Override
    public ItemsDTO getItem(String ItemCode) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteItem(String ItemCode) {
        itemRepositry.deleteById(ItemCode);
        return true;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveItems(ItemsDTO itemsDTO) {
        Items items=new Items(itemsDTO.getCode(),itemsDTO.getDiscription(),itemsDTO.getUnicPrice(),itemsDTO.getQtyOnHand());
        itemRepositry.save(items);
        return true;
            }

    @Override
    public long getTotalItems() {

            return itemRepositry.getTotalItems();

    }

    @Override
    public ItemsDTO serchItem(String code) {
        Optional<Items> byId = itemRepositry.findById(code);
        Items item=byId.get();

        ItemsDTO itemsDTO=new ItemsDTO(
                 item.getCode(),
                 item.getDiscription(),
                 item.getUnicPrice(),
                 item.getQtyOnHand()
         );
         return itemsDTO;
    }
}
