package soluongnguyenam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Nhập vào một chuỗi: ");
        Scanner input = new Scanner(System.in);
        String text= input.nextLine();
        Show(text);
    }
    public  static void Show(String text){
        int  soNguyenAm = 0;
        String nguyenAm= "aeiouAEIOU";
        Map<String, Integer> hasmap = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            String ch= String.valueOf(text.charAt(i));
            if(nguyenAm.indexOf(ch)!=-1){
                soNguyenAm++;
                if (hasmap.containsKey(ch)){
                    hasmap.put(ch ,hasmap.get(ch)+1);
                }
                else {
                    hasmap.put(ch,1);
                }
            }
        }
        System.out.println("Số lượng nguyên âm của chuỗi: " + soNguyenAm);
        for ( Map.Entry<String, Integer> entry:hasmap.entrySet()){
          System.out.println("Nguyen am "+entry.getKey() +" Xuat hien " + entry.getValue()+" lan");
      }

//        Map<String, Integer> hasmap = new HashMap<>();
//        for (int i = 0; i < text.length(); i++) {
//            String ch= String.valueOf(text.charAt(i));
//            if (hasmap.containsKey(ch)){
//
//                hasmap.put(ch ,hasmap.get(ch)+1);
//            }
//            else {
//                hasmap.put(ch,1);
//            }
//        }
//
//        for ( Map.Entry<String, Integer> entry:hasmap.entrySet()){
//
//            System.out.println("Nguyen am "+entry.getKey() +"Xuat hien " + entry.getValue()+" lan");
//        }
    }
}