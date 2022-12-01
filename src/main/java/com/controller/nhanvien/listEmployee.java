package com.controller.nhanvien;

import com.model.bean.Employee;
import com.model.dao.employeeDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "listEmployee", value = "/nhanvien/employees")
public class listEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        employeeDAO employeeDAO = new employeeDAO();
        ArrayList<Employee> employeeList = null;
        employeeList = employeeDAO.getAdminList("");
        request.setAttribute("employeeList", employeeList);
        RequestDispatcher rd = request.getRequestDispatcher("quanlynhanvien.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
