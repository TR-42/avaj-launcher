package fr.ft.kfujita.avaj.simulator;

public abstract class Flyable {
  protected WeatherTower weatherTower;

  public Flyable() {
    weatherTower = null;
  }

  public abstract void updateConditions() throws LandedException;

  public void registerTower(WeatherTower p_tower) {
    weatherTower = p_tower;
  }
}
