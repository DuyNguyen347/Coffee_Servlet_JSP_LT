package com.controller.danhmuc;

import com.model.bo.CategoryBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "displayCategoriesServlet", value = "/danhmuc/categories")
public class displayCategoriesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryBO cateBO=new CategoryBO();
        request.setAttribute("listCate",cateBO.GetCategories(0,10));
        RequestDispatcher rd = request.getRequestDispatcher("quanlydanhmuc.jsp");
        rd.forward(request,response);
    }

}
