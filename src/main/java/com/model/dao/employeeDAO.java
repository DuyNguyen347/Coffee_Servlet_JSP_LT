package com.model.dao;

import com.model.bean.Employee;

import java.sql.*;
import java.util.ArrayList;

public class employeeDAO {
    Connection con = null;
    Statement st = null;
    PreparedStatement prst = null;
    public ArrayList<Employee> getAdminList(String username){
        ArrayList<Employee> result = new ArrayList<Employee>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlynhahang","root","");
            Statement stmt = con.createStatement();
            ResultSet rs = null;
            String sql = "select * from nhanvien where 1";
            rs = ((java.sql.Statement) stmt).executeQuery(sql);
            while(rs.next()) {
                result.add(new Employee(rs.getString("id"), rs.getString("name"), rs.getString("address"),rs.getString("email"),rs.getString("phone"),rs.getDate("birthday"),rs.getString("username"), rs.getString("password")));
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public int insertemployee(Employee employee) throws SQLException, ClassNotFoundException {
        System.out.println("Adding");
        if (con == null) {
            con = ConnectionDatabase.getMySQLConnection();
        }
        String sql = "insert into nhanvien (id,name,address,email,phone,birthday,username,password) values (NULL,?,?,?,?,?,?,?)";
        prst = (PreparedStatement) con.prepareStatement(sql);
        prst.setString(6,employee.getUsername());
        prst.setString(7,employee.getPassword());
        prst.setString(1,employee.getName());
        prst.setString(2,employee.getAddress());
        prst.setString(3,employee.getEmail());
        prst.setString(4,employee.getPhone());
        if(employee.getBirthday() == null) prst.setDate(5, null);
        else {
            java.sql.Date sqlStartDate = new java.sql.Date(employee.getBirthday().getTime());
            prst.setDate(5, sqlStartDate);
        }
        System.out.println("vao toi day");
        System.out.println(prst);
        try{
            int result = prst.executeUpdate();
            System.out.println("ket qua update" + result);
            return result;
        }
        catch (Exception e)
        {
            System.out.println("Loi khi them: ");
            e.printStackTrace();
        }
        return 0;
    }
    public void deleteEmployee(int id) throws SQLException, ClassNotFoundException {
        if (con == null) {
            con = ConnectionDatabase.getMySQLConnection();
        }
        String sql = "delete from nhanvien where Id  = ?";
        prst = (PreparedStatement) con.prepareStatement(sql);
        prst.setInt(1,id);
        try{
            prst.executeUpdate();
            System.out.println("Xoa thanh cong");
        }
        catch (Exception e)
        {
            System.out.println("Loi khi xoa");
            e.printStackTrace();
        }
    }
    public  void updateEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        System.out.println("updating");
        if (con == null) {
            con = ConnectionDatabase.getMySQLConnection();
        }
        String sql = "UPDATE nhanvien SET username = ?,password = ?,name = ?, birthday =? ,email = ?, phone = ?, address = ?  WHERE id = ?";
        prst = con.prepareStatement(sql);
        prst.setString(1,employee.getUsername());
        prst.setString(2,employee.getPassword());
        prst.setString(3,employee.getName());
//        java.sql.Date sqlStartDate = new java.sql.Date(employee.getBirthday().getTime());
//        prst.setDate(4, sqlStartDate);
        if(employee.getBirthday() == null) prst.setDate(4, null);
        else {
            java.sql.Date sqlStartDate = new java.sql.Date(employee.getBirthday().getTime());
            prst.setDate(4, sqlStartDate);
        }
        prst.setString(5,employee.getEmail());
        prst.setString(6,employee.getPhone());
        prst.setString(7,employee.getAddress());
        prst.setInt(8,Integer.parseInt(employee.getId()));
        try{
            prst.executeUpdate();
            System.out.println("Cap nhat thanh cong");
        }
        catch (Exception e)
        {
            System.out.println("Loi khi cap nhat");
            e.printStackTrace();
        }
    }
    public Employee getEmployeeById(int id) {
        if (con == null) {
            con = ConnectionDatabase.getMySQLConnection();
        }
        try{
            String sql = "SELECT * FROM nhanvien WHERE Id = ? LIMIT 1";
            prst = con.prepareStatement(sql);
            prst.setInt(1,id);
            ResultSet rs = null;
            rs = prst.executeQuery();
            while (rs.next())
            {
                return new Employee(rs.getString("id"),rs.getString("name"),rs.getString("address"),rs.getString("email"),rs.getString("phone"),rs.getDate("birthday"), rs.getString("username"),rs.getString("password"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public Employee getEmployeeByUsernamePassword(String username,String password){
        if (con == null) {
            con = ConnectionDatabase.getMySQLConnection();
        }
        try{
            String sql = "SELECT * FROM nhanvien WHERE username = ? and password = ? LIMIT 1";
            prst = con.prepareStatement(sql);
            prst.setString(1,username);
            prst.setString(2,password);
            ResultSet rs = null;
            rs = prst.executeQuery();
            while (rs.next())
            {
                return new Employee(rs.getString("id"),rs.getString("name"),rs.getString("address"),rs.getString("email"),rs.getString("phone"),rs.getDate("birthday"), rs.getString("username"),rs.getString("password"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return  null;
    }
}