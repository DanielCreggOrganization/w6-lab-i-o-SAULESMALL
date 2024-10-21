package ie.atu.javaIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String inputPath = "resources/input.txt";

        try (Stream<String> lines = Files.lines(Paths.get(inputPath))) {
            long lineCount = lines.count();
            System.out.println("Number of lines: " + lineCount);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        try (Stream<String> lines = Files.lines(Paths.get(inputPath))) {
            lines.forEach(line -> System.out.println("Line: " + line));
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
        try (Stream<String> lines = Files.lines(Paths.get(inputPath))) {
            long nonEmptyLines = lines
                    .filter(line -> !line.trim().isEmpty())
                    .count();
            System.out.println("Non-empty lines: " + nonEmptyLines);
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}