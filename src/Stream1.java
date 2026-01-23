import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Stream;

record Person(String name, int age){}

public class Stream1 {

    // Find the longest string in a list of strings using Java streams:
  public static void findLongestStrings(){
      List<String>  list = Arrays.asList("apple", "banana", "cherry", "date", "grapefruit");

      //using reduce
      System.out.println(list.stream().
              reduce((a,b)->(a.length()>b.length()) ? a : b).get());

      // using sorted
      System.out.println(list.stream()
              .sorted(Comparator.comparingInt((String::length)).reversed())
              .findFirst().get());

      // using max()
      System.out.println(list.stream().max(Comparator.comparingInt(String::length)).get());
  }
  //Calculate the average age of a list of Person objects using Java streams:

    public static void calculateAverageOfPerson(){
        List<Person> persons = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35)
        );

        // using builtin average function
        System.out.println((persons.stream().mapToInt(Person::age).average()).getAsDouble());

        // using custom logic
        int sum = persons.stream().mapToInt(Person::age).sum();
        int size = persons.size();
        System.out.println((double)sum/size);
    }

    // Q. Merge two sorted lists into a single sorted list using Java streams:
    public static void MergeTwoSorted()
    {
        // using new list
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(5,6,7,8,9);
        List<Integer> list3 = new ArrayList<>(list1);
        list3.addAll(list2);
        System.out.println(list3.stream().sorted().toList());

        // stream.concat()
        System.out.println(Stream.concat(list1.stream(),list2.stream()).sorted().toList());
    }

    static void main() {
//        findLongestStrings();
//        calculateAverageOfPerson();
//        MergeTwoSorted();

    }
}
