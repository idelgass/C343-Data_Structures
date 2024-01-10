import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.Duration;
import java.time.Instant;

public class Sort {

    // This method should sort the input list using the algorithm for insertion sort.
    // That is, first create a new ArrayList with all of the elements from input ns.
    // Then, iterate through this new ArrayList - comparing a current element to its
    // predecessor. While current is less, it is swapped w predecessor.

    // For those who prefer wordier instructions, check out the Lab 7 post on canvas 🙂
    // Otherwise, best of luck on the lab! Tests/debugging will help a lot with IndexOutOfBoundsExceptions
    static List<Integer> insertionSort (List<Integer> ns) {
        // TODO
        return null;
    }
    
    public static void main(String[] args) {
        
        List<Integer> list1 = Arrays.asList(6,5,3,1,8,7,2,4);
        
        System.out.printf("Original list ns = %s%n", list1);
        System.out.printf("insertionSort ns = %s%n%n", insertionSort(list1));
        
        // TODO: A few more correctness tests
        
        // TODO: Think about what inputs would result in insertion sort taking O(n^2) vs what would cause it 
        // to run in O(n). Create a few test cases to demonstrate these differences in running time.
        
        // TODO: Also test how long it takes to run these insertion sorts, example given below.
        
        Instant start = Instant.now();
        List<Integer> list2 = Arrays.asList(8,7,6,5,1,2,3,4);
        System.out.printf("Original list ns = %s%n", list2);
        System.out.printf("insertionSort ns = %s%n", insertionSort(list2));
        Instant end = Instant.now();
        Duration time = Duration.between(start, end);
        System.out.println(time.toNanos()); // insertion sort is to fast with small input. We will see results with toNanos()
        
    }
}
