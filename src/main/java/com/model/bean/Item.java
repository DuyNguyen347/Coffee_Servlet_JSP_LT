package com.model.bean;


import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Item {
    private int id;
    public String tenmon;
    public Category DM;
    public int gia;
    public String mota;

    public void setId(int id) {
        this.id = id;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public Category getDM() {
        return DM;
    }

    public void setDM(Category DM) {
        this.DM = DM;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public void setCreateAt(Timestamp createAt) {
        CreateAt = createAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        UpdateAt = updateAt;
    }

    public void setDeleteAt(Timestamp deleteAt) {
        DeleteAt = deleteAt;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    private Timestamp CreateAt;
    private Timestamp UpdateAt;
    private Timestamp DeleteAt;
    public byte[] img;
    public Item(String tenmon,Category DM,int gia,String mota){
        this.tenmon=tenmon;
        this.DM=DM;
        this.gia=gia;
        this.mota=mota;
    }
    public Item(String tenmon,Category DM,int gia,String mota,byte[] img){
        this.tenmon=tenmon;
        this.DM=DM;
        this.gia=gia;
        this.mota=mota;
        this.img=img;
    }
    public Item(int id,String tenmon,Category DM,int gia,String mota,Timestamp createAt,Timestamp updateAt,Timestamp deleteAt){
        this.id=id;
        this.tenmon=tenmon;
        this.DM=DM;
        this.gia=gia;
        this.mota=mota;
        this.CreateAt=createAt;
        this.UpdateAt=updateAt;
        this.DeleteAt=deleteAt;
    }

    public Item(int id , String tenmon, Category DM, int gia, String mota) {
        this.id=id;
        this.tenmon=tenmon;
        this.DM=DM;
        this.gia=gia;
        this.mota=mota;
    }

    public int getId() {
        return id;
    }
    public Timestamp getCreateAt(){
        return CreateAt;
    }
    public Timestamp getDeleteAt() {
        return DeleteAt;
    }
    public Timestamp getUpdateAt() {
        return UpdateAt;
    }
}
