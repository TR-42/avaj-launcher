package fr.ft.kfujita.avaj.simulator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Logger {
  private static final String LOG_FILE = "simulation.txt";

  private static final Logger instance = new Logger();

  private final StringBuffer logBuffer;

  private Logger() {
    logBuffer = new StringBuffer();
  }

  public static Logger getInstance() {
    return instance;
  }

  public void log(String message) {
    synchronized (logBuffer) {
      logBuffer.append(message).append(System.lineSeparator());
    }
  }

  public void flush() throws IOException {
    try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(LOG_FILE), StandardCharsets.UTF_8)) {
      synchronized (logBuffer) {
        writer.write(logBuffer.toString());
        logBuffer.setLength(0);
      }
    }
  }
}
