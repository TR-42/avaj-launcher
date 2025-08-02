package ro.academyplus.avaj.simulator;

public class Coordinates {
  private int longitude;
  private int latitude;
  private int height;

  public static final int MIN_HEIGHT = 0;
  public static final int MAX_HEIGHT = 100;

  // package-private constructor
  Coordinates(int p_longitude, int p_latitude, int p_height) {
    if (p_longitude < 0 || p_latitude < 0) {
      throw new IllegalArgumentException("Invalid position");
    }
    longitude = p_longitude;
    latitude = p_latitude;
    height = p_height;
    if (height < MIN_HEIGHT) {
      height = MIN_HEIGHT;
    } else if (MAX_HEIGHT < height) {
      height = MAX_HEIGHT;
    }
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

  public Coordinates withAddLatitude(int p_latitude) {
    return new Coordinates(longitude, latitude + p_latitude, height);
  }

  public Coordinates withAddLongitude(int p_longitude) {
    return new Coordinates(longitude + p_longitude, latitude, height);
  }

  public Coordinates withAddHeight(int p_height) {
    return new Coordinates(longitude, latitude, height + p_height);
  }
}
