package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();

        // Try every way to place 3 dots
        for (int i = 1; i <= 3 && i < n; i++) {
            for (int j = i + 1; j <= i + 3 && j < n; j++) {
                for (int k = j + 1; k <= j + 3 && k < n; k++) {
                    String seg1 = s.substring(0, i);
                    String seg2 = s.substring(i, j);
                    String seg3 = s.substring(j, k);
                    String seg4 = s.substring(k);

                    if (isValid(seg1) && isValid(seg2) && isValid(seg3) && isValid(seg4)) {
                        result.add(seg1 + "." + seg2 + "." + seg3 + "." + seg4);
                    }
                }
            }
        }
        return result;
    }

    private boolean isValid(String segment) {
        // Segment length must be between 1 and 3
        if (segment.length() == 0 || segment.length() > 3) return false;
        // No leading zeros (except "0" itself)
        if (segment.length() > 1 && segment.charAt(0) == '0') return false;
        // Value must be between 0 and 255
        int value = Integer.parseInt(segment);
        return value >= 0 && value <= 255;
    }
}


class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        Stack<String> st=new Stack<>();
        st.

        return result;
    }

    private void backtrack(String s, int start, List<String> segments, List<String> result) {
        // If we have 4 segments and used all characters, we found a valid IP
        if (segments.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", segments));
            }
            return;
        }

        // Try segments of length 1, 2, and 3
        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) break;

            String segment = s.substring(start, start + len);

            // Skip segments with leading zeros (except "0" itself)
            if (segment.length() > 1 && segment.charAt(0) == '0') continue;

            // Skip segments with value greater than 255
            if (Integer.parseInt(segment) > 255) continue;

            // Choose this segment and recurse
            segments.add(segment);
            backtrack(s, start + len, segments, result);
            segments.remove(segments.size() - 1);
        }
    }
}
