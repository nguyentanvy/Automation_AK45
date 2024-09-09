package kitukhonglaplai_input;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Nhap chuoi: ");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        char resuilt = Kitulapdautien(text);
        if(resuilt!= '\0'){
            System.out.println("Ki tu khong lap lai dau tien la: "+ resuilt);
        }
        else {
            System.out.println("Không có kí tự nào khong lặp lại trong chuoi.");
        }
    }
    public static char Kitulapdautien(String text){
        int[] mangkitu = new int[256];
        char [] chars = text.toCharArray();

        for (char ch:chars) {
            mangkitu[ch]++;
        }

        for (char ch:chars) {
            if (mangkitu[ch]==1){
                return ch;
            }
        }
        return '\0';
    }
}