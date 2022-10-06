import java.util.HashMap;

public class App {
    public boolean containsDuplicate(int[] nums) {
        HashMap <Integer,Integer> map = new HashMap<>();
        for(int i=0; i< nums.length; i++){
            if(map.get(nums[i]) == null){
                map.put(nums[i],1);
            }else{
                System.out.println(nums[i]);
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
