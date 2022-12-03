package com.controller;

import com.model.bean.Employee;
import com.model.dao.employeeDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        employeeDAO dao = new employeeDAO();
        Employee employee = dao.getEmployeeByUsernamePassword(username,password);
        if(employee == null)
        {
            request.setAttribute("mes","Wrong username or password");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
        else{
//            request.setAttribute("username",employee.getName());
            HttpSession session = request.getSession();
            session.setAttribute("account",employee);
            response.sendRedirect("mon/items");
//            request.getRequestDispatcher("/mon/items").forward(request,response);
//            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/mon/items");
//            dispatcher.forward(request, response);
        }
    }
}
