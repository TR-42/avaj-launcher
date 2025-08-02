package fr.ft.kfujita.avaj.simulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

public class Simulator {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Usage: java Simulator <input file>");
      return;
    }
    final WeatherTower weatherTower = new WeatherTower();
    long simulationCount = 0;

    final File inputFile = Paths.get(args[0]).toFile();
    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(new FileInputStream(inputFile), StandardCharsets.UTF_8))) {
      final String firstLine = reader.readLine();
      if (firstLine == null || firstLine.isEmpty()) {
        System.out.println("Input file is empty or invalid.");
        return;
      }
      simulationCount = Long.parseLong(firstLine.trim());
      if (simulationCount <= 0) {
        System.out.println("Simulation count must be a positive integer.");
        return;
      }
      String line;
      while ((line = reader.readLine()) != null) {
        processLine(line, weatherTower);
      }
    } catch (Exception e) {
      System.out.println("Error reading input file: " + e);
      return;
    }

    try {
      for (long i = 0; i < simulationCount; i++) {
        weatherTower.changeWeather();
      }
      Logger.getInstance().flush();
    } catch (Exception e) {
      System.out.println("Error during simulation: " + e);
      e.printStackTrace();
      return;
    }
  }

  private static void processLine(final String line, final WeatherTower weatherTower) {
    if (line.trim().isEmpty()) {
      System.out.println("Skipping empty line.");
      return;
    }
    String[] parts = line.split(" ");
    if (parts.length < 5) {
      throw new IllegalArgumentException(
          "Invalid input line: '" + line + "'' (expected format: <type> <name> <longitude> <latitude> <height>)");
    }

    final AircraftType type = AircraftType.fromString(parts[0]);
    final String name = parts[1];

    final int longitude = Integer.parseInt(parts[2]);
    final int latitude = Integer.parseInt(parts[3]);

    final int height = Integer.parseInt(parts[4]);
    if (height <= Coordinates.MIN_HEIGHT) {
      throw new IllegalArgumentException("Height must be positive.");
    }

    final Coordinates coordinates = new Coordinates(longitude, latitude, height);
    final Flyable aircraft = AircraftFactory.getInstance().newAircraft(type, name, coordinates);

    weatherTower.register(aircraft);
  }
}
