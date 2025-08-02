package ro.academyplus.avaj.simulator;

public class Baloon extends Aircraft {

  public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
    super(p_id, p_name, p_coordinates);
  }

  @Override
  public void updateConditions() throws LandedException {
    super.updateConditions();
  }

  @Override
  protected String getMessage(final WeatherType weatherType) {
    return switch (weatherType) {
      case RAIN -> "Raindrops keep falling on my head... Hope this thing doesn't pop!";
      case FOG -> "Can't see a thing! Is this cloud nine or just fog?";
      case SUN -> "Up, up, and away! Perfect day for sightseeing from above.";
      case SNOW -> "Snowflakes on my basket! Is this a flying igloo now?";
    };
  }

  @Override
  protected Coordinates getUpdatedCoordinates(WeatherType weatherType) {
    return switch (weatherType) {
      case SUN -> coordinates.withAddLongitude(2).withAddHeight(4);
      case RAIN -> coordinates.withAddHeight(-5);
      case FOG -> coordinates.withAddHeight(-3);
      case SNOW -> coordinates.withAddHeight(-15);
    };
  }

  @Override
  public String toString() {
    return String.format("%s#%s(%d)", AircraftType.BALLOON, name, id);
  }
}
