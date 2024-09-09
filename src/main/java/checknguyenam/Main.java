package checknguyenam;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static boolean checknguyenam(String n){
        return "aeiouAEIOU".contains(n);
    };
    static boolean kituduynhat(String n){
        if(n.length() == 1)
            return true;
        else return false;
    };
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it
        System.out.println("Nhap 1 ki tu");
        Scanner input = new Scanner(System.in);
        String n = input.nextLine();
        if( kituduynhat(n)&&checknguyenam(n) == true){
            System.out.println("La nguyen am duy nhat");
        }
        else{
            System.out.println("Khong phai nguyen am duy nhat");
        }
    }
}