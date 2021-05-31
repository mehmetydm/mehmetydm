package some.issues.someissues.experimentals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Pairs {
    // So i want to show that using nested loops causes time complexity here,
    // but if we use a single set data structure we just decrease coplexity from
    // O(x*y) to O(x) which is simple linear.

    public static void main(String[] args) {
        List<Integer> someNumbers = new ArrayList<Integer>();
        someNumbers.add(3);
        someNumbers.add(5);
        someNumbers.add(7);
        someNumbers.add(9);
        someNumbers.add(10);

        long startTime = System.nanoTime();
        System.out.println(hasPairWithSum(someNumbers, 14));
        long elapsedTime = System.nanoTime()-startTime;
        System.out.println("Elapsed time in ms : " + elapsedTime);

        startTime = System.nanoTime();
        System.out.println(hasPairWithSum2(someNumbers, 14));
        elapsedTime = System.nanoTime()-startTime;
        System.out.println("Elapsed time in ms : " + elapsedTime);

    }
    static boolean hasPairWithSum(List<Integer> numbers, Integer sum){
        for (int i = 0; i< numbers.size()-1; ++i) {
            for (int j = i+1; j<numbers.size(); ++j)
                {
                    if(numbers.get(i)+numbers.get(j) == sum)
                        return true;
                }
        }
        return false;
    }

    static boolean hasPairWithSum2(List<Integer> numbers, Integer sum){
        HashSet<Integer> hashSetNumbers = new HashSet<>(numbers);
        for (Integer num:numbers) {
            if(hashSetNumbers.contains(num))
                return true;
            else
                hashSetNumbers.add(sum-num);
        }
        return false;
    }
}
