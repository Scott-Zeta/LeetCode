import java.util.Arrays;

public class App {
    public static boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        for(int i = 0; i < arr.length -2; i ++){
            if((arr[i+2] - arr [i+1]) != (arr[i+1] - arr[i])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println();
    }
}
