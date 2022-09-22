public class App {
    public double average(int[] salary) {
        int max = salary[0];
        int min = salary[0];
        int sum = 0;
        for (int i = 0; i < salary.length; i++) {
            int s1 = salary[i];
            sum += s1;
            if(s1 > max){
                max = s1;
            }
            if(s1 < min){
                min = s1;
            }
        }
        return (double)(sum-max-min)/(salary.length -2);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
