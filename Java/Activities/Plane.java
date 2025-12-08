package activities;

import java.util.*;

class Plane {
    private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;

    public Plane(int maxPassengers) {
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>();
    }

	public void onboard(String passengerName) {
        if(passengers.size() <= maxPassengers) {
            this.passengers.add(passengerName);
        } else {
            System.out.println("Plane is fully occupied");
        }
    }

    public Date takeOff() {
        this.lastTimeTookOf = new Date();
        return lastTimeTookOf;
    }

    public void land() {
        this.lastTimeLanded = new Date();
        this.passengers.clear();
    }

    public Date getLastTimeLanded() {
        return lastTimeLanded;
    }

    public List<String> getPassengers() {
        return passengers;
    }
}