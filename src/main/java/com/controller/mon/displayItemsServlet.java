package com.controller.mon;

import com.model.bo.ItemBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "displayItemsServlet", value = "/mon/items")
public class displayItemsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ItemBO itemBO = new ItemBO();
        request.setAttribute("items",itemBO.getItems(0,10));
        request.getRequestDispatcher("quanlymon.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ItemBO itemBO = new ItemBO();
        request.setAttribute("items",itemBO.getItems(0,10));
        request.getRequestDispatcher("quanlymon.jsp").forward(request,response);
    }
}
