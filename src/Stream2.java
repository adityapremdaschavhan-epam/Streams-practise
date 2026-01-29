import java.util.*;
import java.util.stream.*;

record Person(String name, int age){}
record Transaction(String date,int amount){}

public class Stream2 {

    public static void utility(){
        System.out.println("I am utility use me wisely");
    }

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

    public static void addGreaterAverageElement(){
        List<Integer> list = Arrays.asList(1,5,2,3,4,5,5,32,3);
    }

    //Find the intersection of two lists using Java streams:
    public static void findIntersection(){
        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> list2 = Arrays.asList(5,6,7,8,9,10,11,12,13,14,15);
        list1.stream().filter(list2::contains).forEach(n-> System.out.println(n));
    }

//    Given a list of transactions, find the sum of transaction amounts for each day
//    using Java streams:
     public static void sumTransactions(){
         List<Transaction> transactions = Arrays.asList(
                 new Transaction("2022-01-01", 100),
                 new Transaction("2022-01-01", 200),
                 new Transaction("2022-01-02", 300),
                 new Transaction("2022-01-02", 400),
                 new Transaction("2022-01-03", 500)
         );
         System.out.println(transactions.stream().collect(Collectors.groupingBy(Transaction::date,Collectors.summingInt(Transaction::amount))));
    }
//    Find the kth smallest element in an array using Java streams:
    public static void kSmallest(){
        int arr[] = {1,2,3,4,5,6,7,8,9,};
        int k=3;
        System.out.println(Arrays.stream(arr).sorted().skip(k-1).findFirst().getAsInt());
    }

//    Given a list of strings, find the frequency of each word using Java streams:/
    public static void findFrequency(){
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry",
                "banana", "apple");
        System.out.println(words.stream().collect(Collectors.groupingBy(word->word,Collectors.counting())));
    }
//    Implement a method to partition a list into two groups based on a
//    predicate using Java streams.

//    out put of partitioned by{false=[apple, date, fig], true=[banana, cherry]}
    public static void partitionList(){

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean,List<Integer>> partion =  numbers.stream().collect(Collectors.partitioningBy(n->n % 2 == 0 ));
        List<Integer> odd = partion.get(false);
        List<Integer>even = partion.get(true);
        System.out.println("list of odds are" + odd);
        System.out.println("list of even are" + even);
    }
//  1. Find all strings that start with the letter 'a' (case-insensitive) and convert them to uppercase.
//Input:
//List<String> words = Arrays.asList("apple", "banana",
// "Avocado", "cherry", "apricot", "Berry");
//
//Expected Output:
//[APPLE, AVOCADO, APRICOT]

    public static void findStringConvertCase(){
        List<String> words = Arrays.asList("apple", "banana", "Avocado", "cherry", "apricot", "Berry");

        List<String> list = words.stream().filter(word -> word.toLowerCase().startsWith("a")).map(word->word.toUpperCase()).collect(Collectors.toList());

        System.out.println(list);
    }

//    Check if a List Contains a Specific Element/
     public static void checkList(){
         List<Integer> numbers = List.of(1, 2, 3, 4, 5);
         int element1 = 4;
         int element2 = 8;
         System.out.println(numbers.stream().anyMatch(n->n==element1));
         System.out.println(numbers.stream().anyMatch(n->n==element2));
     }
//      Find the Last Element in a List
    public static void findLast(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int last = numbers.stream().reduce((a,b)->b).get();
        System.out.println(last);
    }

//    Check if All Elements in a List Satisfy a Condition
//    public static void checkAllElement(){
//        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
//        int allElement = numbers.stream().allMatch(n->n%2==0);
//        System.out.println(allElement);
//    }



//    Q1. Given a List<String>, return a list of strings that: have length > 5
//    are converted to uppercase
//    sorted alphabetically
    public static void stringMauplation(){
        List<String> words = Arrays.asList("apple", "banana", "Avocado", "cherry", "apricot", "Berry");
        System.out.println(words.stream().filter(n->n.length()>5).map(n->n.toUpperCase()).sorted().collect(Collectors.toList()));
    }

    // Find the Sum of Digits of a Number

    public static void findSumDigit(){
        int number = 1234;
        int sum = String.valueOf(number).chars().map(c->c-'0').sum();
        int sum2 = String.valueOf(number).chars().map(Character::getNumericValue).reduce(0,(a,b)->a+b);
        System.out.println(sum2);
    }
    // Find the Second-Largest Element in a List
    public static void findSecondLargest(){
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println(numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());
        List<String> words = List.of("apple", "banana", "kiwi");
        System.out.println(words.stream().sorted(Comparator.comparingInt(String::length).reversed()).findFirst().get());
    }
    static void main() {
        utility();
//        findLongestStrings();
//        calculateAverageOfPerson();
//        MergeTwoSorted();
//        28-jan-2026
//        findIntersection();
//        sumTransactions();
//        kSmallest();
//        findFrequency();
//         partitionList();
//        findStringConvertCase();
//        29-01-26
//        checkList();
//        findLast();
//        checkAllElement();
//          stringMauplation();
//            findSumDigit();
            findSecondLargest();

    }
}
