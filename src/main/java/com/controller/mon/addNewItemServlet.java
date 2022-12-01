package com.controller.mon;

import com.model.bean.Item;
import com.model.bo.CategoryBO;
import com.model.bo.ItemBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addNewItemServlet", value = "/mon/them")
public class addNewItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryBO cateBO = new CategoryBO();
        request.setAttribute("categories",cateBO.GetCategories());
        request.getRequestDispatcher("formaddmon.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ItemBO itemBO = new ItemBO();
        CategoryBO cateBO = new CategoryBO();
        String tenmon = request.getParameter("tenmon");
        int DM = Integer.parseInt(request.getParameter("DM"));
        int gia = Integer.parseInt(request.getParameter("gia"));
        String mota = request.getParameter("mota");
        Item item = new Item(tenmon,cateBO.GetCategoryById(DM),gia,mota);
        if(itemBO.AddNewItem(item))
            response.sendRedirect("items");
        else
            response.sendError(404,"Add Item Error");
    }
}
