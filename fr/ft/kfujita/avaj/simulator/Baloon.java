package fr.ft.kfujita.avaj.simulator;

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
      case RAIN -> "Raindrops are making my basket soggy! Hope I don't turn into a water balloon.";
      case FOG -> "Floating blind! Is this a cloud or just really thick fog?";
      case SUN -> "Soaking up the sunshine! I feel lighter already.";
      case SNOW -> "Snowflakes everywhere! Maybe I'll land in a winter wonderland.";
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
