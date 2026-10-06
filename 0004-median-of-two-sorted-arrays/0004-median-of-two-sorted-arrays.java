class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];
        
        int i = 0, j = 0, k = 0;
        
        
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        
        // Copy remaining elements from nums1, if any
        while (i < m) {
            merged[k++] = nums1[i++];
        }
        
        // Copy remaining elements from nums2, if any
        while (j < n) {
            merged[k++] = nums2[j++];
        }
        
        // Find and return the median
        int totalLen = m + n;
        if (totalLen % 2 == 1) {
            // Odd length: return the middle element
            return merged[totalLen / 2];
        } else {
            // Even length: return the average of the two middle elements
            int mid1 = merged[totalLen / 2 - 1];
            int mid2 = merged[totalLen / 2];
            return (mid1 + mid2) / 2.0;
        }
    }
}