package com.model.bo;

import com.model.bean.Bill;
import com.model.bean.InforItem;
import com.model.dao.BillDAO;
import com.model.dao.InforDAO;

import java.util.ArrayList;
import java.util.List;

public class BillBO {
    BillDAO billDAO;
    InforDAO inforDAO;
    public BillBO(){
        billDAO = new BillDAO();
        inforDAO = new InforDAO();
    }
    public Bill GetBillById(int id){
        return billDAO.getBillByID(id);
    }
    public List<Bill> GetBills(int f,int t){
        List<Bill> bills = billDAO.getAllBills();
        List<Bill> bills_ = new ArrayList<>();
        int x=(t>bills.size())?bills.size():t;
        for(int i=f;bills_.size()<=x && i<bills.size();i++){
            if(bills.get(i).getDeleteAt()==null)
                bills_.add(bills.get(i));
        }
        return bills_;
    }
    public List<Bill> GetDeletedBills(int f,int t){
        List<Bill> bills = billDAO.getAllBills();
        List<Bill> bills_ = new ArrayList<>();
        int x=(t>bills.size())?bills.size():t;
        for(int i=f;bills_.size()<=x && i<bills.size();i++){
            if(bills.get(i).getDeleteAt()!=null)
                bills_.add(bills.get(i));
        }
        return bills_;
    }
    public boolean AddNewBill(Bill bill){
        try {
            int id = billDAO.addNewBill(bill);
            for (InforItem i: bill.items) {
                inforDAO.addNewInfor(id,i);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public boolean updateBill(Bill bill){
        billDAO.updateBill(bill);
        return true;
    }
    public boolean deleteBill(int id){
        return billDAO.deleteBill(id);
    }
}
