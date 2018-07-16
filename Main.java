public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"a"}));
    }
}

class Solution {
    int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length ; i++) {
            for (int j = i + 1; j < nums.length ; j++) {
                if (target == nums[i] + nums[j]) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                }
            }
        }

        return result;
    }

    int reverse(int x) {
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

    boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String origin = String.valueOf(x);
        return new StringBuilder(origin).reverse().toString().equals(origin);
    }

    int romanToInt(String s) {
        int result = 0;

        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            char next = ' ';
            if (i+1 < cs.length) {
                next = cs[i+1];
            }
            switch (c) {
                case 'I':
                    if (next == 'V' || next == 'X') {
                        result -= 1;
                    } else {
                        result += 1;
                    }
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    if ( next == 'L' || next == 'C') {
                        result -= 10;
                    } else {
                        result += 10;
                    }
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    if ( next == 'D' || next == 'M') {
                        result -= 100;
                    } else {
                        result += 100;
                    }
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
            }
        }

        return result;
    }

    String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) { return ""; }
        char[] cs = strs[0].toCharArray();
        int i = 0;
        boolean isFinish = false;
        for (;i<cs.length;i++) {
            for (int j=1;j<strs.length;j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != cs[i]) {
                    isFinish = true;
                    break;
                }
            }
            if (isFinish) { break; }
        }
        return strs[0].substring(0,i);
    }
}
