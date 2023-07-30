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
        try {
            if(ChuanHoa.checkInt(x) && x.charAt(0) == '0' && x.trim().length() == 10){
                return true;
            }
            return false;
        } catch(Exception e) {
            return false;
        }
    }

    public static boolean checkSoAm(String x, int k){
        if(ChuanHoa.checkInt(x)){
            if(Integer.parseInt(x) <= 0){
                return false;
            }
            if(Integer.parseInt(x) > k){
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean checkSoAm(String x){
        if(ChuanHoa.checkInt(x)){
            if(Integer.parseInt(x) <= 0){
                return false;
            }
            return true;
        }
        return false;
    }
}
