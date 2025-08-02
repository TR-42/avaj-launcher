package fr.ft.kfujita.avaj.simulator;

public enum AircraftType {
  BALLOON("Baloon"),
  HELICOPTER("Helicopter"),
  JETPLANE("JetPlane"),

  ;

  private final String type;

  private AircraftType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public static AircraftType fromString(String type) {
    for (AircraftType aircraftType : AircraftType.values()) {
      if (aircraftType.type.equalsIgnoreCase(type)) {
        return aircraftType;
      }
    }
    throw new IllegalArgumentException("No constant with text " + type + " found");
  }

  public boolean equals(String type) {
    return this.type.equalsIgnoreCase(type);
  }

  @Override
  public String toString() {
    return type;
  }
}
