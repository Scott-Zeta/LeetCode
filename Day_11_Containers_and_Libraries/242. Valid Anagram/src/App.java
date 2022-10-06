public class App {

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] sIndex = new int[26];
        for(int i = 0; i<s.length(); i++){
            sIndex[s.charAt(i)-'a']++;
            sIndex[t.charAt(i)-'a']--;
        }
        for(int i: sIndex){
            if(i!=0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
}
