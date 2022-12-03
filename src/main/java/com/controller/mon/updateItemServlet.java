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

@WebServlet(name = "updateItemServlet", value = "/mon/capnhat")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
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
        String imgName = tenmon.replace(" ","_")+new Random().nextInt(1000);
        if(!AddImage.add(request,imgName)) imgName=null;
        Item item = new Item(id,tenmon,cateBO.GetCategoryById(DM),gia,mota,imgName);
        if(itemBO.updateItem(item))
            response.sendRedirect("items");
        else
            response.sendError(404,"Update Item Error");
    }
}
