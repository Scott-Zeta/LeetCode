public class App {
    public static int mySqrt(int x) {
        if(x == 1){
            return 1;
        }
        int left = 1;
        int right = x;
        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) {
                return mid;
            }
            if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) throws Exception {
        for(int i = 1; i < 17; i++){
            System.out.println(i + ": " + mySqrt(i));
        }
        // System.out.println(mySqrt(1));
        System.out.println("Hello, World!");
    }
}
