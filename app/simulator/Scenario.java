package app.simulator;

import app.parser.ScenarioFile;
import app.parser.dto.*;
import app.tower.WeatherTower;
import app.tower.Tower;
import app.aircraft.AircraftFactory;
import app.coordinates.Coordinates;
import app.aircraft.Aircraft;
import app.log.Logger;

import java.util.List;
import java.nio.file.Path;


public class Scenario {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: java Scenario <scenario_file_path>");
            return;
        }


        try {
            Logger.init(Path.of("simulation.txt"), Path.of("simulation.log"));
            
            ScenarioFile scenarioFile = new ScenarioFile(args[0]);

            int simulations = scenarioFile.simulations();
            List<AircraftData> aircrafts = scenarioFile.data().aircrafts();

            WeatherTower weatherTower = new WeatherTower();

            AircraftFactory factory = AircraftFactory.getInstance();

            for (AircraftData aircraft : aircrafts) {
                Aircraft newAircraft = factory.newAircraft(aircraft.type(), aircraft.name(), Coordinates.createCoordinates(aircraft.longitude(), aircraft.latitude(), aircraft.height()));
                newAircraft.registerTower(weatherTower);
            }

            for (int i = 0; i < simulations; i++) {
                if (weatherTower.getRegisteredFlyables().isEmpty()) {
                    Logger.getInstance().logLine("\n---------------- No more flyables registered. Ending simulation at step [" + (i + 1) + "] ----------------\n");
                    break;
                }
                Logger.getInstance().logLine("\n---------------- Simulation step [" + (i + 1) + "] ----------------\n");
                weatherTower.changeWeather();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());   
        } finally {
            Logger.getInstance().close();
        }
    }
}
