class Solution {
    public String reverseWords(String s) {
        // trim leading/trailing spaces
        int l = 0, r = s.length() - 1;

        while (l < s.length()) {
            if (s.charAt(l) == ' ') {
                 l++; // FIX: Changed from l = l++; to avoid infinite loop
            } else {
                break;
            }
        }
        while (r >= 0) {
            if (s.charAt(r) == ' ') { // FIX: Changed " " to ' '
                 r--;
            } else {
                break;
            }
        }

        // Clean up inner multiple spaces into a single space
        StringBuilder sb = new StringBuilder();
        while (l <= r) {
            if (s.charAt(l) != ' ') {
                sb.append(s.charAt(l));
                l++;
            } else if (s.charAt(l) == ' ') { // FIX: Changed " " to ' '
                if (sb.length() > 0 && sb.charAt(sb.length() - 1) != ' ') { // Avoid OutOfBounds check
                    sb.append(' ');
                    l++;
                } else {
                    l++;
                }
            }
        }

        // Reverse the entire StringBuilder
        int i = 0, j = sb.length() - 1;
        while (i < j) {
            char temp = sb.charAt(i); // FIX: Changed from String to char
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, temp);
            i++;
            j--;
        }

        // Reverse word by word
        int start = 0, end = 0;
        while (start < sb.length()) {
            while (end < sb.length() && sb.charAt(end) != ' ') {
                end++;
            }
            int p1 = start, p2 = end - 1;

            while (p1 < p2) {
                char temp = sb.charAt(p1); // FIX: Changed from String to char
                sb.setCharAt(p1, sb.charAt(p2));
                sb.setCharAt(p2, temp);
                p1++;
                p2--;
            }
            start = end + 1;
            end = start;
        }

        return sb.toString();
    }
}
