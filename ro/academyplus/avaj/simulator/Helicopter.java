package ro.academyplus.avaj.simulator;

public class Helicopter extends Aircraft {

  public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
    super(p_id, p_name, p_coordinates);
  }

  @Override
  public void updateConditions() throws LandedException {
    super.updateConditions();
  }

  @Override
  protected String getMessage(final WeatherType weatherType) {
    return switch (weatherType) {
      case RAIN -> "Rain is drumming on my blades—free percussion concert!";
      case FOG -> "Fog ahead! My pilot's guessing, I'm just spinning.";
      case SUN -> "Clear skies! Time to show off some aerial moves.";
      case SNOW -> "Snow swirling around—looks like I'm flying inside a snow globe!";
    };
  }

  @Override
  protected Coordinates getUpdatedCoordinates(WeatherType weatherType) {
    return switch (weatherType) {
      case SUN -> coordinates.withAddLongitude(10).withAddHeight(2);
      case RAIN -> coordinates.withAddLongitude(5);
      case FOG -> coordinates.withAddLongitude(1);
      case SNOW -> coordinates.withAddHeight(-12);
    };
  }

  @Override
  public String toString() {
    return String.format("%s#%s(%d)", AircraftType.HELICOPTER, name, id);
  }
}
