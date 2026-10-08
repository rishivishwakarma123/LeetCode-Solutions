class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            // Using low + (high - low) / 2 prevents potential integer overflow
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid; // Target found, return its index
            } 
            else if (nums[mid] < target) {
                low = mid + 1; // Target must be in the right half
            } 
            else {
                high = mid - 1; // Target must be in the left half
            }
        }

        return -1; // Target not found
    }
}