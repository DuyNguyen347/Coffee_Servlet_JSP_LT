package com.controller.nhanvien;

import com.model.bean.Employee;
import com.model.dao.employeeDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "updateEmployee", value = "/updateEmployee")
public class updateEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String age = request.getParameter("age");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
//        Employee employee = new Employee("*", username,password,name,age,email,phone);
//        employeeDAO employeeDAO = new employeeDAO();
//        try {
//            int result = employeeDAO.insertemployee(employee);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        response.sendRedirect("listEmployee");
    }
}
