package com.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AddImage {
    public static boolean add(HttpServletRequest request,String namefile) throws ServletException, IOException {

        Part filePart = request.getPart("img"); // Retrieves <input type="file" name="file">
        BufferedInputStream bis = new BufferedInputStream(filePart.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(GetRootPath.RootPathImg() +namefile+".png"));
        BufferedOutputStream bos2 = new BufferedOutputStream(new FileOutputStream(GetRootPath.RootPathImg_() +namefile+".png"));
        int c=bis.read();
        if(c==-1){
            return false;
        }
        do {
            bos.write(c);
            bos2.write(c);
        }
        while ((c=bis.read())!=-1);
        bis.close();
        bos.close();
        bos2.close();
        return true;
    }
}