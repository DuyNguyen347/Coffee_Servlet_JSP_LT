package com.controller.nhanvien;

import com.model.bean.Employee;
import com.model.dao.employeeDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "addEmployee", value = "/nhanvien/them")
public class addEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        request.getRequestDispatcher("formAddNhanvien.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name = request.getParameter("name");
//        String address = request.getParameter("address");
//        String email = request.getParameter("email");
//        String phone = request.getParameter("phone");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        Timestamp timestamp = null;
//        try {
//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
//            Date parsedDate = dateFormat.parse(request.getParameter("birthday"));
//            timestamp = new java.sql.Timestamp(parsedDate.getTime());
//        } catch(Exception e) {
//        }
//        Employee admin = new Employee("*", name,address,email,phone,timestamp,username,password);
//        employeeDAO employeeDAO = new employeeDAO();
//        try {
//            int result = employeeDAO.insertemployee(admin);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        response.sendRedirect("listEmployee");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        System.out.println(request.getParameter("birthday"));
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        try {
            if(request.getParameter("birthday").toString() != "")
            {
                birthday = df.parse(request.getParameter("birthday"));
                String newDateString = df.format(birthday);
                System.out.println(newDateString);
            }
            else birthday = null;
        } catch (ParseException e) {
            e.printStackTrace();
            birthday = null;
        }
        Employee employee = new Employee("*",name,address,email,phone,birthday,username,password);
        employeeDAO employeeDAO = new employeeDAO();
        try {
            int result  = employeeDAO.insertemployee(employee);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("list");
    }
}
