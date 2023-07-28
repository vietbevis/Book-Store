package controller;

import model.KhachHang;
import model.NhanVien;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class KhachHangDAO{
    public ArrayList<KhachHang> selectAll() {
        ArrayList<KhachHang> list = new ArrayList<>();
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "SELECT * FROM khachhang";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String maKhachHang = rs.getString("makhachhang");
                String hoVaTen = rs.getString("hovaten");
                Date ngaySinh = rs.getDate("ngaysinh");
                String diaChi = rs.getString("diachi");
                String soDienThoai = rs.getString("sodienthoai");
                String email = rs.getString("email");
                int diemThuong = rs.getInt("diemthuong");
                String maNhanVien = rs.getString("manhanvien");

                NhanVien nv = new NhanVienDAO().selectById(maNhanVien);
                KhachHang kh = new KhachHang(maKhachHang, hoVaTen, ngaySinh, diaChi, soDienThoai, email, diemThuong, nv);
                list.add(kh);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public KhachHang selectById(String mkh) {
        KhachHang kh = null;
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "SELECT khachhang.* FROM khachhang WHERE makhachhang=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, mkh);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String maKhachHang = rs.getString("makhachhang");
                String hoVaTen = rs.getString("hovaten");
                Date ngaySinh = rs.getDate("ngaysinh");
                String diaChi = rs.getString("diachi");
                String soDienThoai = rs.getString("sodienthoai");
                String email = rs.getString("email");
                int diemThuong = rs.getInt("diemthuong");
                String maNhanVien = rs.getString("manhanvien");

                NhanVien nv = new NhanVienDAO().selectById(maNhanVien);
                kh = new KhachHang(maKhachHang, hoVaTen, ngaySinh, diaChi, soDienThoai, email, diemThuong, nv);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return kh;
    }

    public boolean insert(KhachHang khachHang) {
        try {
            if(this.selectById(khachHang.getId()) == null){
                Connection connection = JDBCUntil.getConnection();
                String sql = "INSERT INTO khachhang(makhachhang, hovaten, ngaysinh, diachi, sodienthoai, email, diemthuong, manhanvien) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, khachHang.getId());
                st.setString(2, khachHang.getHoVaTen());
                st.setDate(3, khachHang.getNgaySinh());
                st.setString(4, khachHang.getDiaChi());
                st.setString(5, khachHang.getSoDienThoai());
                st.setString(6, khachHang.getEmail());
                st.setInt(7, khachHang.getDiemThuong());
                st.setString(8, khachHang.getNhanVien().getId());
                st.executeUpdate();

                connection.close();
                st.close();
                return true;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void deleteAll(ArrayList<KhachHang> list) {

    }

    public void delete(String t) {

    }

    public void update(KhachHang khachHang) {
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "UPDATE khachhang SET hovaten=?, ngaysinh=?, diachi=?, sodienthoai=?, email=?, diemthuong=? manhanvien=? WHERE makhachhang=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, khachHang.getHoVaTen());
            st.setDate(2, khachHang.getNgaySinh());
            st.setString(3, khachHang.getDiaChi());
            st.setString(4, khachHang.getSoDienThoai());
            st.setString(5, khachHang.getEmail());
            st.setInt(6, khachHang.getDiemThuong());
            st.setString(7, khachHang.getId());
            st.setString(8, khachHang.getNhanVien().getId());
            st.executeUpdate();
            connection.close();
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
