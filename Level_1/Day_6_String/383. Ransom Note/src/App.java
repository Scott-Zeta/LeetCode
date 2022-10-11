public class App {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] noteIndex = new int[26];
        int[] magazineIndex = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            int c = magazine.charAt(i) - 'a';
            magazineIndex[c]++;
        }
        
        for (int i = 0; i < ransomNote.length(); i++) {
            int c = ransomNote.charAt(i) - 'a';
            noteIndex[c]++;
        }

        for (int i = 0; i < 26; i++) {
            if (noteIndex[i] > magazineIndex[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
