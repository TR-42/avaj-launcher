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
      case RAIN -> "Slicing through rain clouds—who needs windshield wipers at this speed?";
      case FOG -> "Foggy up here! Good thing my radar isn't afraid of ghosts.";
      case SUN -> "Sun's blazing! Perfect weather for breaking the sound barrier.";
      case SNOW -> "Snowflakes zipping past—hope they don't freeze my engines!";
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
