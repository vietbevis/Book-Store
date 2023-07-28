package controller;

import model.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DonHangDAO{
    public ArrayList<DonHang> selectAll(){
        ArrayList<DonHang> listDH = new ArrayList<>();

        DonHang dh = new DonHang();
        String maDonHang = null;
        String maKhachHang = null;
        String maNhanVien = null;
        String maSach = null;
        double tongTien = 0;
        String trangThai = null;
        int soLuong = 0;
        KhachHang kh = new KhachHang();
        NhanVien nv = new NhanVien();
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "SELECT * FROM donhang";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                maDonHang = rs.getString("madonhang");
                maKhachHang = rs.getString("makhachhang");
                maNhanVien = rs.getString("manhanvien");
                maSach = rs.getString("masach");
                Sach tmp = new SachDAO().selectByBook(maSach);
                tongTien = rs.getDouble("tongtien");
                trangThai = rs.getString("trangthai");
                soLuong = rs.getInt("soluong");
                tmp.setSoLuong(soLuong);
                ArrayList<Sach> listSP = new ArrayList<>();
                listSP.add(tmp);
                kh = new KhachHangDAO().selectById(maKhachHang);
                nv = new NhanVienDAO().selectById(maNhanVien);
                dh = new DonHang(maDonHang, kh, nv, listSP, tongTien, trangThai);

                listDH.add(dh);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        return listDH;
    }

    public ArrayList<DonHang> selectByKhachHang(KhachHang khachHang) {
        ArrayList<DonHang> listDH = new ArrayList<>();

        DonHang dh = new DonHang();
        String maDonHang = null;
        String maKhachHang = null;
        String maNhanVien = null;
        String maSach = null;
        double tongTien = 0;
        String trangThai = null;
        int soLuong = 0;
        KhachHang kh = new KhachHang();
        NhanVien nv = new NhanVien();
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "SELECT * FROM donhang WHERE makhachhang=? AND trangthai=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, khachHang.getId());
            st.setString(2, "Chờ xử lý");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                maDonHang = rs.getString("madonhang");
                maKhachHang = rs.getString("makhachhang");
                maNhanVien = rs.getString("manhanvien");
                maSach = rs.getString("masach");
                Sach tmp = new SachDAO().selectByBook(maSach);
                tongTien = rs.getDouble("tongtien");
                trangThai = rs.getString("trangthai");
                soLuong = rs.getInt("soluong");
                tmp.setSoLuong(soLuong);
                ArrayList<Sach> listSP = new ArrayList<>();
                listSP.add(tmp);
                kh = new KhachHangDAO().selectById(maKhachHang);
                nv = new NhanVienDAO().selectById(maNhanVien);
                dh = new DonHang(maDonHang, kh, nv, listSP, tongTien, trangThai);

                listDH.add(dh);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        return listDH;
    }

    public DonHang selectById(String mdh){
        DonHang dh = new DonHang();
        String maDonHang = null;
        String maKhachHang = null;
        String maNhanVien = null;
        String maSach = null;
        double tongTien = 0;
        String trangThai = null;
        int soLuong = 0;
        KhachHang kh = new KhachHang();
        NhanVien nv = new NhanVien();
        try {
            Connection connection = JDBCUntil.getConnection();

            String sql = "SELECT * FROM donhang WHERE madonhang=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, Integer.parseInt(mdh));
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                maDonHang = mdh;
                maKhachHang = rs.getString("makhachhang");
                maNhanVien = rs.getString("manhanvien");
                maSach = rs.getString("masach");
                Sach tmp = new SachDAO().selectByBook(maSach);
                tongTien = rs.getDouble("tongtien");
                trangThai = rs.getString("trangthai");
                soLuong = rs.getInt("soluong");
                tmp.setSoLuong(soLuong);
                ArrayList<Sach> listSP = new ArrayList<>();
                listSP.add(tmp);
                kh = new KhachHangDAO().selectById(maKhachHang);
                nv = new NhanVienDAO().selectById(maNhanVien);
                dh = new DonHang(maDonHang, kh, nv, listSP, tongTien, trangThai);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return dh;
    }

    public ArrayList<DonHang> selectDHDaGiao(){
        ArrayList<DonHang> listDH = new ArrayList<>();

        DonHang dh = new DonHang();
        String maDonHang = null;
        String maKhachHang = null;
        String maNhanVien = null;
        String maSach = null;
        double tongTien = 0;
        String trangThai = null;
        int soLuong = 0;
        KhachHang kh = new KhachHang();
        NhanVien nv = new NhanVien();
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "SELECT * FROM donhang WHERE trangthai=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "Đã giao");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                maDonHang = rs.getString("madonhang");
                maKhachHang = rs.getString("makhachhang");
                maNhanVien = rs.getString("manhanvien");
                maSach = rs.getString("masach");
                Sach tmp = new SachDAO().selectByBook(maSach);
                tongTien = rs.getDouble("tongtien");
                trangThai = rs.getString("trangthai");
                soLuong = rs.getInt("soluong");
                tmp.setSoLuong(soLuong);
                ArrayList<Sach> listSP = new ArrayList<>();
                listSP.add(tmp);
                kh = new KhachHangDAO().selectById(maKhachHang);
                nv = new NhanVienDAO().selectById(maNhanVien);
                dh = new DonHang(maDonHang, kh, nv, listSP, tongTien, trangThai);

                listDH.add(dh);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
        return listDH;
    }

    public void insert(DonHang donHang) {
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "INSERT INTO donhang(madonhang, makhachhang, manhanvien, masach, tongtien, trangthai, soluong) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = connection.prepareStatement(sql);
            for (Sach x : donHang.getSach()){
                st.setString(1, donHang.getMaDonHang());
                st.setString(2, donHang.getKhachHang().getId());
                st.setString(3, donHang.getKhachHang().getNhanVien().getId());
                st.setString(4, x.getMaSach());
                st.setDouble(5, x.tongTien());
                st.setString(6, donHang.getTrangThai());
                st.setInt(7, x.getSoLuong());
                st.executeUpdate();
            }

            connection.close();
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public boolean search(String t, String ma){
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "SELECT * FROM donhang WHERE madonhang=? AND makhachhang=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, Integer.parseInt(t));
            st.setString(2, ma);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                return true;
            }
            connection.close();
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void delete(String t, String ma) {
        try {
            DonHang dh = new DonHangDAO().selectById(t);
            ArrayList<Sach> list = dh.getSach();
            for (Sach x : list){
                Sach tmp = new SachDAO().selectByBook(x.getMaSach());
                tmp.setSoLuong(tmp.getSoLuong() + x.getSoLuong());
                new SachDAO().update(tmp);
            }
            Connection connection = JDBCUntil.getConnection();
            String sql = "DELETE FROM donhang WHERE madonhang=? AND makhachhang=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, Integer.parseInt(t));
            st.setString(2, ma);
            st.executeUpdate();
            connection.close();
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void update(DonHang donHang){
        try {
            // Cập nhật số đơn mỗi nhân viên bán đc
            NhanVien nhanVien = new NhanVienDAO().selectById(donHang.getNhanVien().getId());
            nhanVien.setSoDonBanDuoc(nhanVien.getSoDonBanDuoc() + 1);
            new NhanVienDAO().update(nhanVien);
            // Cập nhật điểm thưởng cho khách hàng = số đơn hàng đã giao
            KhachHang khachHang = new KhachHangDAO().selectById(donHang.getKhachHang().getId());
            khachHang.setDiemThuong(khachHang.getDiemThuong() + 1);
            new KhachHangDAO().update(khachHang);
            // Cập nhật trạng thái đơn hàng
            Connection connection = JDBCUntil.getConnection();
            String sql = "UPDATE donhang SET trangthai=? WHERE madonhang=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "Đã giao");
            st.setInt(2, Integer.parseInt(donHang.getMaDonHang()));
            st.executeUpdate();
            connection.close();
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
