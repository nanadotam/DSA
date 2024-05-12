import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListWork {
    public static void main(String[] args) {
        // Create an empty array list object
        ArrayList mixedList = new ArrayList();

        mixedList.add("Java");
        mixedList.add(123);
        mixedList.add(45.67);
        mixedList.add(true);

        // print array list
        // System.out.println("Original List: " + mixedList);

        for (int i = 0; i < mixedList.size(); i++) {
            Object element = mixedList.get(i);
            System.out.println(element);
        }

        // System.out.println("List Items: ");
        // for (Object i : mixedList) {
        //     System.out.println(i);
        // }

        // Generic Array List
        ArrayList <Integer> numberList = new ArrayList<>();

        numberList.add(10);
        numberList.add(20);
        numberList.add(30);
        numberList.add(40);
        numberList.add(50);

        int sum = 0;
        // calculate and print the sum of all elements
        for (int i = 0; i < numberList.size(); i++) {
            Integer element = numberList.get(i);
            sum += element;
        }
        System.out.println("sum: " + sum);
        

        mixedList.remove("Java");
        // add new integer value 777 to numberList at index 2
        numberList.set(2, 777);
        
        // display updated lists
        System.out.println("\nUpdated Mixed List: " + mixedList);
        System.out.println("Updated Number List: " + numberList);
        
        // enhanced for loop
        for (Integer Item : numberList) {
            System.out.println(Item);
        }

        // iterator
        Iterator<Integer> iterator = numberList.iterator();
        while (iterator.hasNext()) {
            Integer nextElement = iterator.next();
            System.out.println(nextElement);
        }
    }
}
