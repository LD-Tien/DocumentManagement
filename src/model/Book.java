/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * HoTen: LeDucTien
 * MSV: 2050531200309
 * LHP: 221LTJNC01
 */
public class Book extends Document {
    String tenTG;
    int soTrang;

    public Book(String tenTG, int soTrang, String maTaiLieu, String tenNXB, String Loai, int soBanPhatHanh) {
        super(maTaiLieu, tenNXB, Loai, soBanPhatHanh);
        this.tenTG = tenTG;
        this.soTrang = soTrang;
    }

    public Book() {
    }

    
    
    public String getTenTG() {
        return tenTG;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public String getMaTaiLieu() {
        return maTaiLieu;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public int getSoBanPhatHanh() {
        return soBanPhatHanh;
    }

    public void setTenTG(String tenTG) {
        this.tenTG = tenTG;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public void setMaTaiLieu(String maTaiLieu) {
        this.maTaiLieu = maTaiLieu;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public void setSoBanPhatHanh(int soBanPhatHanh) {
        this.soBanPhatHanh = soBanPhatHanh;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String Loai) {
        this.Loai = Loai;
    }
    
    
}
