import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


class Exercises {
    private String reverseString(String s){
        StringBuilder reversed = new StringBuilder();
        for (int i=s.length()-1; i>=0; i--) {
            reversed.append(s.charAt(i));
        }
        return reversed.toString();
    }

    private String[] fizzBuzz(int n){
        String[] result = new String[n];
        for (int i=1; i<=n; i++) {
            if (i % 15 == 0) {
                result[i - 1] = "Fizz buzz";
            } else if (i % 5 == 0) {
                result[i - 1] = "Buzz";
            } else if (i % 3 == 0) {
                result[i - 1] = "Fizz";
            } else {
                result[i - 1] = Integer.toString(i);
            }
        }
        return result;
    }

    private int[] twoSum(int[] nums, int target) { // one-pass hash table approach
        Map<Integer, Integer> reverseHashMap = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++) {
            if (nums[i] <= target) {
                reverseHashMap.putIfAbsent(nums[i], i);
                if (reverseHashMap.containsKey(target - nums[i])) {
                    return new int[]{reverseHashMap.get(target - nums[i]), i};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    private int reverseInteger(int theNum) { // the overflow thing doesn't seem to work though
        int theReversedNum = 0;
        while (theNum != 0) {
            int dig = theNum % 10;
            theNum = theNum / 10;
            if (theReversedNum * 10 > Integer.MAX_VALUE || theReversedNum * 10 < Integer.MIN_VALUE) {
                return 0;
            }
            theReversedNum = theReversedNum * 10 + dig;
        }
        return theReversedNum;
    }

    private int[] moveZeros(int[] numbersMz) {
        for (int i=0; i<numbersMz.length; i++) {
            if (numbersMz[i] == 0) {
                for (int j=i+1; j<numbersMz.length; j++) {
                    if (numbersMz[j] != 0) {
                        numbersMz[i] = numbersMz[j];
                        numbersMz[j] = 0;
                        break;
                    }
                }
            }
        }
        return numbersMz;
    }

    public static void main(String[] args) {
            // Exercise 1: Reverse string
            Exercises rs = new Exercises();
            System.out.println(rs.reverseString("irina"));

            // Exercise 2: Fizz buzz
            Exercises fb = new Exercises();
            String[] resultFizzBuzz = fb.fizzBuzz(15);
            System.out.println(Arrays.toString(resultFizzBuzz));

            // Exercise 3: Two sum
            Exercises ts = new Exercises();
            int[] numbersTs = {9, 2, 0, 7, 11, 15};
            int target = 9;
            System.out.println(Arrays.toString(ts.twoSum(numbersTs, target)));

            // Exercise 4: Reverse integer
            int theNum = -123;
            Exercises ri = new Exercises();
            int theReversedNum = ri.reverseInteger(theNum);
            System.out.println(theReversedNum);

            // Exercise 5: Move zeros
            int[] numbersMz = {0, 199, 5, 0, 3, 12, 0};
            Exercises mz = new Exercises();
            int[] movedZeros = mz.moveZeros(numbersMz);
            System.out.println(Arrays.toString(movedZeros));

    }
}
