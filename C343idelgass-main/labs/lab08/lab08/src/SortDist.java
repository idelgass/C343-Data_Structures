import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortDist {
    static int increment(int n) {
        // From https://oeis.org/search?q=shell+sort
        // a(n) = 9*2^n - 9*2^(n/2) + 1 if n is even;
        // a(n) = 8*2^n - 6*2^((n+1)/2) + 1 if n is odd.
        if (n % 2 == 0)
            return (int) (9 * Math.pow(2, n) - 9 * Math.pow(2, n / 2) + 1);
        else
            return (int) (8 * Math.pow(2,n) - 6 * Math.pow(2,(n + 1) / 2) + 1);
    }
    /**
     * Steps:
     * 1. create an array list gapSequence that calls increment above until the
     *    gap is more than half of the size of the array (increase i by 1 each time you call increment)
     * 2. Start from the largest gap and iterate down the list of gaps
     * 3. For each gap, do an insertion sort for the elements separated
     *    by the given gap
     * 4. Return your list of sorted elements at the end of all gaps
     */
    private static List<Integer> insertionSubroutine(List<Integer> ns, int start, int gap){
        for(int i = start + gap; i < ns.size(); i += gap){
            for(int j = i; j >= gap && ns.get(j - gap) > ns.get(j); j -= gap){
                int temp = ns.get(j - gap);
                ns.set(j - gap, ns.get(j));
                ns.set(j, temp);
            }
        }
        return ns;
    }
    static List<Integer> shellSort (List<Integer> ns) {
        ArrayList<Integer> gapSequence = new ArrayList<>();
        List<Integer> result = ns;
        int i = 0;
        //TODO: Implement Task B
        while(increment(i) < (ns.size() / 2)) gapSequence.add(i++, increment(i));
        // For each gap size
        for(int j = gapSequence.size() - 1; j >= 0; j--) {
            int gap = gapSequence.get(j);
            // Sort each sublist (n sublists for gap size n)
            for (int k = 0; k < gap; k++) insertionSubroutine(result, j, gap);
        }
        insertionSubroutine(result, 0, 1);
        return result;
    }

    static int partition(List<Integer> ns, int begin, int end) {
        int pivotElement = ns.get(end + 1); // Pivot element always at the end of arr
        // Shift bounds towards each other until they cross
        while(begin <= end){
            while(ns.get(begin) < pivotElement) begin++;
            while(end >= begin && ns.get(end) >= pivotElement) end--;
            // Swap
            if(end > begin){
                int beginTemp = ns.get(begin);
                ns.set(begin, ns.get(end));
                ns.set(end, beginTemp);
            }
        }
        return begin;
    }

    static List<Integer> quickSort(List<Integer> ns, int begin, int end) {
        int pivotIndex = (begin + end)/2;

        //Swap end with pivot
        int endTemp = ns.get(end);
        ns.set(end, ns.get(pivotIndex));
        ns.set(pivotIndex, endTemp);

        int firstPosRight = partition(ns, begin, end - 1);

        //Swap pivot with first position in right subarray
        int firstPosRightTemp = ns.get(firstPosRight);
        ns.set(firstPosRight, ns.get(end));
        ns.set(end, firstPosRightTemp);

        if(firstPosRight - begin > 1) quickSort(ns, begin, firstPosRight - 1);
        if(end - firstPosRight > 1) quickSort(ns, firstPosRight + 1, end);
        return ns;
    }

    public static void main(String args[]) {
        // Testing shellsort
        System.out.println("Testing shellsort...");
        List<Integer> list = Arrays.asList(1, 9, 81, 32, 4, 94, 7, 2, 35, 1, 90, 100, 7);
        Instant start = Instant.now();
        System.out.println(shellSort(list));
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toNanos());

        list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        start = Instant.now();
        shellSort(list);
        System.out.println(list);
        end = Instant.now();
        System.out.println(Duration.between(start,end).toNanos());

        list = Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        start = Instant.now();
        shellSort(list);
        System.out.println(list);
        end = Instant.now();
        System.out.println(Duration.between(start,end).toNanos());


        // Testing quicksort
        System.out.println("Testing quicksort...");
        list = Arrays.asList(1, 9, 81, 32, 4, 94, 7, 2, 35, 1, 90, 100, 7);
        start = Instant.now();
        System.out.println(quickSort(list, 0, 12));
        end = Instant.now();
        System.out.println(Duration.between(start, end).toNanos());

        list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        start = Instant.now();
        quickSort(list, 0, 9);
        System.out.println(list);
        end = Instant.now();
        System.out.println(Duration.between(start,end).toNanos());

        list = Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        start = Instant.now();
        quickSort(list, 0, 9);
        System.out.println(list);
        end = Instant.now();
        System.out.println(Duration.between(start,end).toNanos());
    }
}
