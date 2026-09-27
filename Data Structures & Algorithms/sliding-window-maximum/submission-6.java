class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> q = new ArrayDeque<>(); // indices, values decreasing
        int l = 0;

        for (int r = 0; r < n; r++) {
            // 1. Drop smaller values from the back; they can never be max now
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }
            q.addLast(r);

            // 2. Drop the front if it's left the window
            if (q.getFirst() < l) {
                q.removeFirst();
            }

            // 3. Window is full: record max, slide left edge
            if (r - l + 1 == k) {
                result[l] = nums[q.getFirst()];
                l++;
            }
        }
        return result;
    }
}