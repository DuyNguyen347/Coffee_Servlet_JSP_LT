package com.model.dao;

import com.model.bean.Item;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemDAO {
    Statement stmt;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public ItemDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlynhahang","root","");
            stmt = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public Item getItemByID(int id){
        Item item;
        CategoryDAO cataDao = new CategoryDAO();
        try {
            String sql = "Select * from mon where id="+id+"";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                item = new Item(
                        rs.getInt("id"),
                        rs.getString("TenMon"),
                        cataDao.getCategoryByID(rs.getInt("ID_DanhMuc")),
                        Integer.parseInt(rs.getString("Gia")),
                        rs.getString("MoTa"),
                        rs.getTimestamp("CreateAt"),
                        rs.getTimestamp("UpdateAt"),
                        rs.getTimestamp("DeleteAt"),
                        rs.getString("Image")
                );
                return item;
            }
        } catch (SQLException throwables) {
            System.out.println("Error in line 42 file ItemDAO:"+throwables.getMessage());
        }
        return null;
    }
    public List<Item> getAllItems(){
        List<Item> items = new ArrayList<>();
        CategoryDAO cataDao = new CategoryDAO();
        try {
            String sql = "Select * from mon";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                items.add(new Item(
                        rs.getInt("id"),
                        rs.getString("TenMon"),
                        cataDao.getCategoryByID(rs.getInt("ID_DanhMuc")),
                        Integer.parseInt(rs.getString("Gia")),
                        rs.getString("MoTa"),
                        rs.getTimestamp("CreateAt"),
                        rs.getTimestamp("UpdateAt"),
                        rs.getTimestamp("DeleteAt"),
                        rs.getString("Image")
                ));
            }
        } catch (SQLException throwables) {
            System.out.println("Error in line 65 file ItemDAO:"+throwables.getMessage());
        }
        return items;
    }
    public boolean addNewItem(Item item){
        try {
            String img = item.img!=null?"'"+item.img+"'":"null";
            String sql = "INSERT INTO mon(`TenMon`, ID_DanhMuc, Gia, MoTa, CreateAt,`Image`) " +
                    "VALUES ('"+ item.tenmon+"',"+item.DM.getId()+",'"+item.gia+"'," +
                    "'"+item.mota+"','"+sdf.format(new Date())+"',"+img+")";
            System.out.println(sql);
            stmt.execute(sql);
            return true;
        } catch (SQLException throwables) {
            System.out.println("Error in line 77 file ItemDAO:"+throwables.getMessage());
        }
        return false;
    }
    public boolean updateItem(Item item){
        try {
            String img = item.img!=null?",`Image`=\'"+item.img+"'":"";
            String sql = "UPDATE mon SET `TenMon`='"+item.tenmon+"',`ID_DanhMuc`="+item.DM.getId()+"," +
                    "`Gia`='"+item.gia+"',`MoTa`='"+item.mota+"',`UpdateAt`='"+sdf.format(new Date())+"'"+ img +
                    " WHERE `id`="+item.getId();
            stmt.execute(sql);
            return true;
        } catch (SQLException throwables) {
            System.out.println("Error in line 89 file ItemDAO:"+throwables.getMessage());
        }
        return false;
    }
    public boolean deleteItem(int id){
        try {
            String sql = "UPDATE `mon` SET `DeleteAt`='"+sdf.format(new Date())+
                    "' WHERE `id`="+id;
            stmt.execute(sql);
            return true;
        } catch (SQLException throwables) {
            System.out.println("Error in line 100 file ItemDAO:"+throwables.getMessage());
        }
        return false;
    }
    public boolean _DELETEItem(int id){
        try {
            String sql = "DELETE FROM `mon`"+
                    "WHERE `id`="+id;
            stmt.execute(sql);
            return true;
        } catch (SQLException throwables) {
            System.out.println("Error in line 111 file ItemDAO:"+throwables.getMessage());
        }
        return false;
    }
}
