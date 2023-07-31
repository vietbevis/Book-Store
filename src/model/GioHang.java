package model;

import controller.SachDAO;

import java.util.ArrayList;
import java.util.Scanner;

public class GioHang {
    private KhachHang khachHang;
    private ArrayList<Sach> listSach;
    private double tongTien;

    public GioHang(KhachHang kh) {
        khachHang = kh;
        listSach = new ArrayList<>();
        tongTien = 0;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void addSach(Sach sach){
        listSach.add(sach);
        tongTien += (sach.getSoLuong() * sach.getGiaBan());
    }

    public boolean searchSach(Sach sach){
        for (Sach x : listSach){
            if(x.equals(sach)){
                return true;
            }
        }
        return false;
    }

    public void deleteSach(Sach sach){
        for (Sach x : listSach){
            if(x.equals(sach)){
                tongTien -= (x.getSoLuong() * x.getGiaBan());
                listSach.remove(x);
                return;
            }
        }
    }

    public void deleteAll() {
        this.listSach.clear();
        tongTien = 0;
    }

    public ArrayList<Sach> getListSach() {
        return listSach;
    }


    public static Sach addSachToGioHang(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã sách hoặc tên sách muốn thêm vào giỏ hàng : ");
        Sach s = new SachDAO().selectByBook(sc.nextLine());
        while (s == null){
            System.out.println("Sản phẩm không tồn tại, vui lòng chọn sản phẩm khác !");
            System.out.println("Nhập mã sách hoặc tên sách muốn thêm vào giỏ hàng : ");
            s = new SachDAO().selectByBook(sc.nextLine());
        }
        System.out.println("Nhập số lượng muốn thêm : ");
        String soLuong = sc.nextLine();
        int soLuongKho = new SachDAO().selectByBook(s.getMaSach()).getSoLuong();
        while(!ChuanHoa.checkAll(soLuong, soLuongKho).equals("")){
            System.out.printf("Số lượng %s\n", ChuanHoa.checkAll(soLuong, soLuongKho));
            System.out.println("Nhập số lượng muốn thêm : ");
            soLuong = sc.nextLine();
        }
        s.setSoLuong((int)Double.parseDouble(soLuong));
        return s;
    }

    public static void XuatKho(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã sách hoặc tên sách muốn xuất : ");
        Sach s = new SachDAO().selectByBook(sc.nextLine());
        while (s == null){
            System.out.println("Sản phẩm không tồn tại, vui lòng chọn sản phẩm khác !");
            System.out.println("Nhập mã sách hoặc tên sách muốn xuất : ");
            s = new SachDAO().selectByBook(sc.nextLine());
        }
        System.out.println("Nhập số lượng muốn xuất : ");
        String soLuong = sc.nextLine();
        int soLuongKho = s.getSoLuong();
        while(!ChuanHoa.checkAll(soLuong, soLuongKho).equals("")){
            System.out.printf("Số lượng %s\n", ChuanHoa.checkAll(soLuong, soLuongKho));
            System.out.println("Nhập số lượng muốn xuất : ");
            soLuong = sc.nextLine();
        }
        s.setSoLuong(s.getSoLuong() - (int)Double.parseDouble(soLuong));
        new SachDAO().update(s);
    }

    public void showAll(){
        if(listSach.isEmpty()){
            System.out.println("Giỏ hàng rỗng !");
        }
        else {
            System.out.println("Giỏ hàng của : " + khachHang.getHoVaTen());
            for(Sach x : listSach){
                System.out.println(x);
            }
        }
    }
}
