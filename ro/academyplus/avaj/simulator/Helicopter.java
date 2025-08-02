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
      case RAIN -> "Blades spinning, rain winning. Who ordered the free shower?";
      case FOG -> "Fog ahead! Time to trust the instruments and hope for the best.";
      case SUN -> "Sun's out, rotors out! Let's make some wind.";
      case SNOW -> "Snow swirling! Hope the rotors don't turn into snow cones.";
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
