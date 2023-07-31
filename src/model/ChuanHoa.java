package model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

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
        x = x.trim();
        if(x.equals("")){
            return "Không được bỏ trống";
        }
        else {
            boolean kiTu = false, chuCai = false, dauCach = false;
            Set<Character> listKiTu = new HashSet<>();
            for (int i = 0; i < x.length(); i++) {
                if (Character.isAlphabetic(x.charAt(i))) {
                    chuCai = true;
                } else if (Character.isAlphabetic(x.charAt(i)) || !Character.isDigit(x.charAt(i))) {
                    if(x.charAt(i) != '.'){
                        listKiTu.add(x.charAt(i));
                        if(x.charAt(i) == ' '){
                            dauCach = true;
                        }
                    }
                    kiTu = true;
                }
            }
            if (listKiTu.size() == 1){
                for(Character c : listKiTu){
                    if(c == ' '){
                        return "không được chứa dấu cách";
                    }
                }
            }
            if (checkDouble(x)) {
                if(Double.parseDouble(x) - (int)Double.parseDouble(x) != 0){
                    return "phải là số nguyên";
                }
                else if(Double.parseDouble(x) <= 0){
                    return "không được nhỏ hơn hoặc bằng 0";
                }
                else if(Double.parseDouble(x) > Integer.MAX_VALUE){
                    return "bị quá giới hạn số nguyên";
                }
                else if(Double.parseDouble(x) > tmp){
                    return "không được quá số lượng trong kho " + "(" + tmp + ")";
                }
            }
            else if (kiTu && chuCai && dauCach) {
                return "không được chứa kí tự đặc biệt, chữ cái, dấu cách";
            }
            else if (kiTu && chuCai && !dauCach) {
                return "không được chứa kí tự đặc biệt, chữ cái";
            }
            else if (kiTu && !chuCai && dauCach) {
                return "không được chứa kí tự đặc biệt, dấu cách";
            }
            else if (!kiTu && chuCai && dauCach) {
                return "không được chứa kí tự chữ cái, dấu cách";
            }
            else if(kiTu && !chuCai && !dauCach){
                return "không được chứa kí tự đặc biệt";
            }
            else
                return "không được chứa chữ cái";
            return "";
        }

    }

    public static String checkAll(String x) {
        x = x.trim();
        if(x.equals("")){
            return "Không được bỏ trống";
        }
        else {
            boolean kiTu = false, chuCai = false, dauCach = false;
            Set<Character> listKiTu = new HashSet<>();
            for (int i = 0; i < x.length(); i++) {
                if (Character.isAlphabetic(x.charAt(i))) {
                    chuCai = true;
                } else if (Character.isAlphabetic(x.charAt(i)) || !Character.isDigit(x.charAt(i))) {
                    if(x.charAt(i) != '.'){
                        listKiTu.add(x.charAt(i));
                        if(x.charAt(i) == ' '){
                            dauCach = true;
                        }
                    }
                    kiTu = true;
                }
            }
            if (listKiTu.size() == 1){
                for(Character c : listKiTu){
                    if(c == ' '){
                        return "không được chứa dấu cách";
                    }
                }
            }
            if (checkDouble(x)) {
                if(Double.parseDouble(x) <= 0){
                    return "không được nhỏ hơn hoặc bằng 0";
                }
                else if(Double.parseDouble(x) > Integer.MAX_VALUE){
                    return "bị quá giới hạn số nguyên";
                }
                else if(Double.parseDouble(x) - (int)Double.parseDouble(x) != 0){
                        return "phải là số nguyên";
                }
            }
            else if (kiTu && chuCai && dauCach) {
                return "không được chứa kí tự đặc biệt, chữ cái, dấu cách";
            }
            else if (kiTu && chuCai && !dauCach) {
                return "không được chứa kí tự đặc biệt, chữ cái";
            }
            else if (kiTu && !chuCai && dauCach) {
                return "không được chứa kí tự đặc biệt, dấu cách";
            }
            else if (!kiTu && chuCai && dauCach) {
                return "không được chứa kí tự chữ cái, dấu cách";
            }
            else if(kiTu && !chuCai && !dauCach){
                return "không được chứa kí tự đặc biệt";
            }
            else
                return "không được chứa chữ cái";
        }
        return "";
    }
}
