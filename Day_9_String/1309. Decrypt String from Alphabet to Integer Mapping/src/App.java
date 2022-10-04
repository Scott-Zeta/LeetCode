public class App {
    public static String freqAlphabets(String s) {
        // This is fucking dizzy!!!!!!
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i > -1; i--) {
            if (s.charAt(i) == '#') {
                int c = (((int) s.charAt(i - 1) - 48) + ((int) s.charAt(i - 2) - 48) * 10) + 96;
                sb.append((char) c);
                i -= 2;
            } else {
                sb.append((char) ((int) s.charAt(i) + 48));
                // System.out.println(((int)s.charAt(i)));
            }
        }

        return sb.reverse().toString();
    }

    public String BetterfreqAlphabets(String s) {
        //looks better and understandable
        StringBuffer sb = new StringBuffer();
        int n = s.length();
        int pos = n - 1;// last
        while (pos >= 0) {
            if (s.charAt(pos) == '#') {
                int a = (int) (s.charAt(pos - 2) - '0');
                int b = (int) (s.charAt(pos - 1) - '0');
                int numb = a * 10 + b;
                char generate = (char) ('a' + numb - 1);
                sb.append(generate);
                pos = pos - 3;
            } else {
                int numb = (int) (s.charAt(pos) - '0');
                char generate = (char) ('a' + numb - 1);
                sb.append(generate);
                pos = pos - 1;

            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(freqAlphabets("10#11#12"));
    }
}
