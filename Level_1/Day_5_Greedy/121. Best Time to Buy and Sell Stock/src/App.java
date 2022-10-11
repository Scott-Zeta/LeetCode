public class App {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];

        for (int i = 0; i < prices.length; i++) {
            int profit = prices[i] - buy;
            if (profit > maxProfit) {
                maxProfit = profit;
            }

            if (buy > prices[i]){
                buy = prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
