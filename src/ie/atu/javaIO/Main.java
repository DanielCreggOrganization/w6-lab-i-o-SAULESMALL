package ie.atu.javaIO;

import java.io.FileReader;
import java.io.FileWriter;   
import java.io.IOException;

public class Main {
    public static void main(String[] args) {


            String inputPath = "resources/input.txt";
            String outputPath = "resources/output.txt";
            
            try (FileReader reader = new FileReader(inputPath);
                 FileWriter writer = new FileWriter(outputPath)) {
                
                int character;
                while ((character = reader.read()) != -1) {
                    writer.write(Character.toUpperCase((char) character));
                }
                System.out.println("File copied and converted to uppercase.");
            } catch (IOException e) {
                System.err.println("Error processing file: " + e.getMessage());
            }
    }
}
