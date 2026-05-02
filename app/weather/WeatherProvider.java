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

    // W=f(φ,λ,h)
    public String getCurrentWeather(Coordinates p_coordinates) {
        return weather[(int) (Math.random() * weather.length)];
    }
}
