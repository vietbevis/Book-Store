package model;

import controller.KhachHangDAO;
import controller.NhanVienDAO;

import java.sql.Date;
import java.util.Scanner;

public class KhachHang extends User {
    private int diemThuong;
    private NhanVien nhanVien;

    public KhachHang() {

    }

    public KhachHang(String id, String hoVaTen, Date ngaySinh, String diaChi, String soDienThoai, String email, int diemThuong, NhanVien nhanVien) {
        super(id, hoVaTen, ngaySinh, diaChi, soDienThoai, email);
        this.diemThuong = diemThuong;
        this.nhanVien = nhanVien;
    }

    public int getDiemThuong() {
        return diemThuong;
    }

    public void setDiemThuong(int diemThuong) {
        this.diemThuong = diemThuong;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public void input(String maKhachHang){
        setId(maKhachHang);
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
        int diemThuong = 0;

        System.out.println("Nhập nhân viên hỗ trợ (tên hoặc mã nhân viên): ");
        String tmnv = sc.nextLine();
        nhanVien = new NhanVienDAO().selectById(tmnv);
        while (nhanVien == null) {
            System.out.println("Không tồn tại nhân viên này !");
            System.out.println("Nhập nhân viên hỗ trợ (tên hoặc mã nhân viên): ");
            tmnv = sc.nextLine();
            nhanVien = new NhanVienDAO().selectById(tmnv);
        }
        new KhachHangDAO().insert(this);
        System.out.println("Đăng Ký Thành Công !");
        System.out.println("Chào mừng đến với cửa hàng !");
    }

    @Override
    public String toString() {
        return super.toString() + '\'' +
                "bonusPronits=" + diemThuong;
    }
}
