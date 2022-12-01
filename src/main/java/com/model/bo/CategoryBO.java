package com.model.bo;

import com.model.bean.Category;
import com.model.dao.CategoryDAO;

import java.util.ArrayList;
import java.util.List;

public class CategoryBO {
    CategoryDAO categoryDAO;
    public CategoryBO(){
        categoryDAO = new CategoryDAO();
    }
    public List<Category> GetCategories(){
        List<Category> list = categoryDAO.getAllCategorys();
        List<Category> list_ = new ArrayList<>();
        for(Category i:list){
            if(i.getDeleteAt()==null)
                list_.add(i);
        }
        return  list_;
    }
    public List<Category> GetCategories(int f, int t){
        List<Category> list = categoryDAO.getAllCategorys();
        List<Category> list_ = new ArrayList<>();
        int x=(t>list.size())?list.size():t;
        for(int i=f;list_.size()<=x && i<list.size();i++){
            if(list.get(i).getDeleteAt()==null)
                list_.add(list.get(i));
        }
        return  list_;
    }
    public List<Category> GetDeletedCategories(int f, int t){
        List<Category> list = categoryDAO.getAllCategorys();
        List<Category> list_ = new ArrayList<>();
        int x=(t>list.size())?list.size():t;
        for(int i=f;list_.size()<=x && i<list.size();i++){
            if(list.get(i).getDeleteAt()!=null)
                list_.add(list.get(i));
        }
        return  list_;
    }
    public boolean AddNewCategory(Category category){
        return categoryDAO.addNewCategory(category);
    }
    public Category GetCategoryById(int id){
        return categoryDAO.getCategoryByID(id);
    }
    public boolean updateCategory(Category category){
        return categoryDAO.updateCategory(category);
    }
    public boolean deleteCategory(int id){
        return categoryDAO.deleteCategory(id);
    }
}
