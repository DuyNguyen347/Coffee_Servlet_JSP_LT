package com.controller.nhanvien;

import com.model.bean.Employee;
import com.model.dao.employeeDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "addEmployee", value = "/addEmployee")
public class addEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Timestamp timestamp = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            Date parsedDate = dateFormat.parse(request.getParameter("birthday"));
            timestamp = new java.sql.Timestamp(parsedDate.getTime());
        } catch(Exception e) {
        }
        Employee admin = new Employee("*", name,address,email,phone,timestamp,username,password);
        employeeDAO employeeDAO = new employeeDAO();
        try {
            int result = employeeDAO.insertemployee(admin);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("listEmployee");
    }
}
