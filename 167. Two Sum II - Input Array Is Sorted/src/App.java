public class App {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (right > left) {
            if (numbers[left] == target - numbers[right]) {
                return new int[] { left + 1, right + 1 };
            }
            if (numbers[left] > target - numbers[right]) {
                right--;
            } else {
                left++;
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
