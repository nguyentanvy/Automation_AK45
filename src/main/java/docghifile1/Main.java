package docghifile1;

import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String path = "D:\\Test\\tanvy.txt";
        try(BufferedWriter br = new BufferedWriter(new FileWriter(path, true))) {
            br.write("Việt Nam số 1");
            br.newLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("Done!");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}