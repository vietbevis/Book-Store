package model;

import java.sql.Date;
import java.util.ArrayList;

public class DonHang {
    private String maDonHang;
    private KhachHang khachHang;
    private NhanVien nhanVien;
    private ArrayList<Sach> sach;
    private double tongTien;
    private String trangThai;

    public DonHang() {}

    public DonHang(String maDonHang, KhachHang khachHang, NhanVien nhanVien, ArrayList<Sach> sach, double tongTien, String trangThai) {
        this.maDonHang = maDonHang;
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.sach = sach;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public ArrayList<Sach> getSach() {
        return sach;
    }

    public void setSach(ArrayList<Sach> sach) {
        this.sach = sach;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        System.out.println("--------------------------------------------------");
        System.out.println("Mã đơn hàng : " + maDonHang);
        System.out.println("Khách hàng : " + khachHang.getHoVaTen());
        System.out.println("Nhân viên hỗ trợ : " + nhanVien.getHoVaTen());
        System.out.println("Danh sách sản phẩm : ");
        for(Sach x : sach){
            System.out.println("\t" + x);
        }
        System.out.println("Tổng tiền : " + tongTien);
        System.out.println("Trạng thái đơn hàng : " + trangThai);
        return "";
    }
}
