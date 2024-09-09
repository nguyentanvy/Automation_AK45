package hashmap;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Nhập vào 1 chuỗi: ");
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        Handle(text);
    }
    public static void Handle(String text){
        String []split = text.split("\\s");
        Map<String,Boolean> hashmap = new HashMap<>();
        List<String> arraylist = new ArrayList<>();
        for (String word:split){
            if (!hashmap.containsKey(word)){
                hashmap.put(word, true);
                arraylist.add(word);
            }
        }
        for (String i:arraylist){
            System.out.print(i+" ");
        }
    }
}