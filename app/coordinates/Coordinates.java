package app.coordinates;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int p_longitude, int p_latitude, int p_height) {
        longitude = p_longitude;
        latitude = p_latitude;
        height = p_height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static Coordinates createCoordinates(int longitude, int latitude, int height) {
        return new Coordinates(longitude, latitude, height);
    }
    
    @Override
    public String toString() {
        return "(φ:" + latitude + ", λ:" + longitude + ", h:" + height + ")";
    }
}