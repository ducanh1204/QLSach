package vn.edu.poly.qlsach.Model;

public class Nguoidung {
    String name;
    String id;
    String password;
    String phonenumber;
    String address;

    public Nguoidung(String name, String id, String password, String phonenumber, String address) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.phonenumber = phonenumber;
        this.address = address;
    }
    public Nguoidung() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
