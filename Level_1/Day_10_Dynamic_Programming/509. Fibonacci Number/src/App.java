public class App {

    public static int number(int n) {
        int[] result = list(n);
        return result[n];
    }

    public static int[] list(int n) {
        int[] list = new int[n + 1];
        list[0] = 0;
        if (list.length > 1) {
            list[1] = 1;
        }
        if (list.length > 2) {
            for (int i = 2; i < list.length; i++) {
                list[i] = list[i - 1] + list[i - 2];
            }
        }
        return list;
    }

    public static void main(String[] args) throws Exception {
        int query = number(9);
        System.out.println(query);
        System.out.println("Hello, World!");
    }
}
