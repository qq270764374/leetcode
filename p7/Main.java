package p7;

public class Main {
}

class Solution {
    public int reverse(int x) {
        long result = 0;

        while(x != 0) {
            int r = x % 10;
            x = (x - r) / 10;
            result = result * 10 + r;
        }

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) result;
        }
    }
}
