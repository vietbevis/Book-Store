package store;

import controller.*;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true){
            String s = sc.nextLine();
            System.out.println(ChuanHoa.checkNgaySinh(s));
        }

    }
}
