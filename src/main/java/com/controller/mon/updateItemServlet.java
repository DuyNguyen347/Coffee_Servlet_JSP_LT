package com.controller.mon;

import com.model.bean.Item;
import com.model.bo.CategoryBO;
import com.model.bo.ItemBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "updateItemServlet", value = "/mon/capnhat")
public class updateItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        ItemBO itemBO = new ItemBO();
        CategoryBO cateBO = new CategoryBO();
        request.setAttribute("categories",cateBO.GetCategories());
        request.setAttribute("item",itemBO.GetItemById(id));
        request.getRequestDispatcher("formupdatemon.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ItemBO itemBO = new ItemBO();
        CategoryBO cateBO = new CategoryBO();
        int id= Integer.parseInt(request.getParameter("id"));
        String tenmon = request.getParameter("tenmon");
        int DM = Integer.parseInt(request.getParameter("DM"));
        int gia = Integer.parseInt(request.getParameter("gia"));
        String mota = request.getParameter("mota");
        Item item = new Item(id,tenmon,cateBO.GetCategoryById(DM),gia,mota);
        if(itemBO.updateItem(item))
            response.sendRedirect("items");
        else
            response.sendError(404,"Update Item Error");
    }
}
