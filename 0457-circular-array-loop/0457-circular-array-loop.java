import java.util.HashSet;
import java.util.Set;

class Solution {

    public int calNextIdx(int[] nums, int curr) {
        int n = nums.length;
        int next = (curr + nums[curr]) % n;
        // Handle negative modulo in Java
        if (next < 0) {
            next += n;
        }
        return next;
    }

    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            boolean isPos = nums[i] > 0;
            int curr = i;

            while (true) {
                int next = calNextIdx(nums, curr);

                // 1. Check if direction changes (positive vs negative)
                if ((isPos && nums[next] < 0) || (!isPos && nums[next] > 0)) {
                    break;
                }

                // 2. Cycle detection
                if (set.contains(next)) {
                    // Check if loop length > 1 (curr != next means valid loop)
                    if (curr != next) {
                        return true;
                    } else {
                        break; // Self-loop of length 1 is invalid
                    }
                }

                set.add(next);
                curr = next;
            }
        }
        return false;
    }
}