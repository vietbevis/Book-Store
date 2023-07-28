package model;

import controller.DonHangDAO;
import controller.SachDAO;
import controller.TacGiaDAO;
import controller.TheLoaiDAO;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Sach {
    private String maSach;
    private String tenSach;
    private TacGia tacGia;
    private int namXuatBan;
    private TheLoai theLoai;
    private String ngonNgu;
    private String moTa;
    private double giaNhap;
    private double giaBan;
    private int soLuong;

    public Sach() {}

    public Sach(String maSach, String tenSach, TacGia tacGia, int namXuatBan, TheLoai theLoai, String ngonNgu, String moTa, double giaNhap, double giaBan, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.namXuatBan = namXuatBan;
        this.theLoai = theLoai;
        this.ngonNgu = ngonNgu;
        this.moTa = moTa;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public TacGia getTacGia() {
        return tacGia;
    }

    public void setTacGia(TacGia tacGia) {
        this.tacGia = tacGia;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public TheLoai getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(TheLoai theLoai) {
        this.theLoai = theLoai;
    }

    public String getNgonNgu() {
        return ngonNgu;
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu = ngonNgu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }


    public static void showAll(){
        SachDAO.thongKeSachTrongKho();
        ArrayList<Sach> list = new SachDAO().selectAll();
        System.out.println("--- DANH SÁCH SẢN PHẨM ---");
        for(Sach x : list) {
            System.out.println(x);
        }
    }

    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã sách : ");
        setMaSach(sc.nextLine());
        Sach tmp = new SachDAO().selectByBook(maSach);
        if(tmp != null){
            System.out.println("Nhập số lượng muốn thêm : ");
            String sl = sc.nextLine();
            while (!ChuanHoa.checkInt(sl)){
                System.out.println("Nhập sai, nhập lại :");
                sl = sc.nextLine();
            }
            tmp.setSoLuong(tmp.getSoLuong() + Integer.parseInt(sl));
            new SachDAO().update(tmp);
        }
        else {
            System.out.println("Nhập tên sách :");
            setTenSach(sc.nextLine());
            System.out.println("Nhập mã tác giả :");
            String maTacGia = sc.nextLine();
            tacGia = new TacGiaDAO().selectById(maTacGia);
            if(tacGia == null){
                tacGia = new TacGia();
                tacGia.input(maTacGia);
            }
            System.out.println("Nhập năm xuất bản :");
            setNamXuatBan(Integer.parseInt(sc.nextLine()));
            System.out.println("Nhập mã thể loại : ");
            String maTheLoai = sc.nextLine();
            theLoai = new TheLoaiDAO().selectById(maTheLoai);
            if(theLoai == null){
                theLoai = new TheLoai();
                theLoai.input(maTheLoai);
            }
            System.out.println("Nhập ngôn ngữ : ");
            setNgonNgu(sc.nextLine());
            System.out.println("Nhập mô tả : ");
            setMoTa(sc.nextLine());
            System.out.println("Nhập giá nhập : ");
            setGiaNhap(Double.parseDouble(sc.nextLine()));
            System.out.println("Nhập giá bán : ");
            setGiaBan(Double.parseDouble(sc.nextLine()));
            System.out.println("Nhập số lượng : ");
            setSoLuong(Integer.parseInt(sc.nextLine()));
            new SachDAO().insert(this);
        }
    }

    public double tongTien(){
        return giaBan * soLuong;
    }

    @Override
    public String toString() {
        return "[maSach=" + maSach +
                ", tenSach=" + tenSach +
                ", tacGia=" + tacGia.getHoVaTen() +
                ", namXuatBan=" + namXuatBan +
                ", theLoai=" + theLoai.getTenTheLoai() +
                ", ngonNgu=" + ngonNgu +
                ", moTa=" + moTa +
                ", giaNhap=" + giaNhap +
                ", giaBan=" + giaBan +
                ", soLuong=" + soLuong +"]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sach sach = (Sach) o;
        return Objects.equals(maSach, sach.maSach);
    }
}
