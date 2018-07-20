package p9;

public class Main {
}

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String origin = String.valueOf(x);
        return new StringBuilder(origin).reverse().toString().equals(origin);
    }
}
