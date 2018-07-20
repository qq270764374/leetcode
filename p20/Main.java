package p20;

public class Main {
}

class Solution {
    public boolean isValid(String s) {
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
}
