package com.controller.danhmuc;

import com.model.bo.CategoryBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "displayCategoryServlet", value = "/danhmuc/category")
public class displayCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryBO cateBO=new CategoryBO();
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("category",cateBO.GetCategoryById(id));
        RequestDispatcher rd = request.getRequestDispatcher("displayCategory.jsp");
        rd.forward(request,response);
    }
}
