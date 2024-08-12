class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] sub = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            sub[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    sub[i] = Math.max(sub[i], sub[j]+1);
                }
            }
        }
        int result = sub[0];
        for (int i = 1; i < nums.length; i++) {
            if (result < sub[i]) {
                result = sub[i];
            }
        }
        return result;
    }
}