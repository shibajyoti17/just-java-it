package collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class StringLengthComparator implements Comparator<String>{

    @Override
    public int compare(String first, String second){
        return first.length() - second.length();
    }
}
public class DemoList{
    public static void main(String[] args) {
        // Creating a new arraylist 
        List<Integer> newList = new ArrayList<>();
        // Adding two new elements to the array list
        newList.add(10);
        newList.add(20);
        System.out.println(newList);
        // Adding an element at a particular index
        newList.add(1,30);
        System.out.println(newList);
        // Removing an element by index from the list
        newList.remove(1);
        System.out.println(newList);
        // Removing an element by object/type
        newList.remove(Integer.valueOf(20));
        System.out.println(newList);
        newList.add(5);
        newList.add(100);
        // Declaring an immutable list 
        List<Integer> immutableList = List.of(14, 20, 30, 40, 82);
        // Adding a collection to a List
        newList.addAll(2, immutableList);
        System.out.println(newList);
        // Returns the number of elements in the list
        System.out.println(newList.size());
        // This function ensures the list is trimmed to minimum size possible in terms of capacity
        // newList.trimToSize(); This throws an error since trimToSize is specific to Arraylist and
        // the intial declaration does declare it as type of List
        // The below function converts an existing list to an array
        Object arr[] = newList.toArray();
        for(Object i: arr){
            System.out.print(i + " ");
        }
        System.out.println();

        // This method converts an array to a list 
        String fruits[] = {"apple", "banana", "cherry", "mango", "dragonfruit"};
        List<String> fruitList = Arrays.asList(fruits);
        for (Object i : fruitList){
            System.out.println(i);
        }

        // The sort functionality
        fruitList.sort(new StringLengthComparator());
        System.out.println(fruitList);

        // Using lambda functions
        fruitList.sort((a, b) -> b.length() - a.length());
        System.out.println(fruitList);
    }
}