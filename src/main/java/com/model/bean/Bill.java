package com.model.bean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Bill {
    private int id;
    public String tenkhachhang;
    public String sodienthoai;
    public int chietkhau;
    private Timestamp CreateAt;
    private Timestamp UpdateAt;
    private Timestamp DeleteAt;
    public List<InforItem> items;
    public int thanhtoan;
    public int getId() {
        return id;
    }

    public Timestamp getCreateAt() {
        return CreateAt;
    }

    public Timestamp getDeleteAt() {
        return DeleteAt;
    }

    public Timestamp getUpdateAt() {
        return UpdateAt;
    }
    public Bill(){

    }
    public Bill(int id, List<InforItem> items, String tenkhachhang, String sodienthoai, int chietkhau, Timestamp CreateAt, Timestamp UpdateAt, Timestamp DeleteAt,int thanhtoan) {
        this.id = id;
        this.tenkhachhang = tenkhachhang;
        this.sodienthoai = sodienthoai;
        this.chietkhau = chietkhau;
        this.CreateAt = CreateAt;
        this.UpdateAt = UpdateAt;
        this.DeleteAt = DeleteAt;
        this.items = items;
        this.thanhtoan = thanhtoan;
    }
}
