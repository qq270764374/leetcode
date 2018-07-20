package p3;

public class Main {
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[128];
        int max = 0;
        for (int i=0,j=0;i<s.length();i++) {
            j = index[s.charAt(i)]<j?j:index[s.charAt(i)];
            max = max<i-j+1?i-j+1:max;
            index[s.charAt(i)] = i + 1;
        }
        return max;
    }
}
