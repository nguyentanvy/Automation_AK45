package javastream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("tan","vy","dep","trai");
         List<String> filterName =names.stream()
                 .filter(name-> name.startsWith("t"))
                 .collect(Collectors.toList());
                System.out.println(filterName);


        String [] nameSArray = {"Day","La", "Mang"};
        List<String> result = Arrays.stream(nameSArray)
                .filter(text -> text.startsWith("D"))
                .collect(Collectors.toList());
                System.out.println(result);

        List<String> stream = Stream.of("Vy", "La ","so")
        .filter(name-> name.startsWith("Vy"))
                .collect(Collectors.toList());
        System.out.println(stream);

    }
}