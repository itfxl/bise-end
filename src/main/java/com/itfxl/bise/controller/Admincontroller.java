package com.itfxl.bise.controller;

import com.itfxl.bise.bean.Admin;
import com.itfxl.bise.bean.Houseinforma;
import com.itfxl.bise.bean.Orders;
import com.itfxl.bise.bean.User;
import com.itfxl.bise.service.Adminservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class Admincontroller {

    @Autowired
     Adminservice adminservice;

    /**
     * 管理员登录
     * @param
     * @return
     */
    @RequestMapping("/adminlogin")
    public Map<String, Object> adminlogin(@RequestBody Admin admin){
        Map<String,Object> map = new HashMap<>();
        Admin admin1 = adminservice.adminlogin(admin);
        if(admin1!=null){
            map.put("code",1);
            map.put("admin",admin1);
        }else map.put("code",0);
        return map;
    }

    /**
     * 管理员用户管理的查询
     * @param
     * @return
     */
    @RequestMapping("/userselect")
    public Map<String, Object> userselect(@RequestBody User user){
        Map<String,Object> map = new HashMap<>();
        List<User> users = adminservice.userselect(user);
        if(users!=null){
            map.put("code",1);
            map.put("users",users);
        }else map.put("code",0);
        return map;
    }

    /**
     * 管理员用户管理的修改
     * @param
     * @return
     */
    @RequestMapping("/updateuser")
    public Map<String, Object> updateuser(@RequestBody User user){
        Map<String,Object> map = new HashMap<>();
        int i = adminservice.updateuser(user);
        map.put("code",i);
        return map;
    }

    /**
     * 管理员用户管理的删除
     * @param
     * @return
     */
    @RequestMapping("/deluser")
    public Map<String, Object> deluser(@RequestBody User user){
        Map<String,Object> map = new HashMap<>();
        int i = adminservice.deluser(user);
        map.put("code",i);
        return map;
    }

    /**
     * 管理员的房屋信息查询
     * @param houseinforma
     * @return
     */
    @RequestMapping("/houseselect")
    public Map<String, Object> houseselect(@RequestBody Houseinforma houseinforma){
        Map<String, Object> map =new HashMap<>();
        List<Houseinforma> house = adminservice.houseselect(houseinforma);
        map.put("house", house);
        return map;
    }

    /**
     * 管理员的修改房屋信息
     * @param imgurl
     * @param map
     * @return
     * @throws IOException
     */
    @RequestMapping("/updatehouse")
    public Map<String, Object> updatehouse(@RequestParam("imgurl") MultipartFile imgurl, @RequestParam Map<String,String> map) throws IOException {
        Map<String,Object> mp = new HashMap<>();
        System.out.println(map.get("address"));
        if(map.size()>0){
            Houseinforma houseinforma = new Houseinforma();
            houseinforma.setAddress(map.get("address"));
            houseinforma.setPrice(Integer.parseInt(map.get("price")));
            houseinforma.setHdescription(map.get("hdescription"));
            houseinforma.setHtime(map.get("htime"));
            houseinforma.setRtstatus(map.get("rtstatus"));
            houseinforma.setHstatus(map.get("hstatus"));
            System.out.println(houseinforma.toString());
            int i = adminservice.updatehouse(imgurl,houseinforma);
            mp.put("code",i);
        }
        return mp;
    }

    /**
     * 添加房屋信息
     * @param
     * @return
     */
    @RequestMapping("/addhouse")
    public Map<String, Object> addhouse(@RequestParam("imgurl") MultipartFile imgurl, @RequestParam Map<String,String> map) throws IOException {
        Map<String,Object> mp = new HashMap<>();
        Houseinforma houseinforma = new Houseinforma();
        if(map.size()>0){
            houseinforma.setHdescription(map.get("hdescription"));
            houseinforma.setAddress(map.get("address"));
            houseinforma.setPrice(Integer.parseInt(map.get("price")));
            houseinforma.setAccount(map.get("account"));
            houseinforma.setPhone(map.get("phone"));
            houseinforma.setRtstatus(map.get("rtstatus"));
            System.out.println(houseinforma);
            int i = adminservice.addhouse(imgurl,houseinforma);
            mp.put("code",i);
        }
        return mp;
    }

    /**
     * 删除房屋信息
     * @param
     * @return
     */
    @RequestMapping("/delhouse")
    public Map<String, Object> delhouse(@RequestBody Houseinforma houseinforma){
        Map<String,Object> map = new HashMap<>();
        int i = adminservice.delhouse(houseinforma);
        map.put("code",i);
        return map;
    }

    /**
     * 管理员的订单查询
     * @param
     * @return
     */
    @RequestMapping("/orderselect")
    public Map<String, Object> orderselect(@RequestBody Orders order){
        Map<String,Object> map = new HashMap<>();
        List<Orders> orders= adminservice.orderselect(order);
        System.out.println(orders);
        if(orders!=null){
            map.put("code",1);
            map.put("orders",orders);
        }else map.put("code",0);
        return map;
    }

    /**
     * 管理员的订单删除
     * @param
     * @return
     */
    @RequestMapping("/delorder")
    public Map<String, Object> delorder(@RequestBody Orders order){
        Map<String,Object> map = new HashMap<>();
        int i = adminservice.delorder(order);
        map.put("code",i);
        System.out.println(map);
        return map;
    }


}
