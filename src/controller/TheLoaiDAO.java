package controller;

import model.Sach;
import model.TacGia;
import model.TheLoai;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TheLoaiDAO{

    public ArrayList<TheLoai> selectAll(){
        ArrayList<TheLoai> list = new ArrayList<>();
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "SELECT * FROM theloai";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                String maTheLoai = rs.getString("matheloai");
                String tenTheLoai = rs.getString("tentheloai");
                TheLoai tl = new TheLoai(maTheLoai, tenTheLoai);
                list.add(tl);
            }
            connection.close();
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public TheLoai selectById(String mtl) {
        TheLoai tl = null;
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "SELECT * FROM theloai WHERE matheloai=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, mtl);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                String maTheLoai = rs.getString("matheloai");
                String tenTheLoai = rs.getString("tentheloai");
                tl = new TheLoai(maTheLoai, tenTheLoai);
                break;
            }
            connection.close();
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return tl;
    }

    public static void thongKeTheLoai() {
        ArrayList<TheLoai> list = new TheLoaiDAO().selectAll();
        for(TheLoai x : list) {
            ArrayList<Sach> sach = new SachDAO().selectByTheLoai(x.getTenTheLoai());
            if(sach.isEmpty()) {
                new TheLoaiDAO().delete(x);
            }
        }
    }

    public void delete(TheLoai theLoai) {
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "DELETE FROM theloai WHERE matheloai=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, theLoai.getMaTheLoai());
            st.executeUpdate();
            connection.close();
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void insert(TheLoai theLoai) {
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "INSERT INTO theloai(matheloai, tentheloai) VALUES (?, ?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, theLoai.getMaTheLoai());
            st.setString(2, theLoai.getTenTheLoai());
            st.executeUpdate();
            connection.close();
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void update(TheLoai theLoai) {
        try {
            Connection connection = JDBCUntil.getConnection();

            String sql = "UPDATE theloai SET tentheloai=? WHERE matheloai=?";
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, theLoai.getTenTheLoai());
            st.setString(2, theLoai.getMaTheLoai());
            st.executeUpdate();

            connection.close();
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
