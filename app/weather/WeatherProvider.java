package app.weather;

import app.coordinates.Coordinates;

public class WeatherProvider {
    private static WeatherProvider instance;
    
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider() {}

    public static WeatherProvider getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    private long cantor(long a, long b) {
        return ((a + b) * (a + b + 1)) / 2 + b;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        int lat = p_coordinates.getLatitude();
        int lon = p_coordinates.getLongitude();
        int hgt = p_coordinates.getHeight();
        return weather[(int)(cantor(cantor(lat, lon), hgt)) % 4];
    }
}
