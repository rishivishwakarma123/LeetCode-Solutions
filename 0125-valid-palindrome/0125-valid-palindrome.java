class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            // Skip non-alphanumeric characters from the left
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } 
            // Skip non-alphanumeric characters from the right
            else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } 
            // Compare the characters after converting them to lowercase
            else {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        
        return true;
    }
}