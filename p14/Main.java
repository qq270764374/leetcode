package p14;

public class Main {
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
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
