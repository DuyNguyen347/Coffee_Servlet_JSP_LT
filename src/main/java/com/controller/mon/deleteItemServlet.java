package com.controller.mon;

import com.model.bo.ItemBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deleteItemServlet", value = "/mon/xoa")
public class deleteItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ItemBO itemBO = new ItemBO();
        if(itemBO.deleteItem(id))
            response.sendRedirect("items");
        else
            response.sendError(404,"Delete Item Error");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
