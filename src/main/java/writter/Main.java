package writter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
       String path = "D:\\Test\\tanvy1.txt";
        String line;
//       try( BufferedWriter bf = new BufferedWriter(new FileWriter(path, true))) {
//           bf.newLine();
//           bf.write("Nguyen Tan Vy handsome dep trai vcl");
//
//           System.out.println("Done!");
//       }catch (IOException e){
//           e.printStackTrace();
//
//       }
       try(BufferedReader bf = new BufferedReader(new FileReader(path))){

           while ((line = bf.readLine()) !=null){ // Gán từng dòng cho line rồi kiểm tra xem line có phải là null không, nếu là null thì dừng vòng lặp
               System.out.println(line);
               List<String> words = Arrays.stream(line.split("\\s+")).toList();
               System.out.println("List of word: ");
               for (String word: words){
                   System.out.println(word);
               }
           }
           System.out.println("Done!");

       }catch (IOException e){
           e.printStackTrace();
       }

    }
}
