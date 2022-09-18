package com.itfxl.bise.mapper;
import com.itfxl.bise.bean.Housecated;
import com.itfxl.bise.bean.Houseinforma;
import com.itfxl.bise.bean.Orders;
import com.itfxl.bise.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface Usermapper {
    User userlogin(User user);//登录查询
    int upshow(User user);//更新个人信息

    int userzhuce(User user);//用户注册

    User zhuceselect(User user);//用户注册查询

    int zhucexiugai(User user);//用户注册时修改密码

    int addorder(Orders orders);

    int uphouse(Houseinforma houseinforma);

    int addhousecated(Housecated housecated);

    List<Housecated> selecthousecated(Housecated housecated);

    int delhousecated(Housecated housecated);

    Orders seleorder(Orders orders);

    int uporder(Orders orders);
}
