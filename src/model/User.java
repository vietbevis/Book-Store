package model;

import java.sql.Date;

public class User {
    private String id;
    private String hoVaTen;
    private Date ngaySinh;
    private String diaChi;
    private String soDienThoai;
    private String email;

    public User() {}

    public User(String id, String hoVaTen, Date ngaySinh, String diaChi, String soDienThoai, String email) {
        this.id = id;
        this.hoVaTen = ChuanHoa.chuanHoaTen(hoVaTen);
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = ChuanHoa.chuanHoaTen(hoVaTen);
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", hoVaTen='" + hoVaTen + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", diaChi='" + diaChi + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", email='" + email;
    }
}
