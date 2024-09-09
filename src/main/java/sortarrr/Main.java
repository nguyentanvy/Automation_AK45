package sortarrr;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int [] arr = {1,4,5,-3,5,-32,-5,21};
        handle(arr);
    }
    public static void handle(int []arr){
        int []newArr = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<0){
                newArr[count]=arr[i];
                count++;
            }
        }
        for (int i = 0; i <arr.length; i++) {
            if (arr[i]>0){
                newArr[count]=arr[i];
                count++;
            }
        }
        System.out.println("Mang sau khi dua so am len dau: "+ Arrays.toString(newArr));
    }
}