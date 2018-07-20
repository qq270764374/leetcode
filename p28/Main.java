package p28;

public class Main {
}

class Solution {
    public int strStr(String haystack, String needle) {
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
}