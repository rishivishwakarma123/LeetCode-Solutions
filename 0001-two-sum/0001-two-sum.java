import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<> ();

        for(int i = 0; i< nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[] {
                    map.get(complement),i 
                };
            
             }
            map.put(nums[i], i);
            }
               return new int[] {};
    }
}      
        


//worst solution 
        // for(int i = 0; i<nums.length -1; i++){
        //     for(int j =1 + i; j< nums.length ; j++){
        //         if((nums[j] + nums[i]) == target ){
        //           return new int[] {i, j};
        //         }
        //     }
        // }
//          return new int[] {};
//     }
// }