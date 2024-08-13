class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            graph.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            graph.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }
        
        int n = adjacentPairs.length + 1;
        int[] nums = new int[n];
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 1) {
                nums[0] = entry.getKey();
                break;
            }
        }
        
        nums[1] = graph.get(nums[0]).get(0);
        for (int i = 2; i < n; i++) {
            List<Integer> neighbors = graph.get(nums[i - 1]);
            nums[i] = neighbors.get(0) == nums[i - 2] ? neighbors.get(1) : neighbors.get(0);
        }
        
        return nums;
    }
}