class ParkingSystem {
    int big;
    int medium;
    int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if(carType == 1){
            if(big - 1 >= 0){
                big--;
                return true;
            }
        }
        if(carType == 2){
            if(medium - 1 >= 0){
                medium--;
                return true;
            }
        }
        if(carType == 3){
            if(small - 1 >= 0){
                small--;
                return true;
            }
        }
        return false;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
