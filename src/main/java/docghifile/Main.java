package docghifile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        String path ="D://Test//tanvy2.txt";
        List<String> lines = new ArrayList<>();
//        try(BufferedWriter bf = new BufferedWriter(new FileWriter(path, true))){
//            bf.newLine();
//            bf.write("Vỡ nát con tim vì anh đã mất em rồi");
//            System.out.println("Done!");
//        }
//        catch (IOException e){
//            e.printStackTrace();
//        }
        try(BufferedReader bf = new BufferedReader(new FileReader(path))) {
            String line;
           while ((line= bf.readLine())!=null){
               lines.add(line);

           }
           for (String line1: lines){
               System.out.println(line1);
           }

            System.out.println("\nPrinting words from each line:");
           for (String line1: lines){
               List<String> list = Arrays.stream(line1.split("\\s+")).toList();
               for (String word:list){
                   System.out.println(word);
               }
           }

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
