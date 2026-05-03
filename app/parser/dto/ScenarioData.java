package app.parser.dto;

import java.util.List;

public record ScenarioData(
    int simulations,
    List<AircraftData> aircrafts
) {}
