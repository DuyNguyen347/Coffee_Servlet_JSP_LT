package com.model.bo;

import com.model.bean.Item;
import com.model.dao.ItemDAO;

import java.util.ArrayList;
import java.util.List;

public class ItemBO {
    ItemDAO itemDAO;
    public ItemBO(){
        itemDAO = new ItemDAO();
    }
    public List<Item> getItems(int f, int t){
        List<Item> list = itemDAO.getAllItems();
        List<Item> list_ = new ArrayList<>();
        int x=(t>list.size())?list.size():t;
        for(int i=f;list_.size()<=x && i<list.size();i++){
            if(list.get(i).getDeleteAt()==null)
                list_.add(list.get(i));
        }
        return  list_;
    }
    public List<Item> getDeletedItems(int f, int t){
        List<Item> list = itemDAO.getAllItems();
        List<Item> list_ = new ArrayList<>();
        int x=(t>list.size())?list.size():t;
        for(int i=f;list_.size()<=x && i<list.size();i++){
            if(list.get(i).getDeleteAt()!=null)
                list_.add(list.get(i));
        }
        return  list_;
    }
    public boolean AddNewItem(Item item){
        return itemDAO.addNewItem(item);
    }
    public boolean updateItem(Item item){
        return itemDAO.updateItem(item);
    }
    public boolean deleteItem(int id){
        return itemDAO.deleteItem(id);
    }
    public Item GetItemById(int id){
        return itemDAO.getItemByID(id);
    }
}
