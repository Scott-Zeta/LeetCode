import java.util.Arrays;

public class App {

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] sIndex = new int[26];
        int[] tIndex = new int[26];
        for(int i = 0; i<s.length(); i++){
            sIndex[s.charAt(i)-'a']++;
            tIndex[t.charAt(i)-'a']++;
        }
        return Arrays.equals(sIndex, tIndex);
    }
    public static void main(String[] args) throws Exception {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
}
