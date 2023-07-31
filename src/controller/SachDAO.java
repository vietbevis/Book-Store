package controller;

import model.Sach;
import model.TacGia;
import model.TheLoai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Stack;

public class SachDAO{
    public ArrayList<Sach> selectAll() {
        ArrayList<Sach> list = new ArrayList<>();
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "SELECT sach.* FROM sach";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                String maSach = rs.getString("masach");
                String tenSach = rs.getString("tensach");
                String maTacGia = rs.getString("matacgia");
                int namXuatBan = rs.getInt("namxuatban");
                String maTheLoai = rs.getString("matheloai");
                String moTa = rs.getString("mota");
                String ngonNgu = rs.getString("ngonngu");
                int giaNhap = rs.getInt("gianhap");
                int giaBan = rs.getInt("giaban");
                int soLuong = rs.getInt("soluong");

                TacGia tg = new TacGiaDAO().selectById(maTacGia);
                TheLoai tl = new TheLoaiDAO().selectById(maTheLoai);

                Sach s = new Sach(maSach, tenSach, tg, namXuatBan, tl, ngonNgu, moTa, giaNhap, giaBan, soLuong);
                list.add(s);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Sach selectByBook(String msts) {
        Sach s = null;
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "SELECT sach.* FROM sach WHERE masach=? OR tensach=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, msts);
            st.setString(2, msts);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                String maSach = rs.getString("masach");
                String tenSach = rs.getString("tensach");
                String maTacGia = rs.getString("matacgia");
                int namXuatBan = rs.getInt("namxuatban");
                String maTheLoai = rs.getString("matheloai");
                String moTa = rs.getString("mota");
                String ngonNgu = rs.getString("ngonngu");
                int giaNhap = rs.getInt("gianhap");
                int giaBan = rs.getInt("giaban");
                int soLuong = rs.getInt("soluong");

                TacGia tg = new TacGiaDAO().selectById(maTacGia);
                TheLoai tl = new TheLoaiDAO().selectById(maTheLoai);

                s = new Sach(maSach, tenSach, tg, namXuatBan, tl, ngonNgu, moTa, giaNhap, giaBan, soLuong);
                break;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public ArrayList<Sach> selectByAuthor(String tacGia) {
        ArrayList<Sach> list = new ArrayList<>();
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "SELECT sach.* FROM sach, tacgia WHERE tentacgia=? AND sach.matacgia = tacgia.matacgia";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tacGia);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String maSach = rs.getString("masach");
                String tenSach = rs.getString("tensach");
                String maTacGia = rs.getString("matacgia");
                int namXuatBan = rs.getInt("namxuatban");
                String maTheLoai = rs.getString("matheloai");
                String moTa = rs.getString("mota");
                String ngonNgu = rs.getString("ngonngu");
                int giaNhap = rs.getInt("gianhap");
                int giaBan = rs.getInt("giaban");
                int soLuong = rs.getInt("soluong");

                TacGia tg = new TacGiaDAO().selectById(maTacGia);
                TheLoai tl = new TheLoaiDAO().selectById(maTheLoai);

                Sach s = new Sach(maSach, tenSach, tg, namXuatBan, tl, ngonNgu, moTa, giaNhap, giaBan, soLuong);
                list.add(s);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Sach> selectByTheLoai(String theLoai) {
        ArrayList<Sach> list = new ArrayList<>();
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "SELECT sach.* FROM sach, theloai WHERE tentheloai=? AND sach.matheloai = theloai.matheloai";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, theLoai);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String maSach = rs.getString("masach");
                String tenSach = rs.getString("tensach");
                String maTacGia = rs.getString("matacgia");
                int namXuatBan = rs.getInt("namxuatban");
                String maTheLoai = rs.getString("matheloai");
                String moTa = rs.getString("mota");
                String ngonNgu = rs.getString("ngonngu");
                int giaNhap = rs.getInt("gianhap");
                int giaBan = rs.getInt("giaban");
                int soLuong = rs.getInt("soluong");

                TacGia tg = new TacGiaDAO().selectById(maTacGia);
                TheLoai tl = new TheLoaiDAO().selectById(maTheLoai);

                Sach s = new Sach(maSach, tenSach, tg, namXuatBan, tl, ngonNgu, moTa, giaNhap, giaBan, soLuong);
                list.add(s);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insert(Sach sach) {
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "INSERT INTO sach(masach, tensach, matacgia, namxuatban, matheloai, ngonngu, mota, gianhap, giaban, soluong) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, sach.getMaSach());
            st.setString(2, sach.getTenSach());
            st.setString(3, sach.getTacGia().getMaTacGia());
            st.setInt(4, sach.getNamXuatBan());
            st.setString(5, sach.getTheLoai().getMaTheLoai());
            st.setString(6, sach.getNgonNgu());
            st.setString(7, sach.getMoTa());
            st.setDouble(8, sach.getGiaNhap());
            st.setDouble(9, sach.getGiaBan());
            st.setInt(10, sach.getSoLuong());
            st.executeUpdate();
            connection.close();
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void thongKeSachTrongKho() {
        ArrayList<Sach> list = new SachDAO().selectAll();
        for(Sach x : list) {
            if(x.getSoLuong() <= 0) {
                new SachDAO().delete(x);
            }
        }
        TheLoaiDAO.thongKeTheLoai();
        TacGiaDAO.thongKeTacGia();
    }

    public void delete(Sach sach) {
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "DELETE FROM sach WHERE masach=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, sach.getMaSach());
            st.executeUpdate();
            connection.close();
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Sach sach) {
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "UPDATE sach SET tensach=?, matacgia=?, namxuatban=?, matheloai=?, ngonngu=?, mota=?, gianhap=?, giaban=?, soluong=? WHERE masach=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, sach.getTenSach());
            st.setString(2, sach.getTacGia().getMaTacGia());
            st.setInt(3, sach.getNamXuatBan());
            st.setString(4, sach.getTheLoai().getMaTheLoai());
            st.setString(5, sach.getNgonNgu());
            st.setString(6, sach.getMoTa());
            st.setDouble(7, sach.getGiaNhap());
            st.setDouble(8, sach.getGiaBan());
            st.setInt(9, sach.getSoLuong());
            st.setString(10, sach.getMaSach());
            st.executeUpdate();
            connection.close();
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
