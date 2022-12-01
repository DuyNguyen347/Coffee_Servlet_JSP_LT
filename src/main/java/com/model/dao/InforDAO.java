package com.model.dao;

import com.model.bean.Category;
import com.model.bean.InforItem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InforDAO {
    Statement stmt;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public InforDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlynhahang","root","");
            stmt = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean addNewInfor(int id,InforItem inforItem){
        try {
            String sql = "INSERT INTO `thongtinhoadon`(`id_mon`, `id_hoadon`," +
                    " `soluong`) VALUES ("+inforItem.item.getId()+"," +
                    +id+","+inforItem.soluong+")";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            return true;
        } catch (SQLException throwables) {
            System.out.println("Error in line 35 file InforDAO:"+throwables.getMessage());
        }
        return false;
    }
    public boolean updateInfor(int id,InforItem inforItem){
        try {
            String sql = "UPDATE `thongtinhoadon` SET `soluong`="+inforItem.soluong+
                    " WHERE `id_hoadon`="+id+" and `id_mon`="+inforItem.item.getId();
            System.out.println(sql);
            stmt.execute(sql);
            return true;
        } catch (SQLException throwables) {
            System.out.println("Error in line 47 file InforDAO:"+throwables.getMessage());
        }
        return false;
    }
    public boolean deleteInfor(int id,InforItem inforItem){
        try {
            String sql = "DELETE FROM `danhmuc`"+
                    " WHERE `id_hoadon`="+id+" and `id_mon`="+inforItem.item.getId();
            System.out.println(sql);
            stmt.execute(sql);
            return true;
        } catch (SQLException throwables) {
            System.out.println("Error in line 59 file InforDAO:"+throwables.getMessage());
        }
        return false;
    }
}
