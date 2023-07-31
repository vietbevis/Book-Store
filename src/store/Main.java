package store;

import controller.DonHangDAO;
import controller.KhachHangDAO;
import controller.NhanVienDAO;
import controller.SachDAO;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while (run) {
            Menu.menuDangNhap();
            System.out.println("Lựa chọn của bạn là (1 or 2 or 0): ");
            Character lc1 = sc.nextLine().charAt(0);

            switch (lc1) {

                // Khach Hang
                case '1':
                    System.out.println("Nhập mã khách hàng (A-z, 0-9) : ");
                    String maKhachHang = sc.nextLine();
                    KhachHang kh = new KhachHangDAO().selectById(maKhachHang);
                    if(kh != null){
                        System.out.println("Chào mừng quay trở lại !");
                    }
                    else {
                        kh = new KhachHang();
                        kh.input(maKhachHang);
                    }

                    GioHang gioHang = new GioHang(kh);

                    boolean run1 = true;
                    while (run1){
                        Menu.menuKhachHang();
                        Character lc2 = sc.nextLine().charAt(0);
                        switch (lc2) {

                            // Hiển thị toàn bộ sản phẩm hiện có
                            case '1':
                                Sach.showAll();
                                break;

                            // Thêm sp vào giỏ hàng
                            case '2':
                                Sach s = GioHang.addSachToGioHang();
                                while (gioHang.searchSach(s)){
                                    System.out.println("Đã có trong giỏ hàng !");
                                    s = GioHang.addSachToGioHang();
                                }
                                gioHang.addSach(s);
                                System.out.println("Thêm thành công !");
                                break;

                            // Hiển thị giỏ hàng
                            case '3':

                                // Vao Gio Hang

                                boolean run3 = true;
                                while (run3) {
                                    gioHang.showAll();
                                    System.out.println("Tổng tiền phải thanh toán : " + gioHang.getTongTien());
                                    Menu.menuGioHang();

                                    Character lc4 = sc.nextLine().charAt(0);
                                    switch (lc4) {

                                        // Xóa 1 sản phẩm khỏi giỏ hàng
                                        case '1':
                                            System.out.println("Nhập mã sách hoặc tên sách muốn xóa khỏi giỏ hàng : ");
                                            Sach s1 = new SachDAO().selectByBook(sc.nextLine());
                                            while (!gioHang.searchSach(s1)){
                                                System.out.println("Sản phẩm không tồn tại, vui lòng chọn sản phẩm khác !");
                                                s1 = new SachDAO().selectByBook(sc.nextLine());
                                            }
                                            gioHang.deleteSach(s1);
                                            System.out.println("Xóa thành công !");
                                            break;

                                        // Xóa toàn bộ giỏ hàng
                                        case '2':
                                            System.out.println("Bạn chắc chắn muốn xóa toàn bộ giỏ hàng (Y/N) : ");
                                            Character clear = sc.nextLine().charAt(0);
                                            while (clear != 'y' && clear != 'Y' && clear != 'n' && clear != 'N'){
                                                System.out.println("Vui lòng nhập Y hoặc N :");
                                                clear = sc.nextLine().charAt(0);
                                            }
                                            if(clear == 'Y' || clear == 'y'){
                                                gioHang.deleteAll();
                                                System.out.println("Xoá thành công !");
                                            }
                                            break;

                                        // Mua hàng
                                        case '3':
                                            System.out.println("Xác nhận mua hàng (Y/N) : ");
                                            Character xn = sc.nextLine().charAt(0);
                                            while (xn != 'y' && xn != 'Y' && xn != 'n' && xn != 'N'){
                                                System.out.println("Vui lòng nhập Y hoặc N :");
                                                xn = sc.nextLine().charAt(0);
                                            }
                                            if(xn == 'Y' || xn == 'y'){
                                                DonHang dh = new DonHang(null, kh, kh.getNhanVien(), gioHang.getListSach(), gioHang.getTongTien(), "Chờ xử lý");
                                                new DonHangDAO().insert(dh);
                                                ArrayList<Sach> list = gioHang.getListSach();
                                                for(Sach x : list){
                                                    Sach sach = new SachDAO().selectByBook(x.getMaSach());
                                                    sach.setSoLuong(sach.getSoLuong() - x.getSoLuong());
                                                    new SachDAO().update(sach);
                                                }
                                                gioHang.deleteAll();
                                                System.out.println("Thành công !");
                                            }
                                            break;
                                        case '0':
                                            run3 = false;
                                            break;
                                    }
                                    // Out Gio Hang
                                }
                                break;

                            // Hiển thị đơn hàng
                            case '4':
                                ArrayList<DonHang> list = new DonHangDAO().selectByKhachHang(kh);
                                for (DonHang x : list){
                                    System.out.println(x);
                                }
                                boolean run4 = true;
                                while(run4){
                                    Menu.menuDonHang();
                                    Character lc5 = sc.nextLine().charAt(0);
                                    switch (lc5){

                                        // Hủy đơn hàng
                                        case '1':
                                            System.out.println("Nhập mã đơn hàng muốn hủy :");
                                            String ma = sc.nextLine();
                                            if(new DonHangDAO().search(ma, kh.getId())){
                                                new DonHangDAO().delete(ma, kh.getId());
                                                System.out.println("Thành công !");
                                            }
                                            else {
                                                System.out.println("không tồn tại đơn hàng này !");
                                            }
                                            break;
                                        case '0':
                                            run4 = false;
                                            break;
                                    }
                                }
                                break;
                            case '0':
                                run1 = false;
                                break;
                        }
                    }
                break;
                // Out Khach Hang

                //Nhan Vien
                case '2':
                    System.out.println("Nhập mã nhân viên (A-z, 0-9) : ");
                    String maNhanVien = sc.nextLine();
                    NhanVien nv = new NhanVienDAO().selectById(maNhanVien);
                    if(nv == null){
                        nv = new NhanVien();
                        nv.input(maNhanVien);
                    }
                    boolean runA = true;
                    while (runA){
                        Menu.menuNhanVien();
                        Character lc3 = sc.nextLine().charAt(0);
                        switch (lc3) {

                            // Thêm sách vào kho
                            case '1':
                                System.out.println("Nhập số lượng sách khác nhau muốn thêm : ");
                                String sl = sc.nextLine();
                                while (!ChuanHoa.checkAll(sl).equals("")){
                                    System.out.printf("Số lượng %s\n", ChuanHoa.checkAll(sl));
                                    System.out.println("Vui lòng nhập lại :");
                                    sl = sc.nextLine();
                                }
                                for(int i=0 ; i<Integer.parseInt(sl) ; i++){
                                    Sach s = new Sach();
                                    s.input();
                                }
                                System.out.println("Thêm thành công !");
                                break;

                            // Xuất kho
                            case '2':
                                GioHang.XuatKho();
                                System.out.println("Thành công !");
                                break;

                            // Thống kê kho
                            case '3':
                                SachDAO.thongKeSachTrongKho();
                                System.out.println("Thành công !");
                                break;

                            // Danh sách đơn hàng
                            case '4':
                                ArrayList<DonHang> list = new DonHangDAO().selectAll();
                                for(DonHang x : list){
                                    System.out.print(x);
                                }
                                System.out.println("--------------------------------------------------");
                                break;

                            // Cập nhật trạng thái đơn hàng
                            case '5':
                                System.out.println("Nhập mã đơn hàng cần cập nhật :");
                                String cn = sc.nextLine();
                                DonHang dh = new DonHangDAO().selectById(cn);
                                while (dh == null){
                                    System.out.println("Đơn hàng không tồn tại, vui lòng chọn đơn hàng khác :");
                                    cn = sc.nextLine();
                                    dh = new DonHangDAO().selectById(cn);
                                }
                                System.out.println("Cập nhật thành công !");
                                new DonHangDAO().update(dh);

                                break;
                            case '6':
                                ArrayList<DonHang> dhDaGiao = new DonHangDAO().selectDHDaGiao();
                                double loiNhuan = 0;
                                for(DonHang x : dhDaGiao){
                                    Sach tmp = new Sach();
                                    for (Sach y : x.getSach()){
                                        tmp = y;
                                    }
                                    loiNhuan += ((tmp.getGiaBan() - tmp.getGiaNhap()) * tmp.getSoLuong());
                                }
                                System.out.println("Lợi nhuận : " + loiNhuan);
                                break;
                            case '0':
                                runA = false;
                                break;
                        }
                    }
                    break;
                case '0':
                    run = false;
                    break;
                // Out nhan vien
            }
        }
    }
}
