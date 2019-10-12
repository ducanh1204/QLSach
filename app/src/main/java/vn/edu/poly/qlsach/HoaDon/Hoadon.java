package vn.edu.poly.qlsach.HoaDon;

public class Hoadon {
    public Hoadon() {
    }
    public static String [] Hoadon = new String[2];
    public String maHoaDon;
    public String ngayMua;

    public Hoadon(String maHoaDon, String ngayMua) {
        this.maHoaDon = maHoaDon;
        this.ngayMua = ngayMua;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }
}
