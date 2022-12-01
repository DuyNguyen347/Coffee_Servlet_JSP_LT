package com.controller.danhmuc;

import com.model.bean.Category;
import com.model.bo.CategoryBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "addNewCategoryServlet", value = "/danhmuc/them")
public class addNewCategoryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryBO cateBO=new CategoryBO();
        String nameCategory = request.getParameter("nameCategory");
        Category cate = new Category(nameCategory);
        if(cateBO.AddNewCategory(cate))
            response.sendRedirect("categories");
        else
            response.sendError(404,"Add Category Error");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("formadddanhmuc.jsp");
        rd.forward(req,resp);
    }
}
