package ro.academyplus.avaj.simulator;

public class WeatherTower extends Tower {
  @Override
  public void register(Flyable p_flyable) {
    super.register(p_flyable);
    p_flyable.registerTower(this);
  }

  public String getWeather(Coordinates p_coordinates) {
    return WeatherProvider.getInstance().getCurrentWeather(p_coordinates);
  }

  public WeatherType getWeatherEnum(Coordinates p_coordinates) {
    return WeatherProvider.getInstance().getCurrentWeatherEnum(p_coordinates);
  }

  public void changeWeather() {
    conditionChanged();
  }
}
