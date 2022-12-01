package com.controller.danhmuc;

import com.model.bean.Category;
import com.model.bo.CategoryBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "updateCategoryServlet", value = "/danhmuc/capnhat")
public class updateCategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryBO cateBO=new CategoryBO();
        int id = Integer.parseInt(request.getParameter("id"));
        String nameCategory = request.getParameter("nameCategory");
        Category cate = new Category(id,nameCategory);
        if(cateBO.updateCategory(cate))
            response.sendRedirect("categories");
        else
            response.sendError(404,"Update Category Error");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CategoryBO cateBO = new CategoryBO();
        request.setAttribute("category",cateBO.GetCategoryById(id));
        RequestDispatcher rd = request.getRequestDispatcher("updatedanhmuc.jsp");
        rd.forward(request,response);
    }
}
