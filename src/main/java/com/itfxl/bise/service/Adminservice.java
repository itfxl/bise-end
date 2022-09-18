package com.itfxl.bise.service;

import com.itfxl.bise.bean.Admin;
import com.itfxl.bise.bean.Houseinforma;
import com.itfxl.bise.bean.Orders;
import com.itfxl.bise.bean.User;
import com.itfxl.bise.mapper.Adminmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class Adminservice {

    @Autowired
    Adminmapper adminmapper;

    public Admin adminlogin(Admin admin) {
        return adminmapper.adminlogin(admin);
    }

    public List<User> userselect(User user) {
        return adminmapper.userselect(user);
    }

    public int updateuser(User user) {
        return adminmapper.updateuser(user);
    }

    public int deluser(User user) {
        return adminmapper.deluser(user);
    }

    public List<Houseinforma> houseselect(Houseinforma houseinforma){
        return adminmapper.houseselect(houseinforma);
    }

    public int updatehouse(MultipartFile imgurl, Houseinforma houseinforma) throws IOException {
        int i = 0;
        String flieimg = System.getProperty("user.dir")+"/image/";
        UUID uuid=UUID.randomUUID();
        String originalFilename = imgurl.getOriginalFilename();
        String extendName = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
        String fileName = uuid.toString() + extendName;
        File dir = new File(flieimg, fileName);
        File filepath = new File(flieimg);
        if(!filepath.exists()){
            filepath.mkdirs();
        }
        imgurl.transferTo(dir);
        houseinforma.setImgurl("http://localhost:9376/image/"+fileName);
        i = adminmapper.updatehouse(houseinforma);
        return i;

    }

    public int addhouse(MultipartFile imgurl, Houseinforma houseinforma) throws IOException {
        int i = 0;
        String flieimg = System.getProperty("user.dir")+"/image/";
        UUID uuid=UUID.randomUUID();
        String originalFilename = imgurl.getOriginalFilename();
        String extendName = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
        String fileName = uuid.toString() + extendName;
        File dir = new File(flieimg, fileName);
        File filepath = new File(flieimg);
        if(!filepath.exists()){
            filepath.mkdirs();
        }
        imgurl.transferTo(dir);
        houseinforma.setImgurl("http://localhost:9376/image/"+fileName);
        i = adminmapper.addhouse(houseinforma);
        return i;
    }

    public int delhouse(Houseinforma houseinforma) {
        Orders order = new Orders();
        order.setHid(houseinforma.getHid());
        delorder(order);
        return adminmapper.delhouse(houseinforma);
    }

    public List<Orders> orderselect(Orders order) {
        return adminmapper.orderselect(order);
    }

    public int delorder(Orders order) {
        Houseinforma houseinforma = adminmapper.hstatusselect(order.getHid());
        houseinforma.setHstatus("0");
        int i = adminmapper.hstatusupdate(houseinforma);
        if(i!=0){
            return adminmapper.delorder(order);
        }else return i;
    }
}
