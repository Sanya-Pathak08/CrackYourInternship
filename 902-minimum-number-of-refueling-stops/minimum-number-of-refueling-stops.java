public class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int i = 0, res = 0, cur = startFuel;
        for (; cur < target; res++) {
            while (i < stations.length && stations[i][0] <= cur) {
                pq.offer(stations[i++][1]);
            }
            if (pq.isEmpty()) return -1;
            cur += pq.poll();
        }
        return res;
    }
}