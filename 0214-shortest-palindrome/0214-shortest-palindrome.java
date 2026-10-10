class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) {
            return s;
        }
        
        // Reverse the string
        String rev = new StringBuilder(s).reverse().toString();
        
        // Combine original string, a separator, and the reversed string
        String combined = s + "#" + rev;
        
        // Build the LPS (Longest Prefix Suffix) table for KMP
        int[] lps = new int[combined.length()];
        for (int i = 1; i < combined.length(); i++) {
            int j = lps[i - 1];
            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = lps[j - 1];
            }
            if (combined.charAt(i) == combined.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }
        
        // The length of the longest palindromic prefix of s
        int palindromeLen = lps[combined.length() - 1];
        
        // Take the remaining characters from the reversed string and prepend them to s
        return rev.substring(0, n - palindromeLen) + s;
    }
}