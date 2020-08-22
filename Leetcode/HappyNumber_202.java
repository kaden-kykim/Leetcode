import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {

    private static int[] sqArr = new int[10];
    static { for (int i = 0; i < 10; ++i) sqArr[i] = i * i; }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    private int getNextSquareArray(int n) {
        int next = 0;
        while (n != 0) {
            next += sqArr[n % 10]; n /= 10;
        }
        return next;
    }

    private int getNext(int n) {
        int next = 0;
        while (n != 0) {
            int rem = n % 10; n /= 10;
            next += rem * rem;
        }
        return next;
    }

    public boolean isHappy1(int n) {
        int[] sqArr = new int[10];
        for (int i = 0; i < 10; ++i) sqArr[i] = i * i;

        Set<Integer> set = new HashSet<>();
        int curNum = n;
        while (curNum != 1) {
            if (!set.contains(curNum)) set.add(curNum);
            else return false;
            int nextNum = 0;
            while (curNum != 0) {
                nextNum += sqArr[curNum % 10];
                curNum /= 10;
            }
            curNum = nextNum;
        }
        return true;
    }

}
