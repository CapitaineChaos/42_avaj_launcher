package app.simulator;

import app.tower.WeatherTower;
import app.tower.Tower;
import app.aircraft.AircraftFactory;
import app.coordinates.Coordinates;
import app.aircraft.Aircraft;

public class Scenario {
    public static void main(String[] args) {
        System.out.println("Hello, Java Project World!");

        WeatherTower weatherTower = new WeatherTower();
        String weather = weatherTower.getWeather(Coordinates.createCoordinates(10, 20, 30));
        System.out.println("Current weather: " + weather);

        AircraftFactory factory = AircraftFactory.getInstance();

        try {
            factory.newAircraft("Helicopter", "H1", Coordinates.createCoordinates(10, 20, 30));
            factory.newAircraft("Helicopter", "H2", Coordinates.createCoordinates(10, 20, 30));
            factory.newAircraft("Helicopter", "H2", Coordinates.createCoordinates(10, 20, 30));
            factory.newAircraft("JetPlane", "J1", Coordinates.createCoordinates(15, 25, 35));
            factory.newAircraft("Baloon", "B1", Coordinates.createCoordinates(5, 10, 15));
        } catch (Exception e) {
            e.printStackTrace();   
        }
    }
}
