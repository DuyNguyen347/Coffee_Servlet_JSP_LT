package com.controller.mon;

import com.model.bean.Item;
import com.model.bo.CategoryBO;
import com.model.bo.ItemBO;
import com.utils.AddImage;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "addNewItemServlet", value = "/mon/them")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
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
        String imgName = tenmon.replace(" ","_")+new Random().nextInt(1000);
        if(!AddImage.add(request,imgName)) imgName=null;
        Item item = new Item(tenmon,cateBO.GetCategoryById(DM),gia,mota,imgName);
        if(itemBO.AddNewItem(item))
            response.sendRedirect("items");
        else
            response.sendError(404,"Add Item Error");
    }
}
