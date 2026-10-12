class Solution {
    public boolean validhelper(int i, int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        
        while(i < j){
            char left = s.charAt(i);
            char right = s.charAt(j);

            if(left != right){ 
                // Fixed: Use j - 1 to skip the right character correctly
                return validhelper(i + 1, j, s) || validhelper(i, j - 1, s);
            } else {
                // Fixed: Increment i and decrement j to advance pointers
                i++;
                j--;
            }
        }
        
        return true;
    } 
}