package minmax;

public class ak46 {
    public static void main(String[] args) {
        int[] arr = {1, 4, 9, 0, 2, 8}; // Changed char[] to int[]
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) { // Changed loop to iterate through the entire array
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Minimum value: " + min);
    }
}