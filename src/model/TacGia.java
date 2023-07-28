package model;

import controller.TacGiaDAO;

import java.sql.Date;
import java.util.Scanner;

public class TacGia {
    private String maTacGia;
    private String hoVaTen;
    private Date ngaySinh;
    private String tieuSu;

    public TacGia() {}

    public TacGia(String maTacGia, String hoVaTen, Date ngaySinh, String tieuSu) {
        this.maTacGia = maTacGia;
        this.hoVaTen = ChuanHoa.chuanHoaTen(hoVaTen);
        this.ngaySinh = ngaySinh;
        this.tieuSu = tieuSu;
    }

    public String getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(String maTacGia) {
        this.maTacGia = maTacGia;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getTieuSu() {
        return tieuSu;
    }

    public void setTieuSu(String tieuSu) {
        this.tieuSu = tieuSu;
    }

    public void input(String mtg){
        Scanner sc = new Scanner(System.in);
        setMaTacGia(mtg);
        System.out.println("Nhập họ tên tác giả :");
        setHoVaTen(sc.nextLine());
        System.out.println("Nhập ngày sinh tác giả (yyyy-mm-dd) : ");
        String birth = sc.nextLine();
        while (!ChuanHoa.checkNgaySinh(birth)){
            System.out.println("Nhập sai, nhập lại :");
            birth = sc.nextLine();
        }
        setNgaySinh(Date.valueOf(birth));
        System.out.println("Nhập tiểu sử tác giả : ");
        setTieuSu(sc.nextLine());
        new TacGiaDAO().insert(this);
    }

    @Override
    public String toString() {
        return "maTacGia='" + maTacGia + '\'' +
                ", hoVaTen='" + hoVaTen + '\'' +
                ", ngaySinh=" + ngaySinh +
                ", tieuSu='" + tieuSu;
    }
}
