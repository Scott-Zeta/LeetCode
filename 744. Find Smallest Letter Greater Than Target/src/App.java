public class App {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left > letters.length - 1) {
            return letters[0];
        }
        return letters[left];
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
