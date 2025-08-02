package fr.ft.kfujita.avaj.simulator;

public enum WeatherType {
  RAIN("RAIN"),
  FOG("FOG"),
  SUN("SUN"),
  SNOW("SNOW"),

  ;

  private final String type;

  private WeatherType(String p_type) {
    this.type = p_type;
  }

  public String getType() {
    return type;
  }

  public static WeatherType fromString(String p_type) {
    for (WeatherType weatherType : WeatherType.values()) {
      if (weatherType.type.equalsIgnoreCase(p_type)) {
        return weatherType;
      }
    }
    throw new IllegalArgumentException("No constant with text " + p_type + " found");
  }

  public boolean equals(String p_type) {
    return this.type.equalsIgnoreCase(p_type);
  }

  @Override
  public String toString() {
    return type;
  }
};