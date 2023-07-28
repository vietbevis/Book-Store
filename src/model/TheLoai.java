package model;

import controller.TheLoaiDAO;

import java.util.Objects;
import java.util.Scanner;

public class TheLoai {
    private String maTheLoai;
    private String tenTheLoai;

    public TheLoai() {}

    public TheLoai(String maTheLoai, String tenTheLoai) {
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public void input(String mtl){
        Scanner sc = new Scanner(System.in);
        setMaTheLoai(mtl);
        System.out.println("Nhập tên thể loại : ");
        setTenTheLoai(sc.nextLine());
        new TheLoaiDAO().insert(this);
    }

    @Override
    public String toString() {
        return "maTheLoai='" + maTheLoai + '\'' +
                ", tenTheLoai='" + tenTheLoai;
    }
}
