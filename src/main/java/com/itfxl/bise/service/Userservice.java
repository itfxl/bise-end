package com.itfxl.bise.service;

import com.itfxl.bise.bean.Housecated;
import com.itfxl.bise.bean.Houseinforma;
import com.itfxl.bise.bean.Orders;
import com.itfxl.bise.bean.User;
import com.itfxl.bise.mapper.Adminmapper;
import com.itfxl.bise.mapper.Usermapper;
import org.apache.catalina.startup.HomesUserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.UUID;

@Service
public class Userservice {

    @Autowired
    Usermapper usermapper;
    @Autowired
    Adminmapper adminmapper;

    public User userlogin(User user) {
        return usermapper.userlogin(user);
    }

    public int upshow(MultipartFile imgurl, User user) throws IOException {
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
        user.setImgurl("http://localhost:9376/image/"+fileName);
        i = usermapper.upshow(user);
        return i;
    }

    public int userzhuce(User user) {
        User user1 = usermapper.zhuceselect(user);
        if (user1 == null){
            return usermapper.userzhuce(user);
        }else{
            return 0;
        }
    }
    public int zhucexiugai(User user) {
        User user1 = usermapper.zhuceselect(user);
        if (user1 != null){
            return usermapper.zhucexiugai(user);
        }else{
            return 0;
        }
    }

    public int addorder(Orders orders) {
        Houseinforma houseinforma = new Houseinforma();
        houseinforma.setHid(orders.getHid());
        usermapper.uphouse(houseinforma);
        if(usermapper.seleorder(orders) != null){
            orders.setState("0");
            return adminmapper.delorder(orders);
        }else {
            return usermapper.addorder(orders);
        }
    }

    public int addhousecated(Housecated housecated) {
        return usermapper.addhousecated(housecated);
    }

    public List<Housecated> selecthousecated(Housecated housecated) {
        return usermapper.selecthousecated(housecated);
    }

    public int delhousecated(Housecated housecated) {
        return usermapper.delhousecated(housecated);
    }

    public int uporder(Orders orders) {
        return usermapper.uporder(orders);
    }
}
