public class App {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] Index = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            int c = magazine.charAt(i) - 'a';
            Index[c]++;
        }
        
        for (int i = 0; i < ransomNote.length(); i++) {
            int c = ransomNote.charAt(i) - 'a';
            Index[c]--;
        }

        for (int i = 0; i < 26; i++) {
            if (Index[i] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
