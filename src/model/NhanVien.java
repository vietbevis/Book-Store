package model;

import controller.NhanVienDAO;

import java.sql.Date;
import java.util.Scanner;

public class NhanVien extends User{
    private int soDonBanDuoc;

    public NhanVien() {}

    public NhanVien(String id, String hoVaTen, Date ngaySinh, String diaChi, String soDienThoai, String email, int soDonBanDuoc) {
        super(id, hoVaTen, ngaySinh, diaChi, soDienThoai, email);
        this.soDonBanDuoc = soDonBanDuoc;
    }

    public int getSoDonBanDuoc() {
        return soDonBanDuoc;
    }

    public void setSoDonBanDuoc(int soDonBanDuoc) {
        this.soDonBanDuoc = soDonBanDuoc;
    }

    public void input(String maNhanVien){
        setId(maNhanVien);
        System.out.println("Đăng ký thông tin : ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập họ và tên : ");
        setHoVaTen(sc.nextLine());
        System.out.println("Nhập ngày sinh (yyyy-mm-dd) : ");
        String birth = sc.nextLine();
        while (!ChuanHoa.checkNgaySinh(birth)){
            System.out.println("Nhập sai, nhập lại :");
            birth = sc.nextLine();
        }
        setNgaySinh(Date.valueOf(birth));
        System.out.println("Nhập địa chỉ :");
        setDiaChi(sc.nextLine());
        System.out.println("Nhập số điện thoại (10 chữ số) : ");
        String sdt = sc.nextLine();
        while (!ChuanHoa.checkSDT(sdt)){
            System.out.println("Nhập sai, nhập lại :");
            sdt = sc.nextLine();
        }
        setSoDienThoai(sdt);
        System.out.println("Nhập email : ");
        setEmail(sc.nextLine());
        new NhanVienDAO().insert(this);

        System.out.println("Đăng Ký Thành Công !");
    }

    @Override
    public String toString() {
        return super.toString() + '\'' +
                "soDonBanDuoc=" + soDonBanDuoc;
    }
}
