package vn.edu.poly.qlsach.NguoiDung;

public class Nguoidung {


    String id;
    String name;
    String password;
    String phoneNumber;
    String address;

    public Nguoidung(String id, String name, String password, String phoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
