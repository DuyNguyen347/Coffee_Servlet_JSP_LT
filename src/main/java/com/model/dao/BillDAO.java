package com.model.dao;

import com.model.bean.Bill;
import com.model.bean.InforItem;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillDAO {
    Statement stmt;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-đ HH:mm:ss");

    public BillDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlynhahang", "root", "");
            stmt = con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error in line 20 BillDAO: " + e.getMessage());
        }
    }

    public Bill getBillByID(int id) {
        ItemDAO itemDAO = new ItemDAO();
        String sql = "Select * from hoadon where id=" + id;
        String tenkhachhang = null;
        String sodienthoai = null;
        Timestamp CreateAt = null;
        Timestamp UpdateAt =null;
        Timestamp DeleteAt = null;
        List<InforItem> items = new ArrayList<>();
        int chietkhau = 0;
        int thanhtoan = 0;
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tenkhachhang = rs.getString("tenkhachhang");
                sodienthoai = rs.getString("sodienthoai");
                CreateAt = rs.getTimestamp("CreateAt");
                UpdateAt = rs.getTimestamp("UpdateAt");
                DeleteAt = rs.getTimestamp("DeleteAt");
                chietkhau = rs.getInt("chietkhau");
                thanhtoan = rs.getInt("thanhtoan");
            }
            sql = "Select * from thongtinhoadon where id_hoadon=" + id;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                items.add(
                        new InforItem(
                                itemDAO.getItemByID(rs.getInt("id_mon")),
                                rs.getInt("soluong")
                        )
                );
            }
            return new Bill(id,
                    items,
                    tenkhachhang,
                    sodienthoai,
                    chietkhau,
                    CreateAt,
                    UpdateAt,
                    DeleteAt,
                    thanhtoan);
        } catch (SQLException throwables) {
            System.out.println("Error in line 69 file BillDAO: "+throwables.getMessage());
        }
        return null;
    }
    public List<Bill> getAllBills(){
        ItemDAO itemDAO = new ItemDAO();
        List<Bill> bills = new ArrayList<>();
        int id;
        String tenkhachhang = null;
        String sodienthoai = null;
        Timestamp CreateAt = null;
        Timestamp UpdateAt =null;
        Timestamp DeleteAt = null;
        List<InforItem> items;
        int chietkhau = 0;
        int thanhtoan = 0;
        try {
            String sql = "Select * from hoadon";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                items = new ArrayList<>();
                id = rs.getInt("id");
                tenkhachhang = rs.getString("tenkhachhang");
                sodienthoai = rs.getString("sodienthoai");
                CreateAt = rs.getTimestamp("CreateAt");
                UpdateAt = rs.getTimestamp("UpdateAt");
                DeleteAt = rs.getTimestamp("DeleteAt");
                chietkhau = rs.getInt("chietkhau");
                thanhtoan = rs.getInt("thanhtoan");
                String sql2 = "select * from thongtinhoadon where id_hoadon="+id;
                ResultSet rs2 = stmt.executeQuery(sql2);
                while (rs2.next()){
                    items.add(
                            new InforItem(
                                    itemDAO.getItemByID(rs2.getInt("id")),
                                    rs2.getInt("soluong")
                            )
                    );
                }
                bills.add(new Bill(
                        id,
                        items,
                        tenkhachhang,
                        sodienthoai,
                        chietkhau,
                        CreateAt,
                        UpdateAt,
                        DeleteAt,
                        thanhtoan
                ));
            }

            return bills;
        } catch (SQLException throwables) {
            System.out.println("Error in line 122 file BillDAO: "+throwables.getMessage());
        }
        return null;
    }
    public int addNewBill(Bill bill){
        try {
            ResultSet rs = stmt.executeQuery(
                    "SELECT id FROM hoadon ORDER BY id DESC LIMIT 1");

        if(!rs.next())
            return -1;
        int id = rs.getInt("id")+1;
        String tenkhachhang = bill.tenkhachhang!=""?"'"+ bill.tenkhachhang+"',":"null,";
        String sodienthoai = bill.sodienthoai!=""?"'"+ bill.sodienthoai+"',":"null,";
        String chietkhau = bill.chietkhau!=0?bill.chietkhau+",":"null,";
        String thanhtoan = bill.thanhtoan!=0?Integer.toString(bill.thanhtoan):"null";
            String sql = "INSERT INTO `hoadon`(`id`, `tenkhachhang`, `sodienthoai`, `CreateAt`,`chietkhau`, `thanhtoan`)" +
                " VALUES ("+id+","+tenkhachhang+sodienthoai+"'"+sdf.format(new Date())+"',"
                +chietkhau+thanhtoan+")";
        System.out.println(sql);
        stmt.execute(sql);
        return id;
        } catch (SQLException throwables) {
            System.out.println("Error in line 146 file BillDAO: "+throwables.getMessage());
        }
        return -1;
    }
    public boolean updateBill(Bill bill){
        try {
            String tenkhachhang = bill.tenkhachhang!=""?"'"+ bill.tenkhachhang+"',":"null,";
            String sodienthoai = bill.sodienthoai!=""?"'"+ bill.sodienthoai+"',":"null,";
            String chietkhau = bill.chietkhau!=0?bill.chietkhau+",":"null,";
            String thanhtoan = bill.thanhtoan!=0?Integer.toString(bill.thanhtoan):"null";
            String sql = "UPDATE `hoadon` SET `tenkhachhang`="+tenkhachhang+
                    "`sodienthoai`="+sodienthoai+"`UpdateAt`='"+sdf.format(new Date())+"',`chietkhau`="+
                    chietkhau+"`thanhtoan`="+thanhtoan+" WHERE id="+bill.getId();
            System.out.println(sql);
            stmt.execute(sql);
            return true;
        } catch (SQLException throwables) {
            System.out.println("Error in line 163 file BillDAO: "+throwables.getMessage());
        }
        return false;
    }
    public boolean deleteBill(int id){
        try {
            String sql = "UPDATE `hoadon` SET `DeleteAt`='"+sdf.format(new Date())+"' WHERE id="+id;
            System.out.println(sql);
            stmt.execute(sql);
            return true;
        } catch (SQLException throwables) {
            System.out.println("Error in line 174 file BillDAO: "+throwables.getMessage());
        }
        return false;
    }
    public boolean _DELETEBill(int id){
        try {
            String sql = "DELETE FROM `hoadon`"+
                    "WHERE `id`="+id;
            stmt.execute(sql);
            return true;
        } catch (SQLException throwables) {
            System.out.println("Error in line 185 file BillDAO:"+throwables.getMessage());
        }
        return false;
    }
}
