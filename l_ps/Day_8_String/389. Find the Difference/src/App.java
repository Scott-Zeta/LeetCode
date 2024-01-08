public class App {
    public char findTheDifference(String s, String t) {
        int[] sIndex = new int[128];
        int[] tIndex = new int[128];
        for(int i = 0; i< s.length(); i++){
            sIndex[s.charAt(i)]++;
            tIndex[t.charAt(i)]++;
        }
        tIndex[t.charAt(t.length()-1)]++;
        for(int i = 0; i < 128; i++){
            if(sIndex[i] != tIndex[i]){
                return (char)i;
            }
        }
        return (char)0;
    }
    
    public char lessLinefindTheDifference(String s, String t) {
        int sSum = 0;
        int tSum = t.charAt(t.length() - 1);
        for(int i = 0; i < s.length() ; i++){
            sSum += s.charAt(i);
            tSum += t.charAt(i);
        }
        
        return (char)(tSum - sSum);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
