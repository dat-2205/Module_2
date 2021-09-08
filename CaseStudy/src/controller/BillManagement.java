package controller;

import model.Bill;

import java.util.List;

public class BillManagement {
    private List<Bill> billList;

    public BillManagement(List<Bill> billList) {
        this.billList = billList;
    }

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    public double getMonthlyRevenue(String date) {
        double revenue = 0;
        for(Bill b: billList){
            String checkDate = b.getDate().substring(3,9);
            if(checkDate.equals(date)){
                revenue += b.getTotalPayment();
            }
        }
        return revenue;
    }
    public int findByDate(String date) {
        for(int i=0;i<billList.size();i++) {
            String checkDate = billList.get(i).getDate().substring(3,9);
            if(checkDate.equals(date)){
                return i;
            }
        }
        return -1;
    }
}
