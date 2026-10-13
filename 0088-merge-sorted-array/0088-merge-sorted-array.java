import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int i = nums1.length - 1;
        int  k = m;
        int j = 0;
        while(k < (nums1.length)){
            
            nums1[k] = nums2[j];
            j++;
            // i--;

            k++;
        }

        Arrays.sort(nums1);
    }
}