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
        while(Integer.parseInt(soLuong) > soLuongKho || (!ChuanHoa.checkInt(soLuong) || Integer.parseInt(soLuong) <= 0)){
            System.out.printf("Quá số lượng sách trong kho (%s) hoặc nhập sai, nhập lại\n", soLuongKho);
            System.out.println("Nhập số lượng muốn thêm : ");
            soLuong = sc.nextLine();
        }
        s.setSoLuong(Integer.parseInt(soLuong));
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
        int soLuong = 0;
        boolean test = true;
        while(test){
            try {
                soLuong = Integer.parseInt(sc.nextLine());
                test = false;
            } catch(Exception e) {
                System.out.println("Nhập sai, nhập lại : ");
            }
        }
        int soLuongKho = s.getSoLuong();
        while(soLuong > soLuongKho){
            System.out.printf("Quá số lượng sách trong kho (%s)\n", soLuongKho);
            System.out.println("Nhập số lượng muốn xuất : ");
            boolean test1 = true;
            while(test1){
                try {
                    soLuong = Integer.parseInt(sc.nextLine());
                    test1 = false;
                } catch(Exception e) {
                    System.out.println("Nhập sai, nhập lại : ");
                }
            }
        }
        s.setSoLuong(s.getSoLuong() - soLuong);
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
