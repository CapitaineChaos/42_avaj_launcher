package app.simulator;

// import app.parser.ScenarioParser;
import app.parser.ScenarioFile;
import app.tower.WeatherTower;
import app.tower.Tower;
import app.aircraft.AircraftFactory;
import app.coordinates.Coordinates;
import app.aircraft.Aircraft;
import java.util.List;

import app.parser.dto.*;

public class Scenario {
    public static void main(String[] args) {

        try {
            ScenarioFile scenarioFile = new ScenarioFile("docs/scenario.txt");

            int simulations = scenarioFile.simulations();
            List<AircraftData> aircrafts = scenarioFile.data().aircrafts();

            WeatherTower weatherTower = new WeatherTower();
            String weather = weatherTower.getWeather(Coordinates.createCoordinates(10, 20, 30));
            System.out.println("Current weather: " + weather);

            AircraftFactory factory = AircraftFactory.getInstance();

            for (AircraftData aircraft : aircrafts) {
                Aircraft newAircraft = factory.newAircraft(aircraft.type(), aircraft.name(), Coordinates.createCoordinates(aircraft.longitude(), aircraft.latitude(), aircraft.height()));
                newAircraft.registerTower(weatherTower);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());   
        }
    }
}
