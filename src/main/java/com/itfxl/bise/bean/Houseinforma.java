package com.itfxl.bise.bean;

public class Houseinforma {
    int id;
    int hid;//房屋表id
    String address;//房屋地址
    int price;//房屋价格
    String htime;//房屋上架时间
    String hdescription;//房屋描述
    String rtstatus;//房屋时间
    String hstatus;//房屋出售状态
    String imgurl;//房屋图片
    String account;//发售用户的账号
    String phone;//发售用户的电话
    String state; //状态：0:未完成，1：已完成，2：订单交易失败
    String evaluation;//评价

    @Override
    public String toString() {
        return "Houseinforma{" +
                "id=" + id +
                ", hid=" + hid +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", htime='" + htime + '\'' +
                ", hdescription='" + hdescription + '\'' +
                ", rtstatus='" + rtstatus + '\'' +
                ", hstatus='" + hstatus + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", account='" + account + '\'' +
                ", phone='" + phone + '\'' +
                ", state='" + state + '\'' +
                ", evaluation='" + evaluation + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getHtime() {
        return htime;
    }

    public void setHtime(String htime) {
        this.htime = htime;
    }

    public String getHdescription() {
        return hdescription;
    }

    public void setHdescription(String hdescription) {
        this.hdescription = hdescription;
    }

    public String getRtstatus() {
        return rtstatus;
    }

    public void setRtstatus(String rtstatus) {
        this.rtstatus = rtstatus;
    }

    public String getHstatus() {
        return hstatus;
    }

    public void setHstatus(String hstatus) {
        this.hstatus = hstatus;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }
}
