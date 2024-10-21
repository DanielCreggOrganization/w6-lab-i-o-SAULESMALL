package ie.atu.javaIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String inputPath = "resources/input.txt";

        countWordsInFile(inputPath);
        filterLinesContainingWord(inputPath, "Java");
        findLongestLine(inputPath);
        wordFrequencyCounter(inputPath);
    }
    // Task 1: Count the Number of Words in the File
    public static void countWordsInFile(String inputPath) {
        try (Stream<String> lines = Files.lines(Paths.get(inputPath))) {
            long wordCount = lines
                .map(line -> line.split("\\s+")) // Split each line into words
                .flatMap(Stream::of)             // Flatten the array of words into a single stream
                .count();                        // Count the words
            System.out.println("Total number of words: " + wordCount);
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
    // Task 2: Filter Lines Containing a Specific Word
    public static void filterLinesContainingWord(String inputPath, String keyword) {
        try (Stream<String> lines = Files.lines(Paths.get(inputPath))) {
            long count = lines
                .filter(line -> line.contains(keyword))  // Filter lines containing the word
                .count();                                // Count the matching lines
            System.out.println("Number of lines containing '" + keyword + "': " + count);
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
    // Task 3: Find the Longest Line in the File
    public static void findLongestLine(String inputPath) {
        try (Stream<String> lines = Files.lines(Paths.get(inputPath))) {
            String longestLine = lines
                .max(Comparator.comparingInt(String::length))  // Find the longest line by length
                .orElse("No lines found.");
            System.out.println("Longest line: " + longestLine);
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
    // Task 4: Word Frequency Counter (Top 5 Most Common Words)
    public static void wordFrequencyCounter(String inputPath) {
        try (Stream<String> lines = Files.lines(Paths.get(inputPath))) {
            Map<String, Long> wordFrequency = lines
                .flatMap(line -> Arrays.stream(line.split("\\s+")))  // Split lines into words
                .collect(Collectors.groupingBy(word -> word.toLowerCase(), Collectors.counting()));  // Count word frequencies

            System.out.println("Top 5 most common words:");
            wordFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed()) // Sort by frequency
                .limit(5)  // Limit to top 5 words
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        }
    }
}