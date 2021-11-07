package com.cql.config;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

public class MyFileUpload {

    public static String getUploadFileLoader(HttpServletRequest request,MultipartFile file){
        String realPath=request.getSession().getServletContext().getRealPath("/img/");

        File picFolder=new File(realPath);
        if(!picFolder.exists()){
            picFolder.mkdirs();
        }

        String oldPicName=file.getOriginalFilename();
        String newPicName= UUID.randomUUID().toString()+
                oldPicName.substring(oldPicName.lastIndexOf("."),oldPicName.length());

        try {
            file.transferTo(new File(picFolder,newPicName));
        }catch (Exception e){
            e.printStackTrace();
        }

        String picPath=request.getScheme()
                +"://"+request.getServerName()
                +":"+request.getServerPort()
                +"/img/"+newPicName;
        return picPath;
    }
}
