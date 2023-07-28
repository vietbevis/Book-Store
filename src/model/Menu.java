package model;

public class Menu {
    public static void menuDangNhap(){
        System.out.println("Bạn là (Khách hàng / Nhân Viên) ?");
        System.out.println("1. Khách hàng");
        System.out.println("2. Nhân Viên");
        System.out.println("0. Thoát");
    }

    public static void menuNhanVien(){
        System.out.println("-----------MENU-----------");
        System.out.println("1. Thêm sách vào kho");
        System.out.println("2. Xuất kho");
        System.out.println("3. Thống kê số sách còn lại trong kho");
        System.out.println("4. Hiển thị sanh sách các đơn hàng");
        System.out.println("5. Cập nhật trạng thái đơn hàng");
        System.out.println("0. Thoát");
        System.out.println("--------------------------");
    }

    public static void menuKhachHang(){
        System.out.println("-----------MENU-----------");
        System.out.println("1. Hiện thị toàn bộ sách đang có");
        System.out.println("2. Thêm sách vào giỏ hàng");
        System.out.println("3. Xem giỏ hàng");
        System.out.println("4. Xem các đơn hàng đã đặt");
        System.out.println("0. Thoát");
        System.out.println("--------------------------");
    }

    public static void menuGioHang(){
        System.out.println("-----------MENU-----------");
        System.out.println("1. Xóa sách khỏi giỏ theo mã sách");
        System.out.println("2. Xóa toàn bộ sách khỏi giỏ hàng");
        System.out.println("3. Xác nhận mua hàng");
        System.out.println("0. Thoát giỏ hàng");
        System.out.println("--------------------------");
    }

    public static void menuDonHang(){
        System.out.println("-----------MENU-----------");
        System.out.println("1. Hủy đơn hàng");
        System.out.println("0. Thoát");
        System.out.println("--------------------------");
    }
}
