class Solution {
    /*
    *  一个比较直观的做法， 时间复杂度是O(nlogn)  空间复杂度是O(n) where n is number of intervals
    *  按照起始时间排序， 然后通过比较前一个start time 和后一个的 end time 如果发生overlap就 merge
    *  如果没有overlap,就正常放到array里面。
    */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][0];
        // sorting base on starting time 
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> result = new ArrayList<>();
        
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int size = result.size();
            int[] prev = result.get(size - 1);
            if (prev[1] >= cur[0]) {
                result.set(size - 1, new int[] {Math.min(cur[0], prev[0]), Math.max(cur[1], prev[1])});
            } else {
                result.add(cur);
            }
        }
        int n = result.size();
        int[][] ans = new int[n][2];
        for (int i = 0; i < n; i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}