class Solution {
    public int maxProfit(int[] prices) {
        int lowestPrice = Integer.MAX_VALUE;
        int maximumTransaction = 0;

        for (int price : prices) {
            if (price < lowestPrice)
                lowestPrice = price;

            int transaction = price - lowestPrice;
            if (maximumTransaction < transaction)
                maximumTransaction = transaction;
        }
        return maximumTransaction;
    }
}