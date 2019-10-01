package vn.edu.poly.qlsach.TheloaiSach;

public class TheLoaiSach {

    public String maTheLoai;
    public String tenTheLoai;
    public String moTa;
    public int vitri;

    public TheLoaiSach(String maTheLoai, String tenTheLoai, String moTa, int vitri) {
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
        this.moTa = moTa;
        this.vitri = vitri;
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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getVitri() {
        return vitri;
    }

    public void setVitri(int vitri) {
        this.vitri = vitri;
    }
}
