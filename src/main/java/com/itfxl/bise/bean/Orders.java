package com.itfxl.bise.bean;

public class Orders {
    int id; //订单id
    int hid;//房屋id
    String account;//下单人用户账号
    String state; //状态：0:未完成，1：已完成，2：订单交易失败
    String evaluation;//评价

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", hid=" + hid +
                ", account='" + account + '\'' +
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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
