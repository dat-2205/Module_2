package com.codegym;

public class BienLai {
    private KhachHang khachHang;
    private double oldElectricNumber;
    private double newElectricNumber;
    private double totalBill;

    public BienLai() {
    }
    public BienLai(KhachHang khachHang, double oldElectricNumber, double newElectricNumber) {
        this.khachHang = khachHang;
        this.oldElectricNumber = oldElectricNumber;
        this.newElectricNumber = newElectricNumber;
        this.totalBill = totalBill;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public double getOldElectricNumber() {
        return oldElectricNumber;
    }

    public void setOldElectricNumber(double oldElectricNumber) {
        this.oldElectricNumber = oldElectricNumber;
    }

    public double getNewElectricNumber() {
        return newElectricNumber;
    }

    public void setNewElectricNumber(double newElectricNumber) {
        this.newElectricNumber = newElectricNumber;
    }

    public double getTotalBill() {
        return (newElectricNumber-oldElectricNumber)*750;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }
    @Override
    public String toString() {
        return "BienLai{" +
                "khachHang=" + khachHang +
                ", oldElectricNumber=" + oldElectricNumber +
                ", newElectricNumber=" + newElectricNumber +
                ", totalBill=" + totalBill +
                '}';
    }
}
