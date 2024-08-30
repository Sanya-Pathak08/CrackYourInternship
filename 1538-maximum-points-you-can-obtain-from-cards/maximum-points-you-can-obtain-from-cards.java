class Solution {
    public int maxScore(int[] cardPoints, int k) {
         int n = cardPoints.length;
    int totalPoints = 0;
    for (int point : cardPoints) {
        totalPoints += point;
    }
    
    int windowSize = n - k;
    int minWindowPoints = Integer.MAX_VALUE;
    int windowPoints = 0;
    for (int i = 0; i < n; i++) {
        windowPoints += cardPoints[i];
        if (i >= windowSize) {
            windowPoints -= cardPoints[i - windowSize];
        }
        if (i >= windowSize - 1) {
            minWindowPoints = Math.min(minWindowPoints, windowPoints);
        }
    }
    
    return totalPoints - minWindowPoints;
    }
}