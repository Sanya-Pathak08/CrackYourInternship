class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> polarAngles = new ArrayList<>();
        int samePointCount = 0;
        
        for (List<Integer> point : points) {
            int dx = point.get(0) - location.get(0);
            int dy = point.get(1) - location.get(1);
            
            if (dx == 0 && dy == 0) {
                samePointCount++;
                continue;
            }
            
            double polarAngle = Math.atan2(dy, dx);
            polarAngles.add(polarAngle);
        }
        
        Collections.sort(polarAngles);
        
        int n = polarAngles.size();
        for (int i = 0; i < n; i++) {
            polarAngles.add(polarAngles.get(i) + 2 * Math.PI);
        }
        
        int maxVisible = 0;
        int left = 0;
        double rightAngle = Math.toRadians(angle);
        
        for (int right = 0; right < 2 * n; right++) {
            while (polarAngles.get(right) - polarAngles.get(left) > rightAngle) {
                left++;
            }
            maxVisible = Math.max(maxVisible, right - left + 1);
        }
        
        return maxVisible + samePointCount;
    }
}