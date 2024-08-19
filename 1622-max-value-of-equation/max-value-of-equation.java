class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int maxVal = Integer.MIN_VALUE;
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < points.length; i++) {
            while (!deque.isEmpty() && points[i][0] - points[deque.peekFirst()][0] > k) {
                deque.pollFirst();
            }
            
            if (!deque.isEmpty()) {
                maxVal = Math.max(maxVal, points[i][1] + points[deque.peekFirst()][1] + points[i][0] - points[deque.peekFirst()][0]);
            }
            
            while (!deque.isEmpty() && points[deque.peekLast()][1] - points[deque.peekLast()][0] < points[i][1] - points[i][0]) {
                deque.pollLast();
            }
            
            deque.offerLast(i);
        }
        
        return maxVal;
    }
}