package com.itfxl.bise.controller;

import com.itfxl.bise.bean.Housecated;
import com.itfxl.bise.bean.Houseinforma;
import com.itfxl.bise.bean.Orders;
import com.itfxl.bise.bean.User;
import com.itfxl.bise.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class Usercontroller {
    @Autowired
    Userservice userservice;


    /**
     * 用户的登录
     * @param user
     * @return
     */
    @RequestMapping("/userlogin")
    public Map<String, Object> userlogin(@RequestBody User user){
        Map<String, Object> map = new HashMap<>();
        User user1 = userservice.userlogin(user);
        if (user1!=null){
            map.put("userData",user1);
            map.put("code",1);
        }else map.put("code",0);
        return map;
    }

    /**
     * 用户注册账号
     * @param
     * @return
     */
    @RequestMapping("/userzhuce")
    public Map<String, Object> userzhuce(@RequestBody User user){
        Map<String, Object> map = new HashMap<>();
        int i = userservice.userzhuce(user);
        map.put("code",i);
        return map;
    }

    /**
     * 用户更新个人信息
     * @param
     * @return
     */
    @RequestMapping("/upshow")
    public Map<String, Object> upshow(@RequestParam("imgurl") MultipartFile imgurl, @RequestParam Map<String,String> map) throws IOException {
        Map<String,Object> mp = new HashMap<>();
        if(map.size()>0){
            User user = new User();
            user.setId(Integer.parseInt(map.get("id")));
            user.setAccount(map.get("account"));
            user.setPassword(map.get("password"));
            user.setPhone(map.get("phone"));
            user.setUsername(map.get("username"));
            System.out.println(user);
            int i = userservice.upshow(imgurl,user);
            mp.put("code",i);
        }
        return mp;
    }

    /**
     * 用户注册账号时密码修改
     * @param
     * @return
     */
    @RequestMapping("/zhucexiugai")
    public Map<String, Object> zhucexiugai(@RequestBody User user){
        Map<String, Object> map = new HashMap<>();
        int i = userservice.zhucexiugai(user);
        map.put("code",i);
        return map;
    }
    /**
     * 用户的添加点单
     * @param
     * @return
     */
    @RequestMapping("/addorder")
    public Map<String, Object> addorder(@RequestBody Orders orders){
        Map<String,Object> map = new HashMap<>();
        System.out.println(orders);
        int i = userservice.addorder(orders);
        map.put("code",i);
        return map;
    }
    /**
     * 用户的添加房屋猎聘
     * @param
     * @return
     */
    @RequestMapping("/addhousecated")
    public Map<String, Object> addhousecated(@RequestBody Housecated housecated){
        Map<String,Object> map = new HashMap<>();
        System.out.println(housecated);
        int i = userservice.addhousecated(housecated);
        map.put("code",i);
        return map;
    }
    /**
     * 用户的查询房屋猎聘
     * @param
     * @return
     */
    @RequestMapping("/selecthousecated")
    public Map<String, Object> selecthousecated(@RequestBody Housecated housecated){
        Map<String,Object> map = new HashMap<>();
        List<Housecated> housecateds = userservice.selecthousecated(housecated);
        if (housecateds != null){
            map.put("code",1);
            map.put("housecateds",housecateds);
        }
        System.out.println(housecateds);
        return map;
    }
    /**
     * 用户的删除房屋猎聘
     * @param
     * @return
     */
    @RequestMapping("/delhousecated")
    public Map<String, Object> delhousecated(@RequestBody Housecated housecated){
        Map<String,Object> map = new HashMap<>();
        System.out.println(housecated);
        int i = userservice.delhousecated(housecated);
        map.put("code",i);
        return map;
    }
    /**
     * 用户的添加房屋评价
     * @param
     * @return
     */
    @RequestMapping("/uporder")
    public Map<String, Object> uporder(@RequestBody Orders orders){
        Map<String,Object> map = new HashMap<>();
        System.out.println(orders);
        int i = userservice.uporder(orders);
        map.put("code",i);
        return map;
    }

}
