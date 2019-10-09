package vn.edu.poly.qlsach.HoaDonChiTiet;

public class HDCT {
    public HDCT() {
    }
    public String maHDCT;
    public String maHD;
    public String maSach;
    public int soLuong;

    public HDCT(String maHDCT, String maHD, String maSach, int soLuong) {
        this.maHDCT = maHDCT;
        this.maHD = maHD;
        this.maSach = maSach;
        this.soLuong = soLuong;
    }

    public String getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(String maHDCT) {
        this.maHDCT = maHDCT;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
