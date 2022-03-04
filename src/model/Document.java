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
public class Document {
    String maTaiLieu;
    String tenNXB;
    String Loai;
    int soBanPhatHanh;

    public Document(String maTaiLieu, String tenNXB, String Loai, int soBanPhatHanh) {
        this.maTaiLieu = maTaiLieu;
        this.tenNXB = tenNXB;
        this.Loai = Loai;
        this.soBanPhatHanh = soBanPhatHanh;
    }

    public Document() {
        
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

    @Override
    public String toString() {
        return "TaiLieu{" + "maTaiLieu=" + maTaiLieu + ", tenNXB=" + tenNXB + ", soBanPhatHanh=" + soBanPhatHanh + '}';
    }
}
