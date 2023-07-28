package controller;

import model.Sach;
import model.TacGia;
import model.TheLoai;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

public class TacGiaDAO{

    public ArrayList<TacGia> selectAll(){
        ArrayList<TacGia> list = new ArrayList<>();
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "SELECT * FROM tacgia";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                String maTacGia = rs.getString("matacgia");
                String hoVaTen = rs.getString("tentacgia");
                Date ngaySinh = rs.getDate("ngaysinh");
                String tieuSu = rs.getString("tieusu");
                TacGia tg = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);
                list.add(tg);
            }
            connection.close();
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public TacGia selectById(String mtg){
        TacGia tg = null;
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "SELECT * FROM tacgia WHERE matacgia=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, mtg);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                String maTacGia = rs.getString("matacgia");
                String hoVaTen = rs.getString("tentacgia");
                Date ngaySinh = rs.getDate("ngaysinh");
                String tieuSu = rs.getString("tieusu");
                tg = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);
                break;
            }
            connection.close();
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return tg;
    }

    public static void thongKeTacGia() {
        ArrayList<TacGia> list = new TacGiaDAO().selectAll();
        for(TacGia x : list) {
            ArrayList<Sach> sach = new SachDAO().selectByAuthor(x.getHoVaTen());
            if(sach.isEmpty()) {
                new TacGiaDAO().delete(x);
            }
        }
    }

    public void delete(TacGia tacGia) {
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "DELETE FROM tacgia WHERE matacgia=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tacGia.getMaTacGia());
            st.executeUpdate();
            connection.close();
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(TacGia tacGia) {
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "INSERT INTO tacgia(matacgia, tentacgia, ngaysinh, tieusu) VALUES (?, ?, ?, ?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tacGia.getMaTacGia());
            st.setString(2, tacGia.getHoVaTen());
            st.setDate(3, tacGia.getNgaySinh());
            st.setString(4, tacGia.getTieuSu());
            st.executeUpdate();
            connection.close();
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void update(TacGia tacGia) {
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "UPDATE tacgia SET hovaten=?, ngaysinh=?, tieusu=? WHERE matacgia=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tacGia.getHoVaTen());
            st.setDate(2, tacGia.getNgaySinh());
            st.setString(3, tacGia.getTieuSu());
            st.setString(4, tacGia.getMaTacGia());
            st.executeUpdate();
            connection.close();
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
