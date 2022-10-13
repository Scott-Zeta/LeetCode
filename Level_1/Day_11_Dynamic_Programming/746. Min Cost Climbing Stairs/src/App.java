public class App {

    public int minCostClimbingStairs(int[] cost) {
        int steps = cost.length + 1;
        int[] stepCost = new int[steps];

        for (int i = 2; i < stepCost.length; i++) {
            int oneStep = stepCost[i - 1] + cost[i - 1];
            int twoSTep = stepCost[i - 2] + cost[i - 2];
            stepCost[i] = Math.min(oneStep, twoSTep);
        }
        return stepCost[stepCost.length - 1];
    }

    public int minCostClimbingStairsNoArray(int[] cost) {
        int downOne = 0;
        int downTwo = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            int temp = downOne;
            downOne = Math.min(downOne + cost[i - 1], downTwo + cost[i - 2]);
            downTwo = temp;
        }
        
        return downOne;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
