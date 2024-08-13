class Solution {
    public String removeKdigits(String num, int k) {
         Stack<Character> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while (k-- > 0) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        int start = 0;
        while (start < sb.length() && sb.charAt(start) == '0') {
            start++;
        }
        return start == sb.length() ? "0" : sb.substring(start);
    }
}