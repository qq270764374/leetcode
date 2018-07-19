import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    String show() {
        String s = "";
        s += val;
        if (next != null) {
            s += next.show();
        }
        return s;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("aaa"));
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

    boolean isValid(String s) {
        char[] cs = s.toCharArray();
        int[] valid = new int[cs.length];
        int index = 0;
        for (char c:cs) {
            switch (c){
                case '(':
                    valid[index++] = 1;
                    break;
                case ')':
                    valid[index++] = -1;
                    break;
                case '{':
                    valid[index++] = 2;
                    break;
                case '}':
                    valid[index++] = -2;
                    break;
                case '[':
                    valid[index++] = 3;
                    break;
                case ']':
                    valid[index++] = -3;
                    break;
            }
            if (index > 1 && valid[index-1] < 0) {
                if (valid[index-1] == -valid[index-2]) {
                    index-=2;
                } else {
                    return false;
                }
            }
        }
        return index == 0;
    }

    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int count = 1;
        int base = nums[0];
        int last = 1;
        int change = 1;
        while (last < nums.length) {
            if (nums[last] == base) {
                last ++;
            } else {
                base = nums[last];
                nums[change++] = nums[last++];
                count++;
            }
        }
        return count;
    }

    int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i=0;i<nums.length;i++) {
            if ( nums[i]!=val ) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() == 0) return -1;
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        char first = n[0];
        int max = h.length - n.length;
        for (int i=0;i<=max;i++) {
            if (first != h[i]) while(++i<=max&&first!=h[i]);
            if (i<=max) {
                int j=i+1;
                int end = j+n.length-1;
                for (int k=1;j<end&&h[j]==n[k];j++,k++);
                if (j==end) return i;
            }
        }
        return -1;
    }

    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int scale = 0;
        ListNode head = new ListNode(0);
        ListNode now = head;
        while(l1!=null&&l2!=null) {
            int sum = l1.val + l2.val + scale;
            if (sum >= 10) {
                sum -=10;
                scale = 1;
            } else {
                scale = 0;
            }
            now.next = new ListNode(sum);
            l1 = l1.next;
            l2 = l2.next;
            now = now.next;
        }
        while(l1!=null) {
            int sum = l1.val + scale;
            if (sum >= 10) {
                sum -= 10;
                scale = 1;
            } else {
                scale = 0;
            }
            now.next = new ListNode(sum);
            l1 = l1.next;
            now = now.next;
        }
        while(l2 != null) {
            int sum = l2.val + scale;
            if (sum >= 10) {
                sum -= 10;
                scale = 1;
            } else {
                scale = 0;
            }
            now.next = new ListNode(sum);
            l2 = l2.next;
            now = now.next;
        }
        if (scale == 1) {
            now.next = new ListNode(scale);
            now = now.next;
            scale = 0;
        }
        return head.next;
    }

    int lengthOfLongestSubstring(String s) {
        int[] index = new int[128];
        int max = 0;
        for (int i=0,j=0;i<s.length();i++) {
            j = index[s.charAt(i)]<j?j:index[s.charAt(i)];
            max = max<i-j+1?i-j+1:max;
            index[s.charAt(i)] = i + 1;
        }
        return max;

//        int begin = 0;
//        int max = 0;
//        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
//        char[] cs = s.toCharArray();
//        for (int i = 0;i<cs.length;i++) {
//            if (map.containsKey(cs[i]) && map.get(cs[i]) >= begin) {
//                int j = map.get(cs[i]);
//                begin = j + 1;
//                map.put(cs[i],i);
//            } else {
//                max = max < i-begin + 1? i-begin+1:max;
//                map.put(cs[i],i);
//            }
//        }
//        return max;
    }
}
