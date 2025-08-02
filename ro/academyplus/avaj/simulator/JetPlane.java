package ro.academyplus.avaj.simulator;

public class JetPlane extends Aircraft {

  public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
    super(p_id, p_name, p_coordinates);
  }

  @Override
  public void updateConditions() throws LandedException {
    super.updateConditions();
  }

  @Override
  protected String getMessage(final WeatherType weatherType) {
    return switch (weatherType) {
      case RAIN -> "Cutting through the rain like a hot knife through butter!";
      case FOG -> "Foggy runway? Good thing I fly faster than confusion.";
      case SUN -> "Blue skies and jet engines—let's break the sound barrier!";
      case SNOW -> "Snow on the wings? Let's hope for a speedy takeoff!";
    };
  }

  @Override
  protected Coordinates getUpdatedCoordinates(WeatherType weatherType) {
    return switch (weatherType) {
      case SUN -> coordinates.withAddLatitude(10).withAddHeight(2);
      case RAIN -> coordinates.withAddLatitude(5);
      case FOG -> coordinates.withAddLatitude(1);
      case SNOW -> coordinates.withAddHeight(7);
    };
  }

  @Override
  public String toString() {
    return String.format("%s#%s(%d)", AircraftType.JETPLANE, name, id);
  }
}
