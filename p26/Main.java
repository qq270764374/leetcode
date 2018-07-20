package p26;

public class Main {
}

class Solution {
    public int removeDuplicates(int[] nums) {
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
}
