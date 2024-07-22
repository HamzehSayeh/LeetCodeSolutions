class Solution {
    public int jump(int[] nums) {
        int length = nums.length;
        int firstIndex=0,secondIndex=0;
        int minimumJumps = 0;

        if (length == 1)
            return 0;
            while(secondIndex<length-1){
              int maxLocation=0;
        for (int i = firstIndex; i <= secondIndex; i++) {

            if (i + nums[i] > maxLocation) {
                maxLocation = i + nums[i];
            }
        }
            firstIndex=secondIndex+1;
            secondIndex=maxLocation;
            minimumJumps++;
        }

        return minimumJumps;
    }
}
