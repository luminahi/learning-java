package generics.lib.vehicle;

public class Bike extends Vehicle {
    
    private String brand;

    public Bike(String brand) {
        super(2);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

}
