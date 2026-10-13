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
        for(int p = 0; p < nums1.length; p++){
            for(int q = 0;q < nums1.length - p - 1; q++){

                if(nums1[q] > nums1[q+1]){
                    int temp = nums1[q];
                    nums1[q] = nums1[q+1];
                    nums1[q+1] = temp;
                }
            }
        }

        // Arrays.sort(nums1);
    }
}