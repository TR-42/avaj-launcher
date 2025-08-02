package fr.ft.kfujita.avaj.simulator;

import java.util.ArrayList;
import java.util.List;

public class Tower {

  private List<Flyable> observers;

  public Tower() {
    observers = new ArrayList<>();
  }

  public void register(Flyable p_flyable) {
    observers.add(p_flyable);
    Logger.getInstance().log("Tower says: " + p_flyable + " registered to weather tower.");
  }

  public void unregister(Flyable p_flyable) {
    observers.remove(p_flyable);
    Logger.getInstance().log("Tower says: " + p_flyable + " unregistered from weather tower.");
  }

  protected void conditionChanged() {
    List<Flyable> observersCopy = new ArrayList<>(observers);
    for (Flyable observer : observersCopy) {
      try {
        observer.updateConditions();
      } catch (LandedException e) {
        unregister(observer);
      }
    }
  }
}