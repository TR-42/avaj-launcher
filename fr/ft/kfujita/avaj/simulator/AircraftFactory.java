package fr.ft.kfujita.avaj.simulator;

public class AircraftFactory {
  private static AircraftFactory instance = new AircraftFactory();

  private long nextId;

  private AircraftFactory() {
    nextId = 1;
  }

  public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
    return newAircraft(AircraftType.fromString(p_type), p_name, p_coordinates);
  }

  public Flyable newAircraft(AircraftType p_type, String p_name, Coordinates p_coordinates) {
    final Flyable aircraft = switch (p_type) {
      case BALLOON -> new Baloon(nextId++, p_name, p_coordinates);
      case HELICOPTER -> new Helicopter(nextId++, p_name, p_coordinates);
      case JETPLANE -> new JetPlane(nextId++, p_name, p_coordinates);
    };
    return aircraft;
  }

  public static AircraftFactory getInstance() {
    return instance;
  }
}