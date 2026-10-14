import java.util.Collections;
import java.util.List;

class Solution {
    public int countPairs(List<Integer> nums, int target) {

        int count = 0;

        for(int i = 0; i<nums.size() -1; i++){
            for(int j =1 + i; j< nums.size() ; j++){
                if(nums.get(j) + nums.get(i) < target ){
                    count++;
                }
            }
        }

        
        // List ko sort karo
        // Collections.sort(nums);
        
        // int left = 0;
        // int right = nums.size() - 1;
        // int count = 0;
        
        // while (left < right) {
        //     if (nums.get(left) + nums.get(right) < target) {
        //         // Agar sum target se chota hai, toh left aur right ke beech 
        //         // ke saare elements right ke sath valid pairs banayenge
        //         count += (right - left);
        //         left++;
        //     } else {
        //         // Agar sum target ya usse bada hai, toh right ko kam karo
        //         right--;
        //     }
        // }
        
        return count;
    }
}