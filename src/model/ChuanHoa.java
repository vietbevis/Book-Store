package model;

import java.sql.Date;

public class ChuanHoa {
    public static String chuanHoaTen(String hoVaTen){
        StringBuilder sb = new StringBuilder();
        String[] arr = hoVaTen.split("\\s+");
        for(String x : arr){
            sb.append(x.toUpperCase().charAt(0));
            sb.append(x.toLowerCase().substring(1));
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static boolean checkNgaySinh(String ngaySinh){
        try {
            Date date = Date.valueOf(ngaySinh);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public static boolean checkInt(String x){
        try {
            int n = Integer.parseInt(x);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public static boolean checkSDT(String x){
        if(!ChuanHoa.checkAll(x, Integer.MAX_VALUE).equals("")){
            if(x.trim().length() == 10){
                return true;
            }
        }
        return false;
    }

    public static boolean checkDouble(String x){
        try {
            double n = Double.parseDouble(x);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public static String checkAll(String x, int tmp) {
        boolean kiTu = false, chuCai = false;
        for (int i = 0; i < x.length(); i++) {
            if (Character.isAlphabetic(x.charAt(i))) {
                chuCai = true;
            } else if (Character.isAlphabetic(x.charAt(i)) || !Character.isDigit(x.charAt(i))) {
                kiTu = true;
            }
        }
        if (ChuanHoa.checkInt(x)) {
            if (Integer.parseInt(x) > tmp) {
                return "không được quá số lượng trong kho" + "(" + tmp + ")";
            }
            else if (Integer.parseInt(x) <= 0) {
                return "không được nhỏ hơn hoặc bằng 0";
            }
        }
        else if (checkDouble(x)) {
            return "phải là số nguyên";
        }
        else if (kiTu && chuCai) {
            return "không được chứa kí tự đặc biệt, chữ cái";
        }
        else if (kiTu && !chuCai) {
            return "không được chứa kí tự đặc biệt";
        }
        else
            return "không được chứa chữ cái";
        return "";
    }

    public static String checkAll(String x) {
        boolean kiTu = false, chuCai = false;
        for (int i = 0; i < x.length(); i++) {
            if (Character.isAlphabetic(x.charAt(i))) {
                chuCai = true;
            } else if (Character.isAlphabetic(x.charAt(i)) || !Character.isDigit(x.charAt(i))) {
                kiTu = true;
            }
        }
        if (ChuanHoa.checkInt(x)) {
            if (Integer.parseInt(x) <= 0) {
                return "không được nhỏ hơn hoặc bằng 0";
            }
        }
        else if (checkDouble(x)) {
            return "phải là số nguyên";
        }
        else if (kiTu && chuCai) {
            return "không được chứa kí tự đặc biệt, chữ cái";
        }
        else if (kiTu && !chuCai) {
            return "không được chứa kí tự đặc biệt";
        }
        else
            return "không được chứa chữ cái";
        return "";
    }

    public static String checkAll1(String x) {
        boolean kiTu = false, chuCai = false;
        for (int i = 0; i < x.length(); i++) {
            if (Character.isAlphabetic(x.charAt(i))) {
                chuCai = true;
            } else if (Character.isAlphabetic(x.charAt(i)) || !Character.isDigit(x.charAt(i))) {
                kiTu = true;
            }
        }
        if (ChuanHoa.checkDouble(x)) {
            if (Integer.parseInt(x) <= 0) {
                return "không được nhỏ hơn hoặc bằng 0";
            }
        }
        else if (kiTu && chuCai) {
            return "không được chứa kí tự đặc biệt, chữ cái";
        }
        else if (kiTu && !chuCai) {
            return "không được chứa kí tự đặc biệt";
        }
        else
            return "không được chứa chữ cái";
        return "";
    }
}
