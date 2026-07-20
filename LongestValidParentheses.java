// Write a program: Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses substring.
// Example 1:Input: s = "(()"Output: 2Explanation: The longest valid parentheses substring is "()".
// Example 2:Input: s = ")()())"Output: 4Explanation: The longest valid parentheses substring is "()()".
// Example 3:Input: s = ""Output: 0
// Constraints:
// 0 <= s.length <= 3 * 104
// s[i] is '(', or ')'.

import java.util.*;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    int length = i - stack.peek();
                    if (length > maxLength) {
                        maxLength = length;
                    }
                }
            }
        }

        return maxLength;
    }
}