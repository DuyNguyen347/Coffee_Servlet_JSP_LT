package com.controller.nhanvien;

import com.model.bean.Employee;
import com.model.dao.employeeDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "updateEmployee", value = "/nhanvien/capnhat")
public class updateEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        employeeDAO dao = new employeeDAO();
        Employee employee = dao.getEmployeeById(id);
        System.out.println(employee);
        request.setAttribute("employee",employee);
        request.getRequestDispatcher("formUpdateNhanvien.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
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
        Employee employee = new Employee(id,name,address,email,phone,birthday,username,password);
        employeeDAO employeeDAO = new employeeDAO();
        try {
            employeeDAO.updateEmployee(employee);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("list");
    }
}
