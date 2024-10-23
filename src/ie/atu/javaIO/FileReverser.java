package ie.atu.javaIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReverser {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("resources/input.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("resources/output.txt"))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            
        } catch (IOException e) {
            System.out.println("Error with file operations: " + e.getMessage());
        }
    }
}