import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        
        // Map to store each character and its last seen index
        Map<Character, Integer> charMap = new HashMap<>();
        
        // Sliding window pointers: 'left' and 'right'
        for (int right = 0, left = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            
            // If the character is already in the window, jump the left pointer 
            // to one position after its last occurrence
            if (charMap.containsKey(currentChar)) {
                left = Math.max(left, charMap.get(currentChar) + 1);
            }
            
            // Update the character's latest index and calculate max length
            charMap.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}