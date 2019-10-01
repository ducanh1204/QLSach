package vn.edu.poly.qlsach.Sach;

public class Sach {
    public Sach() {
    }

    public String maSach;
    public String maTLSach;
    public String tenSach;
    public String tacGia;
    public String nxb;
    public String soLuong;
    public String giaBia;

    public Sach(String maSach, String maTLSach, String tenSach, String tacGia, String nxb, String soLuong, String giaBia) {
        this.maSach = maSach;
        this.maTLSach = maTLSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.nxb = nxb;
        this.soLuong = soLuong;
        this.giaBia = giaBia;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaTLSach() {
        return maTLSach;
    }

    public void setMaTLSach(String maTLSach) {
        this.maTLSach = maTLSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getGiaBia() {
        return giaBia;
    }

    public void setGiaBia(String giaBia) {
        this.giaBia = giaBia;
    }
}
