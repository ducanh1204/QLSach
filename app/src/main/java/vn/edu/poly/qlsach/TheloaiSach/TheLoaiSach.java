package vn.edu.poly.qlsach.TheloaiSach;

public class TheLoaiSach {
    public TheLoaiSach(){

    }

    public String maTheLoai;
    public String tenTheLoai;
    public int vitri;
    public String moTa;

    public TheLoaiSach(String maTheLoai, String tenTheLoai, int vitri, String moTa) {
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
        this.vitri = vitri;
        this.moTa = moTa;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public int getVitri() {
        return vitri;
    }

    public void setVitri(int vitri) {
        this.vitri = vitri;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
