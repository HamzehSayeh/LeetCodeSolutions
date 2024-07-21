class Solution {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int maxLocation = 0;

        if (length == 1)
            return true;
        for (int i = 0; i < length; i++) {
            if (i > maxLocation)
                return false;
            if (i + nums[i] > maxLocation)
                maxLocation = i + nums[i];
            if (maxLocation == nums.length - 1)
                return true;
        }
        return true;
    }
}