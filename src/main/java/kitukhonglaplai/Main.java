package kitukhonglaplai;

import java.util.LinkedHashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String text = "swiss";
        char result = firstNonRepeatingCharacter(text);

        if (result != '\0') {
            System.out.println("Ký tự đầu tiên không lặp lại là: " + result);
        } else {
            System.out.println("Không có ký tự nào không lặp lại trong chuỗi.");
        }
    }

    public static char firstNonRepeatingCharacter(String text) {
        // Sử dụng LinkedHashMap để lưu trữ ký tự và số lần xuất hiện
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();

        // Đếm số lần xuất hiện của mỗi ký tự
        for (char ch : text.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }

        // Tìm ký tự đầu tiên không lặp lại
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        // Nếu không tìm thấy ký tự nào không lặp lại
        return '\0';
    }
}