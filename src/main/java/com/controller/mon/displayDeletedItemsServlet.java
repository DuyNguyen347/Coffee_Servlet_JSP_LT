package com.controller.mon;

import com.model.bo.ItemBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "displayDeletedItemsServlet", value = "/mon/deleted-items")
public class displayDeletedItemsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ItemBO itemBO = new ItemBO();
        request.setAttribute("items",itemBO.getDeletedItems(0,10));
        request.getRequestDispatcher("displayItems.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
