package generics.lib.vehicle;

public class Car extends Vehicle {
    
    private String brand;

    public Car(String brand) {
        super(4);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
    
    @Override
    public String toString() {
        return brand;
    }
}
