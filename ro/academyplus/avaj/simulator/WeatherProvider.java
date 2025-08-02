package ro.academyplus.avaj.simulator;

public class WeatherProvider {
  private final String[] weather;
  private final WeatherType[] weatherEnum;

  private static final WeatherProvider weatherProvider = new WeatherProvider();

  private WeatherProvider() {
    weatherEnum = new WeatherType[] {
        WeatherType.RAIN,
        WeatherType.FOG,
        WeatherType.SUN,
        WeatherType.SNOW
    };
    weather = new String[weatherEnum.length];
    for (int i = 0; i < weatherEnum.length; i++) {
      weather[i] = weatherEnum[i].getType();
    }
  }

  public static WeatherProvider getInstance() {
    return weatherProvider;
  }

  public String getCurrentWeather(Coordinates p_coordinates) {
    return getCurrentWeatherEnum(p_coordinates).getType();
  }

  public WeatherType getCurrentWeatherEnum(Coordinates p_coordinates) {
    final int v = (p_coordinates.getLongitude() ^ p_coordinates.getLatitude() ^ p_coordinates.getHeight());
    return weatherEnum[v % weatherEnum.length];
  }
}
