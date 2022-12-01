package com.model.bean;

import java.sql.Timestamp;
import java.util.Date;

public class Category {
    private int id;
    public String tenDM;
    private Timestamp CreateAt;

    public void setId(int id) {
        this.id = id;
    }

    public String getTenDM() {
        return tenDM;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
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

    private Timestamp UpdateAt;
    private Timestamp DeleteAt;
    public  Category(String tenDM){
        this.tenDM=tenDM;
    }
    public Category(int id,String tenDM){
        this.id=id;
        this.tenDM=tenDM;
    }
    public Category(int id,String tenDM,Timestamp CreateAt,Timestamp UpdateAt,Timestamp DeleteAt){
        this.id=id;
        this.tenDM=tenDM;
        this.CreateAt=CreateAt;
        this.UpdateAt=UpdateAt;
        this.DeleteAt=DeleteAt;
    }

    public int getId() {
        return id;
    }
    public String toString(){
        return tenDM;
    }
    public Date getCreateAt(){
        return CreateAt;
    }
    public Date getDeleteAt() {
        return DeleteAt;
    }
    public Date getUpdateAt() {
        return UpdateAt;
    }
}
