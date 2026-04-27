package app.aircraft;

public class Aircraft extends Flyable implements Runnable {
    private String name;
    private String type;
    private String coordinates;

    public Aircraft(String name, String type, String coordinates) {
        this.name = name;
        this.type = type;
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCoordinates() {
        return coordinates;
    }

    @Override
    public void updateConditions() {
        System.out.println(type + " " + name + " is updating conditions based on weather.");
    }

    @Override
    public void run() {
        System.out.println(type + " " + name + " is flying at coordinates: " + coordinates);
    }
}
