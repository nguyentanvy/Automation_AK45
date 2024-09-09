package javastreamperson;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Hanh",15,"1m80");
        Person person2 = new Person("ba",22,"1m98");
        Person person3 = new Person("Hang",31,"1m33");

        List<Person> character = Arrays.asList(person1,person2,person3);
                character.forEach(Person::Show);
                System.out.println("-------------------------------------");
         List<Person> personHeigh = character
                 .stream()
                 .filter(person -> person.getAge()>18)
                 .toList();
         personHeigh.forEach(Person::Show);
        System.out.println("-------------------------------------");
        Integer totalAge = character.stream()
                .mapToInt(Person::getAge)
                .sum();
        System.out.println(totalAge);

        System.out.println("-------------------------------------");
        Integer reduceAge = character.stream()
                .reduce(0,(age, person)->  age + person.getAge(),Integer::sum);
        System.out.println(reduceAge);
        System.out.println("-------------------------------------");

        List<Integer> ages = character
                .stream()
                .map(Person::getAge)
                .collect(Collectors.toList());
        System.out.println(ages);
        System.out.println("-------------------------------------");

//        Person max1 = character
//                .stream()
//                .max(Comparator.comparingInt(Person::getAge))
//                .get();
//        System.out.println(max1.getAge());
        Optional<Person> max1 = character.stream()
                .max(Comparator.comparingInt(Person::getAge));
        max1.ifPresent(person ->
                System.out.println("Oldest person: " +person.getAge()));
        if (max1.isPresent()){
            System.out.println(max1.get().getAge());
        }else {
            System.out.println("Not found");
        }

         Optional<Person> min1 = character.stream()
                 .min(Comparator.comparingInt(Person::getAge));
        min1.ifPresent(person ->
                System.out.println(person.getAge()));

        System.out.println("-------------------------------------");
        List<Person> sortPerson = character.stream()
                .peek(n->System.out.println("Processing: "+ n))
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .collect(Collectors.toList());
        sortPerson.forEach(Person::Show);
        System.out.println(sortPerson);
    }
}