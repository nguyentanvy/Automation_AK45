package timlaplaicuamang;

import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int []arr = {1,3,4,2,6,2,6,8,34};
        Show(arr);
    }
    public static void Show(int []arr){
        Map<Integer,Integer> count = new HashMap<>();
        Map<Integer,String> vitri = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num= arr[i];
            if (count.containsKey(num))
            {
                count.put(num, count.get(num)+1);
                vitri.put(num, vitri.get(num) + ","+ i);
            }
            else
            {
                count.put(num, 1);
                vitri.put(num,String.valueOf(i));
            }

        }
        boolean check = false;
        for (Map.Entry<Integer, Integer> entry:count.entrySet()){
            int num = entry.getKey();
            int count1 = entry.getValue();
            if(count1 >1 ){
                System.out.println("Số "+num+ " lặp lại " + count1+ " lần vị trí " + vitri.get(num));
            }
            check = true;

        }
        if (check== false){
            System.out.println("Không có số lặp lại");
        }


    }
}