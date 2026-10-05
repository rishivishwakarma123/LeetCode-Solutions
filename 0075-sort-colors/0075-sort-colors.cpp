#include<vector>
class Solution {
public:
    void sortColors(vector<int>& nums) {
        
        int start = 0;
        int mid = 0;
        int end = nums.size() - 1;

        while(mid <= end){
            
            switch(nums[mid]){

                case 0:
                        swap(nums, start, mid);
                        mid++;
                        start++;
                        break;
                case 1: 
                        mid++;
                        break;
                case 2:
                        swap(nums, mid, end);
                        end--;
                        break; 
            }
        }  
    }

    public:
        void swap(vector<int> &nums, int pos1, int pos2){
            int temp = nums[pos1];
            nums[pos1] = nums[pos2];
            nums[pos2] = temp;
        }
        
};