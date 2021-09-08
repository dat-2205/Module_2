package model;

import java.util.List;

public class Bill {
    private List<BillElement> billElement;
    private String date;
    private double totalPayment;
    private String user;

    public Bill() {
    }

    public Bill(List<BillElement> billElement, String date, double totalPayment, String user) {
        this.billElement = billElement;
        this.date = date;
        this.totalPayment = totalPayment;
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<BillElement> getBillElement() {
        return billElement;
    }

    public void setBillElement(List<BillElement> billElement) {
        this.billElement = billElement;
    }

    @Override
    public String toString() {
        return  showBillElement() +
                " + Ngày mua: " + date + '\n' +
                " + Tổng thanh toán: " + totalPayment + "\n" +
                " + Tên người mua: " + user;
    }
    public String showBillElement() {
        String s = "";
        for(BillElement i : billElement) {
            s += i.toString() + "\n";
        }
        return s;
    }
}
