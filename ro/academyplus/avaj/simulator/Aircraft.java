package ro.academyplus.avaj.simulator;

public class Aircraft extends Flyable {
  protected long id;
  protected String name;
  protected Coordinates coordinates;

  protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
    id = p_id;
    name = p_name;
    coordinates = p_coordinates;
  }

  @Override
  public void updateConditions() throws LandedException {
    final WeatherType currentWeather = weatherTower.getWeatherEnum(coordinates);
    Logger.getInstance().log(String.format("%s: %s", this, getMessage(currentWeather)));
    coordinates = getUpdatedCoordinates(currentWeather);
    if (isLanded()) {
      Logger.getInstance().log(this + " landing.");
      throw new LandedException();
    }
  }

  public boolean isLanded() {
    return coordinates.getHeight() <= 0;
  }

  protected WeatherType getCurrentWeatherEnum() {
    return WeatherProvider.getInstance().getCurrentWeatherEnum(coordinates);
  }

  protected String getMessage(WeatherType weatherType) {
    return "Who am I?";
  }

  protected Coordinates getUpdatedCoordinates(WeatherType weatherType) {
    return coordinates;
  }
}
