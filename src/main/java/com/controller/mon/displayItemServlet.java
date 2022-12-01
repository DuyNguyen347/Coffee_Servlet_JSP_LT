package com.controller.mon;

import com.model.bo.ItemBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "displayItemServlet", value = "/mon/item")
public class displayItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ItemBO itemBO = new ItemBO();
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("item",itemBO.GetItemById(id));
        request.getRequestDispatcher("quanlymon.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
