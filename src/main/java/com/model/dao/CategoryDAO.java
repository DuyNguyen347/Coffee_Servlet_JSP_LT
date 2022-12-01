package com.model.dao;

import com.model.bean.Category;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    Statement stmt;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public CategoryDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlynhahang","root","");
            stmt = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public Category getCategoryByID(int id){
        Category category;
        try {
            String sql = "Select * from danhmuc where id="+id+"";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                category = new Category(
                        rs.getInt("id"),
                        rs.getString("TenDM"),
                        rs.getTimestamp("CreateAt"),
                        rs.getTimestamp("UpdateAt"),
                        rs.getTimestamp("DeleteAt")
                );
                return category;
            }
        } catch (SQLException throwables) {
            System.out.println("Error in line 36 file CategoryDAO:"+throwables.getMessage());
        }
        return null;
    }
    public List<Category> getAllCategorys(){
        List<Category> Categorys = new ArrayList<>();
        try {
            String sql = "Select * from danhmuc";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                Categorys.add(new Category(
                        rs.getInt("id"),
                        rs.getString("TenDM"),
                        rs.getTimestamp("CreateAt"),
                        rs.getTimestamp("UpdateAt"),
                        rs.getTimestamp("DeleteAt")
                ));
            }
        } catch (SQLException throwables) {
            System.out.println("Error in line 59 file CategoryDAO:"+throwables.getMessage());
        }
        return Categorys;
    }
    public boolean addNewCategory(Category Category){
        try {
            String sql = "INSERT INTO `danhmuc`(`TenDM`,`CreateAt`) VALUES " +
                         "('"+Category.tenDM+"','"+sdf.format(new Date())+"')";
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException throwables) {

            System.out.println("Error in line 71 file CategoryDAO:"+throwables.getMessage());
        }
        return false;
    }
    public boolean updateCategory(Category Category){
        try {
            String sql = "UPDATE `danhmuc` SET `TenDM`='"+Category.tenDM+"',`UpdateAt`='"+sdf.format(new Date())+
                         "' WHERE `id`="+Category.getId();
            stmt.execute(sql);
            return true;
        } catch (SQLException throwables) {
            System.out.println("Error in line 82 file CategoryDAO:"+throwables.getMessage());
        }
        return false;
    }
    public boolean deleteCategory(int id){
        try {
            String sql = "UPDATE `danhmuc` SET `DeleteAt`='"+sdf.format(new Date())+
                    "' WHERE `id`="+id;
            stmt.execute(sql);
            return true;
        } catch (SQLException throwables) {
            System.out.println("Error in line 93 file CategoryDAO:"+throwables.getMessage());
        }
        return false;
    }
    public boolean _DELETECategory(int id){
        try {
            String sql = "DELETE FROM `danhmuc`"+
                    "WHERE `id`="+id;
            stmt.execute(sql);
            return true;
        } catch (SQLException throwables) {
            System.out.println("Error in line 104 file CategoryDAO:"+throwables.getMessage());
        }
        return false;
    }
}
