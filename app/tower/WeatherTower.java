package app.tower;

import app.coordinates.Coordinates;
import app.weather.WeatherProvider;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates p_coordinates) {
        return WeatherProvider.getInstance().getCurrentWeather(p_coordinates);
    }

    public void changeWeather() {
        this.conditionsChanged();
    }
}