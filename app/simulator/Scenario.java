package app.simulator;

import app.tower.WeatherTower;
import app.aircraft.AircraftFactory;

public class Scenario {
    public static void main(String[] args) {
        System.out.println("Hello, Java Project World!");

        WeatherTower weatherTower = new WeatherTower();
        String weather = weatherTower.getWeather("SampleCoordinates");
        System.out.println("Current weather: " + weather);

        AircraftFactory factory = AircraftFactory.getInstance();
        String aircraft1 = factory.newAircraft("Helicopter", "H1", "10,20,30");
        String aircraft2 = factory.newAircraft("JetPlane", "J1", "15,25,35");
        String aircraft3 = factory.newAircraft("Baloon", "B1", "5,10,15");

        System.out.println(aircraft1);
        System.out.println(aircraft2);
        System.out.println(aircraft3);
    }
}
