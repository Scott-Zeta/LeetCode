public class App {

    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[26];
        int left = 0;
        int right = 0;
        int max = 0;
        for(char c:s.toCharArray()){
            int index = c - 'a';
            map[index]++;
            if(map[index] == 1){
                int distance = right-left + 1;
                max = Math.max(distance, max);
            }
        }

    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
