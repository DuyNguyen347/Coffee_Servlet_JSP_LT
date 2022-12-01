package com.controller.danhmuc;


import com.model.bo.CategoryBO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "deleteCategoryServlet", value = "/danhmuc/xoa")
public class deleteCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CategoryBO cateBO = new CategoryBO();
        if(cateBO.deleteCategory(id))
            response.sendRedirect("categories");
        else
            response.sendError(404,"Delete Category Error");
    }
}
