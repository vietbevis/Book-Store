package controller;

import model.KhachHang;
import model.NhanVien;
import model.TheLoai;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NhanVienDAO{
    public ArrayList<NhanVien> selectAll() {
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "SELECT nhanvien.* FROM nhanvien";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String maNhanVien = rs.getString("manhanvien");
                String hoVaTen = rs.getString("hovaten");
                Date ngaySinh = rs.getDate("ngaysinh");
                String diaChi = rs.getString("diachi");
                String soDienThoai = rs.getString("sodienthoai");
                String email = rs.getString("email");
                int soDonBanDuoc = rs.getInt("sodonbanduoc");

                NhanVien kh = new NhanVien(maNhanVien, hoVaTen, ngaySinh, diaChi, soDienThoai, email, soDonBanDuoc);
                list.add(kh);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public NhanVien selectById(String nv) {
        NhanVien nhanVien = null;
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "SELECT nhanvien.* FROM nhanvien WHERE manhanvien=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, nv);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                String maNhanVien = rs.getString("manhanvien");
                String hoVaTen = rs.getString("hovaten");
                Date ngaySinh = rs.getDate("ngaysinh");
                String diaChi = rs.getString("diachi");
                String soDienThoai = rs.getString("sodienthoai");
                String email = rs.getString("email");
                int soDonBanDuoc = rs.getInt("sodonbanduoc");
                nhanVien = new NhanVien(maNhanVien, hoVaTen, ngaySinh, diaChi, soDienThoai, email, soDonBanDuoc);
                break;
            }
            connection.close();
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return nhanVien;
    }

    public boolean insert(NhanVien nhanVien) {
        try {
            if(this.selectById(nhanVien.getId()) == null){
                Connection connection = JDBCUntil.getConnection();
                String sql = "INSERT INTO nhanvien(manhanvien, hovaten, ngaysinh, diachi, sodienthoai, email, sodonbanduoc) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, nhanVien.getId());
                st.setString(2, nhanVien.getHoVaTen());
                st.setDate(3, nhanVien.getNgaySinh());
                st.setString(4, nhanVien.getDiaChi());
                st.setString(5, nhanVien.getSoDienThoai());
                st.setString(6, nhanVien.getEmail());
                st.setInt(7, nhanVien.getSoDonBanDuoc());
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

    public void deleteAll(ArrayList<NhanVien> list) {

    }

    public void delete(String t) {

    }

    public void update(NhanVien nhanVien) {
        try {
            Connection connection = JDBCUntil.getConnection();
            String sql = "UPDATE nhanvien SET hovaten=?, ngaysinh=?, diachi=?, sodienthoai=?, email=?, sodonbanduoc=? WHERE manhanvien=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, nhanVien.getHoVaTen());
            st.setDate(2, nhanVien.getNgaySinh());
            st.setString(3, nhanVien.getDiaChi());
            st.setString(4, nhanVien.getSoDienThoai());
            st.setString(5, nhanVien.getEmail());
            st.setInt(6, nhanVien.getSoDonBanDuoc());
            st.setString(7, nhanVien.getId());
            st.executeUpdate();
            connection.close();
            st.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
