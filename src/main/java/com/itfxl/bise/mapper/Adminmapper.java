package com.itfxl.bise.mapper;

import com.itfxl.bise.bean.Admin;
import com.itfxl.bise.bean.Houseinforma;
import com.itfxl.bise.bean.Orders;
import com.itfxl.bise.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Adminmapper {
    List<Houseinforma> houseselect(Houseinforma houseinforma);//查询所用的租房信息

    int updatehouse(Houseinforma houseinforma);

    int addhouse(Houseinforma houseinforma);

    int delhouse(Houseinforma houseinforma);

    Admin adminlogin(Admin admin);

    List<User> userselect(User user);

    int updateuser(User user);

    int deluser(User user);

    List<Orders> orderselect(Orders order);

    int delorder(Orders order);

    Houseinforma hstatusselect(int id);

    int hstatusupdate(Houseinforma houseinforma);
}
