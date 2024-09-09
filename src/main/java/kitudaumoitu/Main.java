package kitudaumoitu;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Nhap vao mot chuoi: ");
        Scanner input = new Scanner(System.in);
        String text= input.nextLine();
        Show(text);
    }
    public static void Show(String text){
        String word = "";
        String [] split = text.split(" ");
        for (String i:split){
            System.out.println("Ki tu dau tien cua moi tu trong cau: "+ i.charAt(0));
        }
    }
}