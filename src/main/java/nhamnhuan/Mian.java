package nhamnhuan;

import java.util.Scanner;

public class Mian {
    public static boolean checkYear(int dataInput){

        if((dataInput%4==0 && dataInput%100!=0) || (dataInput%400==0)){
            return true;
        }
        else
           return false;
    }
}
