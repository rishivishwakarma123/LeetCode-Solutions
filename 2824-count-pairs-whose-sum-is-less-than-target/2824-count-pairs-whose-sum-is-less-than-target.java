import java.util.Collections;
import java.util.List;

class Solution {
    public int countPairs(List<Integer> nums, int target) {
        // List ko sort karo
        Collections.sort(nums);
        
        int left = 0;
        int right = nums.size() - 1;
        int count = 0;
        
        while (left < right) {
            if (nums.get(left) + nums.get(right) < target) {
                // Agar sum target se chota hai, toh left aur right ke beech 
                // ke saare elements right ke sath valid pairs banayenge
                count += (right - left);
                left++;
            } else {
                // Agar sum target ya usse bada hai, toh right ko kam karo
                right--;
            }
        }
        
        return count;
    }
}