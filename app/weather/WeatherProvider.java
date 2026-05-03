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
        long lat = p_coordinates.getLatitude();
        long lon = p_coordinates.getLongitude();
        long hgt = p_coordinates.getHeight();
        return weather[Math.abs((int)(cantor(cantor(lat, lon), hgt))) % 4];
    }
}
