package store;

import controller.DonHangDAO;
import model.DonHang;

import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<DonHang> list = new DonHangDAO().selectDHDaGiao();
        for(DonHang x : list){
            System.out.println(x);
        }
    }
}
