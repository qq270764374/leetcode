package p4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1,2},new int[]{1,2}));
    }

}

class Solution {

    double findKth(int[] nums1,int[] nums2,int k) {
        int l1 = nums1.length,l2 = nums2.length;
        if ( l1 > l2 ) { return findKth(nums2,nums1,k); }
        if (l1 == 0) { return nums2[k - 1]; }
        if (k == 1) { return nums1[0] <= nums2[0] ? nums1[0] : nums2[0]; }
        int i = l1 < k/2 ? l1 : k /2;
        int j = l2 < k/2 ? l2 : k/2;
        if (nums1[i-1]<nums2[j-1]) {
            return findKth(Arrays.copyOfRange(nums1,i,l1),nums2,k-i);
        } else {
            return findKth(nums1,Arrays.copyOfRange(nums2,j,l2),k-j);
        }
    }

    double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length,l2 = nums2.length;
        if ((l1 + l2 ) % 2 == 0) {
            return (findKth(nums1,nums2,(l1+l2)/2) + findKth(nums1,nums2,(l1+l2)/2+1)) / 2.0;
        } else {
            return findKth(nums1,nums2,(l1 + l2)/2 + 1);
        }
//        int l1 = nums1.length,l2 = nums2.length;
//        if (l1 == 0) {
//            return l2 % 2 == 0 ? (nums2[l2/2-1] + nums2[l2/2]) / 2.0 : nums2[l2/2];
//        }
//        if (l2 == 0) {
//            return l1 % 2 == 0 ? (nums1[l1/2-1] + nums1[l1/2]) / 2.0 : nums1[l1/2];
//        }
//        int i=-1,j=-1;
//        for (;i<l1-1 || j<l2-1;) {
//            if (i==l1-1) {
//                j++;
//            } else if (j==l2-1) {
//                i++;
//            } else if (nums1[i+1] <= nums2[j+1]) {
//                i++;
//            } else {
//                j++;
//            }
//            if ((l1 + l2 ) % 2 == 0) {
//                if (i+1 + j+1 == (l1 + l2)/2) { break;}
//            } else {
//                if (i+1 + j+1 == (l1 + l2) /2 + 1) { break;}
//            }
//        }
//        if ((l1+l2)%2==0) {
//            int m;
//            if (i == -1) { m = nums2[j]; }
//            else if (j == -1) { m = nums1[i]; }
//            else {
//                m = nums1[i]<=nums2[j] ? nums2[j] : nums1[i];
//            }
//            if (i == l1 - 1 && j == l2-1) {
//              return (nums1[i] + nums2[j]) / 2.0;
//            } else if (i == l1-1) {
//                return (m + nums2[j+1]) / 2.0;
//            } else if (j == l2-1) {
//                return (m + nums1[i+1]) / 2.0;
//            } else {
//                int m1 =nums1[i+1]<=nums2[j+1]?nums1[i+1]:nums2[j+1];
//                return (m + m1) / 2.0;
//            }
//        } else {
//            if ( i == -1) { return nums2[j]; }
//            else if (j == -1) { return nums1[i];}
//            else {
//                return nums1[i] <= nums2[j] ? nums2[j] : nums1[i];
//            }
//        }
    }
}
