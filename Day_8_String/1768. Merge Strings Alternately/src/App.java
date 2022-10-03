public class App {
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder builder = new StringBuilder();
        int count = -1;
        if (word1.length() > word2.length()) {
            count = word1.length();
        } else {
            count = word2.length();
        }

        for (int i = 0; i < count; i++) {
            if(i < word1.length()){
                builder.append(word1.charAt(i));
            }
            if(i < word2.length()){
                builder.append(word2.charAt(i));
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(mergeAlternately("acegh", "bdf"));
        System.out.println("Hello, World!");
    }
}
