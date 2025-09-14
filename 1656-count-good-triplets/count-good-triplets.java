class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] - arr[j] <= a && arr[j] - arr[i] <= a)
                        if (arr[j] - arr[k] <= b && arr[k] - arr[j] <= b)
                            if (arr[i] - arr[k] <= c && arr[k] - arr[i] <= c)
                                count++;
                }
            }
        }
        return count;
    }
}