package createfile;

import java.io.File;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){
        try{
            File  file = new File("D:\\Test\\tanvy1.txt");
            boolean check  = file.createNewFile();
            if (check){
                System.out.println("Tao file thanh cong");
            }
            else {
                System.out.println("Tao file khong thanh cong");
            }
        }catch (IOException e){
            System.out.println("Exception Occurred:");
            e.printStackTrace();
        }


    }
}