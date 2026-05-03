package app.parser.dto;

public record AircraftData(
    String type,
    String name,
    int longitude,
    int latitude,
    int height
) {}
