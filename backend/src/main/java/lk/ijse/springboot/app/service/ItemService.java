package lk.ijse.springboot.app.service;


import lk.ijse.springboot.app.dto.ItemsDTO;

import java.util.ArrayList;

public interface ItemService {

    public ArrayList<ItemsDTO> getItems();

    public ItemsDTO getItem(String ItemCode);

    public boolean deleteItem(String ItemCode);

    public boolean saveItems(ItemsDTO itemsDTO);

    public long getTotalItems();

    public ItemsDTO serchItem(String code);
}
