package minmax;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int []arr = {1,3,4,5,34,12,2};
        Show(arr);
    }
    public static void Show(int []arr) {
        int min = arr[0];
        int max = arr[0];
        int num = arr.length;
        int second = arr[0];
        for (int i = 0; i < num - 1; i++) {
            if (min > arr[i]) {
                min = arr[i];
            } else if (max < arr[i]) {
                second=max;
                max = arr[i];
            }
            else if (arr[i] > second && arr[i] < max) {
                second = arr[i];
            }
        }
        System.out.println("Lon nhat "+ max + " lon thu hai: " + second  +" be nhat: "+ min);
        }
}