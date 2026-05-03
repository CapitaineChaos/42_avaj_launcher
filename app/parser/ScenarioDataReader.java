package app.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import app.parser.dto.ScenarioData;
import app.parser.dto.AircraftData;
import java.util.List;
import java.util.ArrayList;

public class ScenarioDataReader {
    public ScenarioData read(Path path) {
        List<String> lines;

        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new ScenarioDataReaderException("Failed to read scenario file: " + e.getMessage());
        }

        int numberOfSimulations = readNumberOfSimulations(lines);
        List<AircraftData> aircraftData = readAircraftData(lines);

        return new ScenarioData(numberOfSimulations, aircraftData);
    }

    private int readNumberOfSimulations(List<String> lines) {
        if (lines.isEmpty())
            throw new ScenarioDataReaderException("Scenario file is empty.");

        String firstLine = lines.get(0).trim();
        try {
            int simulations = Integer.parseInt(firstLine);
            if (simulations < 0)
                throw new ScenarioDataReaderException("Number of simulations cannot be negative: " + simulations);
            return simulations;
        } catch (NumberFormatException e) {
            throw new ScenarioDataReaderException("Invalid number of simulations: " + firstLine);
        }
    }

    private List<AircraftData> readAircraftData(List<String> lines) {
        if (lines.size() < 2)
            throw new ScenarioDataReaderException("No aircraft data found in scenario file.");

        List<AircraftData> aircrafts = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.isEmpty())
                throw new ScenarioDataReaderException("Empty line found in aircraft data at line " + (i + 1));
            String[] parts = line.split("\\s+");
            if (parts.length != 5)
                throw new ScenarioDataReaderException("Invalid aircraft data format at line " + (i + 1) + ": " + line);
            String type = parts[0];
            String name = parts[1];
            if (type.isEmpty() || name.isEmpty())
                throw new ScenarioDataReaderException("Aircraft type and name cannot be empty at line " + (i + 1) + ": " + line);
            if (aircrafts.stream().anyMatch(a -> a.name().equals(name)))
                throw new ScenarioDataReaderException("Duplicate aircraft name found at line " + (i + 1) + ": " + name);
            int longitude, latitude, height;
            try {
                longitude = Integer.parseInt(parts[2]);
                latitude = Integer.parseInt(parts[3]);
                height = Integer.parseInt(parts[4]);
                if (longitude < 0 || latitude < 0 || height < 0)
                    throw new ScenarioDataReaderException("Coordinates cannot be negative at line " + (i + 1) + ": " + line);
                if (height > 100)
                    throw new ScenarioDataReaderException("Height cannot exceed 100 at line " + (i + 1) + ": " + line);
            } catch (NumberFormatException e) {
                throw new ScenarioDataReaderException("Invalid coordinates format at line " + (i + 1) + ": " + line);
            }
            aircrafts.add(new AircraftData(type, name, longitude, latitude, height));
        }
        return aircrafts;
    }
}
