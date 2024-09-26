package Chanle;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Nhập số nguyên: ");
        Scanner input = new Scanner(System.in);

        if (!input.hasNextInt()) {  // Kiểm tra xem có phải số nguyên không
            System.out.println("Dữ liệu đầu vào không phải số nguyên");
        } else {
            int dataInput = input.nextInt();  // Đọc số nguyên
            // Kiểm tra số chẵn lẻ
            if (dataInput % 2 == 0) {
                System.out.println(dataInput + " là số nguyên chẵn");
            } else {
                System.out.println(dataInput + " là số nguyên lẻ");
            }
        }
    }
}
