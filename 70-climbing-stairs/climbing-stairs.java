class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1)
            return 1;
        int current = 1, previous = 1;
        for (int i = 0; i < n - 1; i++) {
            current = previous + current;
            previous = current-previous;
        }
        return current;
    }
}