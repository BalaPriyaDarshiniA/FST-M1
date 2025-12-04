package activities;

public class Activity1 {

    public static void main(String[] args) {
        Car renault = new Car();
        renault.make = 2014;
        renault.color = "Black";
        renault.transmission = "Manual";
    
        //Using Car class method
        renault.displayCharacterstics();
        renault.accelerate();
        renault.brake();
    }

}