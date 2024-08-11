class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1)
            return 1;
        int current = 1, previous = 1;
        for (int i = 0; i < n - 1; i++) {
            int temp = current;
            current = previous + current;
            previous = temp;
        }
        return current;
    }
}