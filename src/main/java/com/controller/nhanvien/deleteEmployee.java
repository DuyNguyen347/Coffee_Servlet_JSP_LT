package com.controller.nhanvien;

import com.model.dao.employeeDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deleteEmployee", value = "/nhanvien/xoa")
public class deleteEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =  Integer.parseInt(request.getParameter("id"));
        employeeDAO employeeDAO = new employeeDAO();
        try {
            employeeDAO.deleteEmployee(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
