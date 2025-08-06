class Main {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int n = prices.length;
        int i = 0;      // buy pointer
        int j = 1;      // sell pointer
        int buy = prices[0];
        int sell = prices[0];
        int maxProfit = 0;
        while (j < n) {
            if (prices[j] > prices[i]) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                    buy = prices[i];
                    sell = prices[j];
                }
            } else {
                i = j;  
            }
            j++;
        }
        if (maxProfit > 0) {
            System.out.println("Buy at: ₹" + buy);
            System.out.println("Sell at: ₹" + sell);
            System.out.println("Max Profit: ₹" + maxProfit);
        } else {
            System.out.println("No profit can be made.");
        }
    }
}
